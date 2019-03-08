package com.wesly.learn.model;

/**
 * @author: null
 * @date: 2019-03-08 16:49:23
 * @description:  
 */
public class Config {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String value;

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
     * @return value 
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     *
     * @param value 
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}