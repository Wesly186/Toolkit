package com.wesly.manage.model;

import java.util.Date;

/**
 * @author: null
 * @date: 2019-02-26 17:36:49
 * @description:  
 */
public class User {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String salt;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Boolean locked;

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
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     *
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     *
     * @return salt 
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 
     *
     * @param salt 
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 
     *
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     *
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     *
     * @return locked 
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 
     *
     * @param locked 
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
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