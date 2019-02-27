package com.wesly.manage.model;

import java.util.Date;

/**
 * @author: null
 * @date: 2019-02-26 17:10:34
 * @description:  
 */
public class UserRole {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String roleId;

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
     * @return user_id 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     *
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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