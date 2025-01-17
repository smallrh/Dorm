package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {
    @Select("SELECT c_no, c_name FROM class WHERE m_no = #{mNo}")
    @Results({
            @Result(property = "cNo", column = "c_no"),
            @Result(property = "cName", column = "c_name")
    })
    List<Class> getClassesByMajor(@Param("mNo") String mNo);
}
