package com.mapper;

import com.model.Spchu;
import com.model.Spchu;
import com.model.Uxinxi;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface SpchuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spchu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer spchuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spchu
     *
     * @mbggenerated
     */
    int insert(Spchu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spchu
     *
     * @mbggenerated
     */
    Spchu selectByPrimaryKey(Integer spchuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spchu
     *
     * @mbggenerated
     */
    List<Spchu> selectAll(@Param("spchu")Spchu record,@Param("page")int page,@Param("rows")int rows, @Param("sdate")String sdate, @Param("edate")String edate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spchu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Spchu record);
}