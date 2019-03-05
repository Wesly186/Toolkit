package com.wesly.manage.mapper;

import com.wesly.manage.model.Role;
import com.wesly.manage.model.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: null
 * @date: 2019-02-26 17:10:34
 * @description:  
 */
public interface RoleMapper {
    /**
     * countByExample
     * 
     * @param example RoleExample 
     * @return long 
     */
    long countByExample(RoleExample example);

    /**
     * deleteByExample
     * 
     * @param example RoleExample 
     * @return int 
     */
    int deleteByExample(RoleExample example);

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
     * @param record Role 
     * @return int 
     */
    int insert(Role record);

    /**
     * insertSelective
     * 
     * @param record Role 
     * @return int 
     */
    int insertSelective(Role record);

    /**
     * selectByExample
     * 
     * @param example RoleExample 
     * @return List<Role> 
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id String 
     * @return Role 
     */
    Role selectByPrimaryKey(String id);

    /**
     * updateByExampleSelective
     * 
     * @param record Role 
     * @param example RoleExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * updateByExample
     * 
     * @param record Role 
     * @param example RoleExample 
     * @return int 
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record Role 
     * @return int 
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * updateByPrimaryKey
     * 
     * @param record Role 
     * @return int 
     */
    int updateByPrimaryKey(Role record);
}