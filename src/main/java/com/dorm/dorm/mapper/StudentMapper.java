package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {
    // 根据 s_no 获取 s_name
    @Select("SELECT s_name FROM student WHERE s_no = #{sNo}")
    String getSNameBySNo(@Param("sNo") String sNo);

    @Select("SELECT * FROM student WHERE s_no = #{sNo}")
    @Results({
            @Result(property = "sNo", column = "s_no"),
            @Result(property = "sName", column = "s_name"),
            @Result(property = "sFrom", column = "s_from"),
            @Result(property = "sId", column = "s_id"),
            @Result(property = "sPwd", column = "s_pwd"),
            @Result(property = "sSex", column = "s_sex"),
            @Result(property = "sGrade", column = "s_grade"),
            @Result(property = "sRs", column = "s_rs"),
            @Result(property = "cNo", column = "c_no")
    })
    Student findBySNo(@Param("sNo") String sNo);
}
