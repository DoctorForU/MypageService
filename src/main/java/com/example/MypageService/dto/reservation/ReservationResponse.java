package com.example.MypageService.dto.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReservationResponse { // Front -> 여기서 어떻게 쓰고 싶냐에 따라 '너가' 정하면 된다고요 string 좋으면 string!! 써!!!
    private Long id; // -> 예약 취소용
    private String hpid; // -> 예약 변경용
    private String dutyName;
    private LocalDate reserveDate;
    private String reserveTime;
}
