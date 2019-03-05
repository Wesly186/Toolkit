package com.wesly.manage.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import com.wesly.manage.bean.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResult handleUnKnownException(Exception e) {
        log.error("Returning HTTP 500 Internal Server Error", e);

        return CommonResult.resultError(Integer.valueOf(getLocaleMessage("api.error.code.internal")), getLocaleMessage("api.error.message.internal"));
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public CommonResult handleMethodException(HttpServletRequest request, HttpRequestMethodNotSupportedException exception) {
        log.error("Returning HTTP 405 Method Not Allowed, path is " + request.getRequestURI(), exception);

        return CommonResult.resultError(Integer.valueOf(getLocaleMessage("api.error.code.method_not_allowed")), getLocaleMessage("api.error.message.method_not_allowed") + " " + exception.getMessage());
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CommonResult handleMissingServletRequestParameterException(Exception exception) {
        log.error("Returning HTTP 400 Bad Request cause by ParameterException exception : {}", exception.getMessage());

        return CommonResult.resultError(Integer.valueOf(getLocaleMessage("api.error.code.illegal_parameter")),
                getLocaleMessage("api.error.message.illegal_parameter") + " " + exception.getMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CommonResult handleBusinessException(BusinessException businessException) {
        log.error("Returning HTTP 400 Bad Request cause by business exception : {}", businessException.getMessage());

        CommonResult baseResponse = null;
        if (businessException.isTranslate()) {
            String errorMessage = getLocaleMessage(businessException.getMessage());
            // concat addtional message
            if (!StringUtils.isEmpty(businessException.getAdditionalMessage())) {
                errorMessage = errorMessage + ":" + businessException.getAdditionalMessage();
            }
            baseResponse = CommonResult.resultError(Integer.valueOf(getLocaleMessage(businessException.getCode())), errorMessage);
        } else {
            baseResponse = CommonResult.resultError(Integer.valueOf(businessException.getCode()), businessException.getMessage());
        }
        return baseResponse;
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public CommonResult handleUnauthorizedException(UnauthorizedException unauthorizedException) {
        log.error("Returning HTTP 403 Forbidden cause by unauthorizedException : {}", unauthorizedException.getMessage());

        return CommonResult.resultError(Integer.valueOf(getLocaleMessage("api.error.code.unauthorized")),
                getLocaleMessage("api.error.message.unauthorized") + " " + unauthorizedException.getMessage());
    }

    private String getLocaleMessage(String code, Object... objects) {
        return messageSource.getMessage(code, objects, LocaleContextHolder.getLocale());
    }
}