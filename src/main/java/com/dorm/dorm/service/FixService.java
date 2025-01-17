package com.dorm.dorm.service;

import com.dorm.dorm.dto.FixDTO;
import com.dorm.dorm.entity.Fix;
import com.dorm.dorm.request.FixRequest;

import java.util.List;

public interface FixService {
    public List<FixDTO> getRepairRecords();

    List<Fix> getFixRecordsByRoomNo(String roomNo);

    void submitRepair(FixRequest fixRequest) throws Exception;
}
