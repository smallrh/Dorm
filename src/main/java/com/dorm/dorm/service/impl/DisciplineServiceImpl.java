package com.dorm.dorm.service.impl;

import com.dorm.dorm.dto.DisciplineDTO;
import com.dorm.dorm.entity.Discipline;
import com.dorm.dorm.mapper.DisciplineMapper;
import com.dorm.dorm.mapper.MajorMapper;
import com.dorm.dorm.mapper.StudentMapper;
import com.dorm.dorm.request.DisciplineRequest;
import com.dorm.dorm.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineMapper disciplineMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<DisciplineDTO> getRecentDisciplineRecords() {
        // Step 1: 获取最近三天的日期
        List<Date> recentDates = disciplineMapper.getRecentDisciplineDates();
        if (recentDates == null || recentDates.isEmpty()) {
            return new ArrayList<>();
        }

        // Step 2: 将日期列表转换为逗号分隔的字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datesString = recentDates.stream()
                .map(date -> dateFormat.format(date))
                .collect(Collectors.joining(","));

        // Step 3: 根据这些日期查询违纪记录
        List<Discipline> disciplineList = disciplineMapper.getDisciplineRecordsByDates(datesString);
        if (disciplineList == null || disciplineList.isEmpty()) {
            return new ArrayList<>();
        }
        // Step 4: 转换为 DTO 并获取 sName
        List<DisciplineDTO> disciplineDTOList = new ArrayList<>();
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 格式化输出日期

        for (Discipline discipline : disciplineList) {
            if (discipline != null) {
                // 获取 sName
                String sName = studentMapper.getSNameBySNo(discipline.getSNo());
                String major = disciplineMapper.getMajorBySNo(discipline.getSNo());
                // 格式化日期
                String formattedDate = outputDateFormat.format(discipline.getDTime());
                DisciplineDTO dto = new DisciplineDTO(
                        formattedDate, // 使用格式化后的日期
                        discipline.getDReason(),
                        discipline.getDPanish(),
                        discipline.getDPanishType(),
                        sName,
                        major
                );
                disciplineDTOList.add(dto);
            }
        }

        return disciplineDTOList;
    }

    @Override
    public List<Discipline> getMyDisciplineRecords(DisciplineRequest request) {
        int offset = (request.getPage() - 1) * request.getLimit();
        List<Discipline> disciplineRecordsBySNo = disciplineMapper.getDisciplineRecordsBySNo(request.getSNo(), offset, request.getLimit());
        return disciplineRecordsBySNo;
    }
}