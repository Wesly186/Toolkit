package com.wesly.manage.model;

import java.util.Date;

/**
 * @author: null
 * @date: 2019-02-26 17:10:34
 * @description:  
 */
public class RolePermission {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String roleId;

    /**
     * 
     */
    private String permissionId;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     *
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     *
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 
     *
     * @return role_id 
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 
     *
     * @param roleId 
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 
     *
     * @return permission_id 
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * 
     *
     * @param permissionId 
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    /**
     * 
     *
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     *
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     *
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     *
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}