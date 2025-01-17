package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Consume;
import com.dorm.dorm.request.ConsumeRequest;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ConsumeMapper {
    @Select("SELECT r_no AS rNo, c_year AS cYear, c_month AS cMonth, c_sumwe AS cSumwe, " +
            "c_cwater AS cCwater, c_ccw AS cCcw, c_csum AS cCsum, " +
            "c_hwater AS cHwater, c_hcw AS cHcw, c_hsum AS cHsum, " +
            "c_elec AS cElec, c_ec AS cEc " +
            "FROM consume " +
            "WHERE r_no = #{request.rNo} " +
            "AND c_year = #{request.year} " +
            "AND c_month = #{request.month}")
    Consume consume(@Param("request") ConsumeRequest request);
}
