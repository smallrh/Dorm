package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Fix;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FixMapper {

    @Select("SELECT f.f_rno AS fRno, f.f_sno AS fSno, f.f_start AS fStart, f.f_reason AS fReason, " +
            "f.f_tel AS fTel, f.f_note AS fNote, f.f_end AS fEnd " +
            "FROM fix f " +
            "ORDER BY f.f_start DESC " +
            "LIMIT 6")
    @Results({
            @Result(column = "fRno", property = "fRno"),
            @Result(column = "fSno", property = "fSno"),
            @Result(column = "fStart", property = "fStart"),
            @Result(column = "fReason", property = "fReason"),
            @Result(column = "fTel", property = "fTel"),
            @Result(column = "fNote", property = "fNote"),
            @Result(column = "fEnd", property = "fEnd")
    })
    List<Fix> getRepairRecords();

    @Select("SELECT f_rno, f_sno, f_start, f_reason, f_tel, f_note, f_end FROM fix WHERE f_rno = #{roomNo}")
    @Results({
            @Result(property = "fRno", column = "f_rno"),
            @Result(property = "fSno", column = "f_sno"),
            @Result(property = "fStart", column = "f_start"),
            @Result(property = "fReason", column = "f_reason"),
            @Result(property = "fTel", column = "f_tel"),
            @Result(property = "fNote", column = "f_note"),
            @Result(property = "fEnd", column = "f_end")
    })
    List<Fix> selectFixRecordsByRoomNo(@Param("roomNo") String roomNo);

    @Insert("INSERT INTO fix (f_rno, f_sno, f_start, f_reason, f_tel, f_note) " +
            "VALUES (#{fix.fRno}, #{fix.fSno}, NOW(), #{fix.fReason}, #{fix.fTel}, #{fix.fNote})")
    void insertFixRecord(@Param("fix") Fix fix);
}
