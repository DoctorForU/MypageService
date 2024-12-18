package com.example.MypageService.service;


import com.example.MypageService.dto.reservation.GetReservationRequest;
import com.example.MypageService.dto.reservation.ReservationConverter;
import com.example.MypageService.dto.reservation.RegisterReservationRequest;
import com.example.MypageService.dto.reservation.ReservationResponse;
import com.example.MypageService.entity.Reservation;
import com.example.MypageService.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<ReservationResponse> getReservation(GetReservationRequest getReservationRequest) {
        List<Reservation> reservationList = reservationRepository.findByUserId(getReservationRequest.getUserId());
        return ReservationConverter.toResponseList(reservationList);
    }

    public void registerReservation(RegisterReservationRequest reservationRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate reserveDate = LocalDate.parse(reservationRequest.getReserveDate(), formatter);
        logger.info("after format");
        Reservation newReservation = new Reservation();

        newReservation.setUserId(reservationRequest.getUserId());
        newReservation.setHpid(reservationRequest.getHpid());
        newReservation.setDutyName(reservationRequest.getDutyName());
        newReservation.setReserveDate(reserveDate);
        newReservation.setReserveTime(reservationRequest.getReserveTime());


        logger.info("newReservation: " + newReservation);
        reservationRepository.save(newReservation);
    }

    public void deleteReservation(String reservationId){
        Long id = Long.parseLong(reservationId);
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            logger.info("Deleted reservation with ID: " + reservationId);
        } else {
            logger.warn("Reservation with ID: " + reservationId + " does not exist.");
        }
    }
}
