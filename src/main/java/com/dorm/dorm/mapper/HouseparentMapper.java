package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Houseparent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HouseparentMapper {
    @Select("SELECT * FROM houseparent WHERE h_no = #{hNo}")
    Houseparent findByHNo(@Param("hNo") String hNo);
}
