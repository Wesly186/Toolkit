package com.wesly.manage.mapper;

import com.wesly.manage.model.RolePermission;
import com.wesly.manage.model.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-02-26 17:10:34
 * @description:  
 */
public interface RolePermissionMapper {
    /**
     * countByExample
     * 
     * @param example RolePermissionExample 
     * @return long 
     */
    long countByExample(RolePermissionExample example);

    /**
     * deleteByExample
     * 
     * @param example RolePermissionExample 
     * @return int 
     */
    int deleteByExample(RolePermissionExample example);

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
     * @param record RolePermission 
     * @return int 
     */
    int insert(RolePermission record);

    /**
     * insertSelective
     * 
     * @param record RolePermission 
     * @return int 
     */
    int insertSelective(RolePermission record);

    /**
     * selectByExample
     * 
     * @param example RolePermissionExample 
     * @return List<RolePermission> 
     */
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id String 
     * @return RolePermission 
     */
    RolePermission selectByPrimaryKey(String id);

    /**
     * updateByExampleSelective
     * 
     * @param record RolePermission 
     * @param example RolePermissionExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * updateByExample
     * 
     * @param record RolePermission 
     * @param example RolePermissionExample 
     * @return int 
     */
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record RolePermission 
     * @return int 
     */
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * updateByPrimaryKey
     * 
     * @param record RolePermission 
     * @return int 
     */
    int updateByPrimaryKey(RolePermission record);
}