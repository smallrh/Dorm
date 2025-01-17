package com.dorm.dorm.mapper;

import com.dorm.dorm.request.VisitRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitMapper {
    // 插入来访登记记录
    @Insert("INSERT INTO visit (v_name, v_id, s_no, v_start, v_reason, v_end, v_phone) " +
            "VALUES (#{v_name}, #{v_id}, #{s_no}, #{v_start}, #{v_reason}, #{v_end}, #{v_phone})")
    int insertVisitor(VisitRequest visitRequest);
}
