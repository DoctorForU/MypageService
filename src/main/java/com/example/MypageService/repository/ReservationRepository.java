package com.example.MypageService.repository;

import com.example.MypageService.entity.Inquiry;
import com.example.MypageService.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT h FROM Reservation h WHERE h.userId = :userId")
    List<Reservation> findByUserId(@Param("userId") String userId);

    long countByHpidAndConfirmed(String hpid, boolean confirmed);

}
