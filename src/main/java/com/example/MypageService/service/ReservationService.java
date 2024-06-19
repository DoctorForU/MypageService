package com.example.MypageService.service;


import com.example.MypageService.dto.reservation.ReservationConverter;
import com.example.MypageService.dto.reservation.ReservationRequest;
import com.example.MypageService.dto.reservation.ReservationResponse;
import com.example.MypageService.entity.Inquiry;
import com.example.MypageService.entity.Reservation;
import com.example.MypageService.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<ReservationResponse> getReservation(Reservation reservation) {
        List<Reservation> reservationList = reservationRepository.findByUserId(reservation.getUserId());
        return ReservationConverter.toResponseList(reservationList);
    }

    public void registerReservation(ReservationRequest reservationRequest) {
        Reservation newReservation = new Reservation(
                reservationRequest.getUserId(),
                reservationRequest.getHpid(),
                reservationRequest.getDutyName(),
                reservationRequest.getReserveDate(),
                reservationRequest.getReserveTime()
        );

        logger.info("newReservation: " + newReservation);
        reservationRepository.save(newReservation);
    }

    public void deleteReservation(Long reservationId){
        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
            logger.info("Deleted reservation with ID: " + reservationId);
        } else {
            logger.warn("Reservation with ID: " + reservationId + " does not exist.");
        }
    }
}
