package com.example.MypageService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "favorite_hospital")
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteHospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = false, nullable = false)
    private String userId; // findby를 할 userId

    @Column(name ="hpid", unique = true, nullable = false) // 병원 코드는 병원별로 하나임
    private String hpid; // 병원 코드

    @Column(name ="dutyName", nullable = false)  // 보여줄 값
    private String dutyName; // 병원명

    @Column(name ="dutyAddr", nullable = false)  // 보여줄 값
    private String dutyAddr; // 병원주소

    @Column(name ="dutyTel1", nullable = false)  // 보여줄 값
    private String dutyTel1; // 병원번호


}
