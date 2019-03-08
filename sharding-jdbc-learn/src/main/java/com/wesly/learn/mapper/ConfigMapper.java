package com.wesly.learn.mapper;

import com.wesly.learn.model.Config;
import com.wesly.learn.model.ConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author: null
 * @date: 2019-03-08 16:49:23
 * @description:  
 */
public interface ConfigMapper {
    /**
     * countByExample
     * 
     * @param example ConfigExample 
     * @return long 
     */
    long countByExample(ConfigExample example);

    /**
     * deleteByExample
     * 
     * @param example ConfigExample 
     * @return int 
     */
    int deleteByExample(ConfigExample example);

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
     * @param record Config 
     * @return int 
     */
    int insert(Config record);

    /**
     * insertSelective
     * 
     * @param record Config 
     * @return int 
     */
    int insertSelective(Config record);

    /**
     * selectByExample
     * 
     * @param example ConfigExample 
     * @return List<Config> 
     */
    List<Config> selectByExample(ConfigExample example);

    /**
     * selectByPrimaryKey
     * 
     * @param id Long 
     * @return Config 
     */
    Config selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * 
     * @param record Config 
     * @param example ConfigExample 
     * @return int 
     */
    int updateByExampleSelective(@Param("record") Config record, @Param("example") ConfigExample example);

    /**
     * updateByExample
     * 
     * @param record Config 
     * @param example ConfigExample 
     * @return int 
     */
    int updateByExample(@Param("record") Config record, @Param("example") ConfigExample example);

    /**
     * updateByPrimaryKeySelective
     * 
     * @param record Config 
     * @return int 
     */
    int updateByPrimaryKeySelective(Config record);

    /**
     * updateByPrimaryKey
     * 
     * @param record Config 
     * @return int 
     */
    int updateByPrimaryKey(Config record);
}