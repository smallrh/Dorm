package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 查询所有系别
    @Select("SELECT d_no AS dNo, d_name AS dName FROM dept")
    List<Dept> selectAllDepts();
}
