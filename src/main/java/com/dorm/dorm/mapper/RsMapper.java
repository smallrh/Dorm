package com.dorm.dorm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RsMapper {
    @Select("SELECT r_no FROM rs WHERE s_no = #{sNo}")
    String getRoomNoBySNo(String sNo);

    @Select("SELECT s.s_no AS sNo, s.s_name AS sName, c.c_name AS className, " +
            "m.m_name AS majorName, r.r_no AS roomNo, b.b_dno AS buildingNo " +
            "FROM student s " +
            "LEFT JOIN class c ON s.c_no = c.c_no " +
            "LEFT JOIN major m ON c.m_no = m.m_no " +
            "LEFT JOIN rs ON s.s_no = rs.s_no " +
            "LEFT JOIN room r ON rs.r_no = r.r_no " +
            "LEFT JOIN building b ON r.b_dno = b.b_dno " +
            "WHERE r.r_no = #{roomNo}")
    List<Map<String, Object>> getStudentInfoByRoomNo(String roomNo);
}