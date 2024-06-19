package com.example.MypageService.controller;

import com.example.MypageService.api.CommonResponse;
import com.example.MypageService.dto.reservation.ReservationRequest;
import com.example.MypageService.dto.reservation.ReservationResponse;
import com.example.MypageService.entity.Reservation;
import com.example.MypageService.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage-service")
public class ReservationController {
    private final ReservationService reservationService;
    private static final Logger logger = LoggerFactory.getLogger(HealthCareController.class);

    @GetMapping("/reservation") //
    public List<ReservationResponse> getReservation(@RequestBody Reservation reservation){
        logger.info("userId: " + reservation.getUserId());

        return reservationService.getReservation(reservation);
    }

    @PostMapping("/reservation/register")
    public CommonResponse<String> registerReservation(@RequestBody ReservationRequest reservationRequest){
        logger.info("userId: " + reservationRequest.getUserId() + " reserveTime: " + reservationRequest.getReserveTime());
        logger.info("getReserveDate: " + reservationRequest.getReserveDate() + " getDutyName: " + reservationRequest.getDutyName());
        reservationService.registerReservation(reservationRequest);
        return CommonResponse.ok("예약 완료");
    }

    @DeleteMapping("/reservation/{reservationId}")
    public CommonResponse<String> deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return CommonResponse.ok("예약 취소 완료");
    }
}
