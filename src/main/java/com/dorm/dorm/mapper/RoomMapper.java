package com.dorm.dorm.mapper;

import com.dorm.dorm.entity.Room;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RoomMapper {
    @Select("SELECT b.b_dno FROM room r JOIN building b ON r.b_dno = b.b_dno WHERE r.r_no = #{roomNo}")
    String getBuildingNoByRoom(@Param("roomNo") String roomNo);

    // 根据房间号获取房间信息
    @Select("SELECT r_no FROM room WHERE r_no = #{rNo}")
    String getRoomByRNo(String rNo);
}
