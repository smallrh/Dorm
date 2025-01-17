package com.dorm.dorm.service;

import com.dorm.dorm.dto.DisciplineDTO;
import com.dorm.dorm.entity.Discipline;
import com.dorm.dorm.request.DisciplineRequest;

import java.util.List;

public interface DisciplineService {
    List<DisciplineDTO> getRecentDisciplineRecords();

    List<Discipline> getMyDisciplineRecords(DisciplineRequest request);
}
