package com.example.MypageService.repository;

import com.example.MypageService.entity.FavoriteHospital;
import com.example.MypageService.entity.HealthCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteHospitalRepository extends JpaRepository<FavoriteHospital, Long> {
    List<FavoriteHospital> findByUserId(String userId);
}
