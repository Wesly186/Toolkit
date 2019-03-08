package com.wesly.learn.mapper;

import com.wesly.learn.model.Order;
import com.wesly.learn.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-03-08 16:49:23
 * @description:  
 */
public interface OrderMapper {
    /**
     * countByExample
     * 
     * @param example OrderExample 
     * @return long 
     */
    long countByExample(OrderExample example);

    /**
     * deleteByExample
     * 
     * @param example OrderExample 
     * @return int 
     */
    int deleteByExample(OrderExample example);

    /**
     * deleteByPrimaryKey
     * 
     * @param id Long 
     * @return int 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     * 
     * @param record Order 
     * @return int 
     */
    int insert(Order record);

    /**
     * insertSelective
     * 
     * @param record Order 
     * @return int 
     */
    int insertSelective(Order record);

    /**
     * selectByExample
     * 
     * @param example OrderExample 
     * @return List<Order> 
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id Long 
     * @return Order 
     */
    Order selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * 
     * @param record Order 
     * @param example OrderExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * updateByExample
     * 
     * @param record Order 
     * @param example OrderExample 
     * @return int 
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record Order 
     * @return int 
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * updateByPrimaryKey
     * 
     * @param record Order 
     * @return int 
     */
    int updateByPrimaryKey(Order record);
}