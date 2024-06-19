package com.example.MypageService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Builder
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = false, nullable = false)
    private String userId;

    @Column(name = "hpid", nullable = false)
    private String hpid;

    @Column(name = "duty_name", nullable = false)
    private String dutyName;

    @Column(name = "reserve_date", nullable = false)
    private LocalDate reserveDate;

    @Column(name = "reserve_time", nullable = false)
    private LocalDateTime reserveTime;

    public Reservation(String userId, String hpid, String dutyName, String date, String time){
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH-mm");
        LocalDate reserveDate = LocalDate.parse(date.toString(), formatterDate);
        LocalDateTime reserveTime = LocalDateTime.parse(time.toString(), formatterTime);


        this.userId = userId;
        this.hpid = hpid;
        this.dutyName = dutyName;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
    }
}
