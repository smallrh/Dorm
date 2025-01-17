package com.dorm.dorm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.dorm.dorm.entity.Admin;

@Mapper
public interface AdminMapper {

    @Select("SELECT COUNT(*) FROM admin WHERE a_no = #{username} AND a_pwd = #{password}")
    int countAdminByCredentials(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM admin WHERE a_no = #{aNo}")
    Admin findByANo(@Param("aNo") String aNo);
}
