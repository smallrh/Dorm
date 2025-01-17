package com.dorm.dorm.service.impl;

import com.dorm.dorm.dto.FixDTO;
import com.dorm.dorm.entity.Fix;
import com.dorm.dorm.mapper.FixMapper;
import com.dorm.dorm.mapper.RoomMapper;
import com.dorm.dorm.request.FixRequest;
import com.dorm.dorm.service.FixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FixServiceImpl implements FixService {

    @Autowired
    private FixMapper fixMapper;

    @Autowired
    private RoomMapper roomMapper; // 需要创建一个 RoomMapper 来根据房间号获取楼号

    @Override
    public List<FixDTO> getRepairRecords() {
        // 从数据库获取维修记录
        List<Fix> fixList = fixMapper.getRepairRecords();

        // 创建一个 List 来存放转换后的 FixDTO 对象
        List<FixDTO> fixDTOList = new ArrayList<>();

        for (Fix fix : fixList) {
            // 通过房间号(fRno)获取楼号(bNo)
            String bNo = getBuildingNoByRoom(fix.getFRno());

            // 创建 FixDTO 对象，并将维修记录和楼号添加进去
            FixDTO fixDTO = new FixDTO(fix.getFStart(), fix.getFReason(), fix.getFRno(), bNo);
            fixDTOList.add(fixDTO);
        }

        return fixDTOList;
    }

    // 根据房间号查询对应的楼号
    private String getBuildingNoByRoom(String roomNo) {
        // 使用 roomMapper 根据房间号查询楼号
        return roomMapper.getBuildingNoByRoom(roomNo);
    }

    @Override
    public List<Fix> getFixRecordsByRoomNo(String roomNo) {
        return fixMapper.selectFixRecordsByRoomNo(roomNo);
    }

    public void submitRepair(FixRequest fixRequest) {
        Fix fix = new Fix();
        fix.setFRno(fixRequest.getFRno());
        fix.setFSno(fixRequest.getFSno());
        fix.setFStart(new Date()); // 设置当前时间为申请时间
        fix.setFReason(fixRequest.getFReason());
        fix.setFTel(fixRequest.getFTel());
        fix.setFNote(fixRequest.getFNote());
        fix.setFEnd(null); // 完成时间初始为 null

        fixMapper.insertFixRecord(fix);
    }
}
