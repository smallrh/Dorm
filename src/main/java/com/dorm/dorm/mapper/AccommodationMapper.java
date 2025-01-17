package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Accommodation;
import com.dorm.dorm.entity.Room;
import com.dorm.dorm.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccommodationMapper {

    // 插入住宿申请记录
    @Insert("INSERT INTO accommodation (s_no, r_no, ac_date, ac_reason, ac_state, ac_note, ac_tel) " +
            "VALUES (#{sNo}, #{rNo}, #{acDate}, #{acReason}, #{acState}, #{acNote}, #{acTel})")
    int insert(Accommodation accommodation);

    // 根据学号获取学生信息
    @Select("SELECT * FROM student WHERE s_no = #{sNo}")
    Student getStudentBySNo(String sNo);

    // 根据房间号获取房间信息
    @Select("SELECT * FROM room WHERE r_no = #{rNo}")
    Room getRoomByRNo(String rNo);
}

