package com.wesly.learn.mapper;

import com.wesly.learn.model.MessageRecord;
import com.wesly.learn.model.MessageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-03-08 16:49:23
 * @description:  
 */
public interface MessageRecordMapper {
    /**
     * countByExample
     * 
     * @param example MessageRecordExample 
     * @return long 
     */
    long countByExample(MessageRecordExample example);

    /**
     * deleteByExample
     * 
     * @param example MessageRecordExample 
     * @return int 
     */
    int deleteByExample(MessageRecordExample example);

    /**
     * deleteByPrimaryKey
     * 
     * @param id Long 
     * @return int 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     * 
     * @param record MessageRecord 
     * @return int 
     */
    int insert(MessageRecord record);

    /**
     * insertSelective
     * 
     * @param record MessageRecord 
     * @return int 
     */
    int insertSelective(MessageRecord record);

    /**
     * selectByExample
     * 
     * @param example MessageRecordExample 
     * @return List<MessageRecord> 
     */
    List<MessageRecord> selectByExample(MessageRecordExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id Long 
     * @return MessageRecord 
     */
    MessageRecord selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * 
     * @param record MessageRecord 
     * @param example MessageRecordExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    /**
     * updateByExample
     * 
     * @param record MessageRecord 
     * @param example MessageRecordExample 
     * @return int 
     */
    int updateByExample(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record MessageRecord 
     * @return int 
     */
    int updateByPrimaryKeySelective(MessageRecord record);

    /**
     * updateByPrimaryKey
     * 
     * @param record MessageRecord 
     * @return int 
     */
    int updateByPrimaryKey(MessageRecord record);
}