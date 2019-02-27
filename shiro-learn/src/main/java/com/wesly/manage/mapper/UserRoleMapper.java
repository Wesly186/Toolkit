package com.wesly.manage.mapper;

import com.wesly.manage.model.UserRole;
import com.wesly.manage.model.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-02-26 17:10:34
 * @description:  
 */
public interface UserRoleMapper {
    /**
     * countByExample
     * 
     * @param example UserRoleExample 
     * @return long 
     */
    long countByExample(UserRoleExample example);

    /**
     * deleteByExample
     * 
     * @param example UserRoleExample 
     * @return int 
     */
    int deleteByExample(UserRoleExample example);

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
     * @param record UserRole 
     * @return int 
     */
    int insert(UserRole record);

    /**
     * insertSelective
     * 
     * @param record UserRole 
     * @return int 
     */
    int insertSelective(UserRole record);

    /**
     * selectByExample
     * 
     * @param example UserRoleExample 
     * @return List<UserRole> 
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id String 
     * @return UserRole 
     */
    UserRole selectByPrimaryKey(String id);

    /**
     * updateByExampleSelective
     * 
     * @param record UserRole 
     * @param example UserRoleExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * updateByExample
     * 
     * @param record UserRole 
     * @param example UserRoleExample 
     * @return int 
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record UserRole 
     * @return int 
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * updateByPrimaryKey
     * 
     * @param record UserRole 
     * @return int 
     */
    int updateByPrimaryKey(UserRole record);
}