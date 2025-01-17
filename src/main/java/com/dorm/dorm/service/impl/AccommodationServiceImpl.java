package com.dorm.dorm.service.impl;

import com.dorm.dorm.entity.Accommodation;
import com.dorm.dorm.mapper.AccommodationMapper;
import com.dorm.dorm.mapper.RoomMapper;
import com.dorm.dorm.mapper.StudentMapper;
import com.dorm.dorm.request.AccommodationRequest;
import com.dorm.dorm.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    private AccommodationMapper accommodationMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public boolean requestAccommodation(AccommodationRequest accommodationRequest) {
        // 检查学生学号是否有效
        if (studentMapper.getSNameBySNo(accommodationRequest.getSNo()) == null) {
            return false;  // 学号无效
        }

        // 检查房间号是否有效
        if (roomMapper.getRoomByRNo(accommodationRequest.getRNo()) == null) {
            return false;  // 房间号无效
        }

        // 构建 Accommodation 实体类并保存
        Accommodation accommodation = new Accommodation();
        accommodation.setSNo(accommodationRequest.getSNo());
        accommodation.setRNo(accommodationRequest.getRNo());
        accommodation.setAcDate(convertStringToDate(accommodationRequest.getAcDate()));
        accommodation.setAcReason(accommodationRequest.getAcReason());
        accommodation.setAcState("未审核");  // 默认设置为“未审核”
        accommodation.setAcNote(accommodationRequest.getAcNote());
        accommodation.setAcTel(accommodationRequest.getAcTel());

        // 插入数据库
        return accommodationMapper.insert(accommodation) > 0;
    }

    public Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 根据你的日期格式调整
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // 或者抛出异常，根据你的需求处理
        }
    }
}

