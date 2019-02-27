package com.wesly.manage.mapper;

import com.wesly.manage.model.User;
import com.wesly.manage.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-02-26 17:36:49
 * @description:  
 */
public interface UserMapper {
    /**
     * countByExample
     * 
     * @param example UserExample 
     * @return long 
     */
    long countByExample(UserExample example);

    /**
     * deleteByExample
     * 
     * @param example UserExample 
     * @return int 
     */
    int deleteByExample(UserExample example);

    /**
     * deleteByPrimaryKey
     * 
     * @param id String 
     * @return int 
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert
     * 
     * @param record User 
     * @return int 
     */
    int insert(User record);

    /**
     * insertSelective
     * 
     * @param record User 
     * @return int 
     */
    int insertSelective(User record);

    /**
     * selectByExample
     * 
     * @param example UserExample 
     * @return List<User> 
     */
    List<User> selectByExample(UserExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id String 
     * @return User 
     */
    User selectByPrimaryKey(String id);

    /**
     * updateByExampleSelective
     * 
     * @param record User 
     * @param example UserExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * updateByExample
     * 
     * @param record User 
     * @param example UserExample 
     * @return int 
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record User 
     * @return int 
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * updateByPrimaryKey
     * 
     * @param record User 
     * @return int 
     */
    int updateByPrimaryKey(User record);
}