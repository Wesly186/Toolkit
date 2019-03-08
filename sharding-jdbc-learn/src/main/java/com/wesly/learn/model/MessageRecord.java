package com.wesly.learn.model;

/**
 * @author: null
 * @date: 2019-03-08 16:49:23
 * @description:  
 */
public class MessageRecord {
    /**
     * 主键
     */
    private Long id;

    /**
     * 主键
     */
    private Long appId;

    /**
     * 手机号
     */
    private Long phone;

    /**
     * 平台
     */
    private String platform;

    /**
     * 接口返回状态码
     */
    private String code;

    /**
     * 接口详细信息
     */
    private String message;

    /**
     * 请求流水号，可供查询结果
     */
    private String serialNum;

    /**
     * 具体d短信平台的业务id，可以查询结果
     */
    private String businessId;

    /**
     * 主键
     *
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 主键
     *
     * @return app_id 主键
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 主键
     *
     * @param appId 主键
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 手机号
     *
     * @return phone 手机号
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * 手机号
     *
     * @param phone 手机号
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * 平台
     *
     * @return platform 平台
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 平台
     *
     * @param platform 平台
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * 接口返回状态码
     *
     * @return code 接口返回状态码
     */
    public String getCode() {
        return code;
    }

    /**
     * 接口返回状态码
     *
     * @param code 接口返回状态码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 接口详细信息
     *
     * @return message 接口详细信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 接口详细信息
     *
     * @param message 接口详细信息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 请求流水号，可供查询结果
     *
     * @return serial_num 请求流水号，可供查询结果
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * 请求流水号，可供查询结果
     *
     * @param serialNum 请求流水号，可供查询结果
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    /**
     * 具体d短信平台的业务id，可以查询结果
     *
     * @return business_id 具体d短信平台的业务id，可以查询结果
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * 具体d短信平台的业务id，可以查询结果
     *
     * @param businessId 具体d短信平台的业务id，可以查询结果
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }
}