package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorMapper {
    // 查询所有专业
    @Select("SELECT m_no, m_name,m_year,d_no FROM major")
    @Results({
            @Result(column = "m_no", property = "mNo"),
            @Result(column = "m_name", property = "mName"),
            @Result(column = "m_year", property = "mYear"),
            @Result(column = "d_no", property = "dNo"),
    })
    List<Major> getAllMajors();

    @Select("SELECT * FROM major WHERE d_no = #{dNo}")
    @Results({
            @Result(column = "m_no", property = "mNo"),
            @Result(column = "m_name", property = "mName"),
            @Result(column = "m_year", property = "mYear"),
            @Result(column = "d_no", property = "dNo"),
    })
    List<Major> getMajorByDept(String dNo);
}
