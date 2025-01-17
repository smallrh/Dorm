package com.dorm.dorm.service.impl;

import com.dorm.dorm.mapper.RsMapper;
import com.dorm.dorm.service.RsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RsServiceImpl implements RsService {

    @Autowired
    private RsMapper rsMapper;

    @Override
    public List<Map<String, Object>> getRoommatesInfoBySNo(String sNo) {
        String roomNo = rsMapper.getRoomNoBySNo(sNo);
        if (roomNo == null) {
            return new ArrayList<>();
        }
        return rsMapper.getStudentInfoByRoomNo(roomNo);
    }
}