package com.example.MypageService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FavoriteHospitalWithCountResponse { // MYPAGE에 상단에 보여줄 데이터 리스트
    private String dutyName; // 병원명
    private String dutyAddr; // 병원 주소
    private String dutyTel1; // 병원 대표번호
    private long confirmedReservationCount; // 예약 확정횟수
}
