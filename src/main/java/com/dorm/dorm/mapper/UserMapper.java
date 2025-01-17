package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM student WHERE s_no = #{username} AND s_pwd = #{password}")
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
    Student getStudentByCredentials(@Param("username") String username, @Param("password") String password);


    // 检查用户名是否存在
    @Select("SELECT COUNT(1) FROM student WHERE s_no = #{username}")
    boolean existsByUsername(@Param("username") String username);

    // 保存新用户
    @Insert("INSERT INTO student(s_no, s_name, s_pwd, s_sex, s_grade, s_rs, s_from, c_no, s_id) " +
            "VALUES(#{sNo}, #{sName}, #{sPwd}, #{sSex}, #{sGrade}, #{sRs}, #{sFrom}, #{cNo}, #{sId})")
    @Options(useGeneratedKeys = true, keyProperty = "sNo", keyColumn = "s_no")
    // 自动生成并填充主键
    void save(Student newUser);

    @Update("UPDATE student SET s_pwd = #{newPassword} WHERE s_no = #{sNo}")
    void updatePassword(@Param("newPassword") String newPassword, @Param("sNo") String sNo);
}
