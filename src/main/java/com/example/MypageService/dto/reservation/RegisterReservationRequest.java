package com.example.MypageService.dto.reservation;

import lombok.Data;

@Data
public class RegisterReservationRequest {
    private String userId; // 유저 ID -> 세션
    private String hpid; // 병원코드
    private String dutyName; // 병원이름
    private String reserveDate; // "yyyy-MM-dd" 형식으로 받아 처리
    private String reserveTime; // 시간 -> "HH-MM"
}