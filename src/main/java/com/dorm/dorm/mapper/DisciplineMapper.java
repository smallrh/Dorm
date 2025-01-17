package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Discipline;
import org.apache.ibatis.annotations.*;

import java.util.Date;

import java.util.List;

@Mapper
public interface DisciplineMapper {
    @Select("SELECT DISTINCT d_time FROM discipline ORDER BY d_time DESC LIMIT 3")
    List<Date> getRecentDisciplineDates();

    // 根据最新的违纪时间，获取最近三天的违纪记录
    @Select("SELECT * FROM discipline "
            + "WHERE FIND_IN_SET(d_time, #{dates}) "
            + "ORDER BY d_time DESC")
    @Results({
            @Result(column = "d_no", property = "dNo")
            , @Result(column = "s_no", property = "sNo")
            , @Result(column = "d_time", property = "dTime")
            , @Result(column = "d_reason", property = "dReason")
            , @Result(column = "d_panish", property = "dPanish")
            , @Result(column = "d_panish_type", property = "dPanishType")
    })
    List<Discipline> getDisciplineRecordsByDates(@Param("dates") String dates);

    // 根据 s_no 获取 major
    @Select("SELECT m.m_name FROM major m "
            + "JOIN class c ON m.m_no = c.m_no "
            + "JOIN student s ON c.c_no = s.c_no "
            + "WHERE s.s_no = #{sNo}")
    String getMajorBySNo(@Param("sNo") String sNo);

    @Select("SELECT d_no, s_no, d_time, d_reason, d_panish,d_panishType " +
            "FROM discipline " +
            "WHERE s_no = #{sNo} " +
            "LIMIT #{page}, #{limit}")
    @Results({
            @Result(column = "d_no", property = "dNo")
            , @Result(column = "s_no", property = "sNo")
            , @Result(column = "d_time", property = "dTime")
            , @Result(column = "d_reason", property = "dReason")
            , @Result(column = "d_panish", property = "dPanish")
            , @Result(column = "d_panishType", property = "dPanishType")
    })
    List<Discipline> getDisciplineRecordsBySNo(@Param("sNo") String sNo, @Param("page") int page, @Param("limit") int limit);
}


