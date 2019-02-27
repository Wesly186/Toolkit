package com.wesly.manage.mapper;

import com.wesly.manage.model.Permission;
import com.wesly.manage.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-02-26 18:25:07
 * @description:  
 */
public interface PermissionMapper {
    /**
     * countByExample
     * 
     * @param example PermissionExample 
     * @return long 
     */
    long countByExample(PermissionExample example);

    /**
     * deleteByExample
     * 
     * @param example PermissionExample 
     * @return int 
     */
    int deleteByExample(PermissionExample example);

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
     * @param record Permission 
     * @return int 
     */
    int insert(Permission record);

    /**
     * insertSelective
     * 
     * @param record Permission 
     * @return int 
     */
    int insertSelective(Permission record);

    /**
     * selectByExample
     * 
     * @param example PermissionExample 
     * @return List<Permission> 
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id String 
     * @return Permission 
     */
    Permission selectByPrimaryKey(String id);

    /**
     * updateByExampleSelective
     * 
     * @param record Permission 
     * @param example PermissionExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * updateByExample
     * 
     * @param record Permission 
     * @param example PermissionExample 
     * @return int 
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record Permission 
     * @return int 
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * updateByPrimaryKey
     * 
     * @param record Permission 
     * @return int 
     */
    int updateByPrimaryKey(Permission record);
}