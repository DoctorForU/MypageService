package com.example.MypageService.dto.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReservationResponse {
    private Long id; // -> 예약 취소용
    private String hpid; // -> 예약 변경용
    private String dutyName;
    private LocalDate reserveDate;
    private LocalDateTime reserveTime;
}
