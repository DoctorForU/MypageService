package com.example.MypageService.dto.reservation;

import lombok.Data;

@Data
public class ReservationRequest {
    private String userId;
    private String hpid;
    private String dutyName;
    private String reserveDate; // "yyyy-MM-dd" 형식으로 받아 처리
    private String reserveTime;
}