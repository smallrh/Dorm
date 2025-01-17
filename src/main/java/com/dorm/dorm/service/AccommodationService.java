package com.dorm.dorm.service;

import com.dorm.dorm.request.AccommodationRequest;

public interface AccommodationService {

    // 处理住宿申请
    boolean requestAccommodation(AccommodationRequest accommodationRequest);
}

