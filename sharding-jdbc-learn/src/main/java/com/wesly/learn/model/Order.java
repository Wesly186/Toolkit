package com.wesly.learn.model;

/**
 * @author: null
 * @date: 2019-03-08 16:49:23
 * @description:  
 */
public class Order {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long appId;

    /**
     * 
     */
    private Long phone;

    /**
     * 
     *
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     *
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     *
     * @return app_id 
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 
     *
     * @param appId 
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 
     *
     * @return phone 
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * 
     *
     * @param phone 
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }
}