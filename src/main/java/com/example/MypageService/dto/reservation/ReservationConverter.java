package com.example.MypageService.dto.reservation;

import com.example.MypageService.dto.health.HealthCareConverter;
import com.example.MypageService.dto.health.HealthResponse;
import com.example.MypageService.entity.HealthCare;
import com.example.MypageService.entity.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationConverter {
    public static ReservationResponse toResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .hpid(reservation.getHpid())
                .dutyName(reservation.getDutyName())
                .reserveDate(reservation.getReserveDate())
                .reserveTime(reservation.getReserveTime())
                .build();
    }

    public static List<ReservationResponse> toResponseList(List<Reservation> reservationList) {
        return reservationList.stream()
                .map(ReservationConverter::toResponse)
                .collect(Collectors.toList());
    }
}
