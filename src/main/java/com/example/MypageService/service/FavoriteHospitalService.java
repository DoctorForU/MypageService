package com.example.MypageService.service;

import com.example.MypageService.controller.HospitalServiceClient;
import com.example.MypageService.dto.FavoriteHospitalResponse;
import com.example.MypageService.dto.FavoriteHospitalWithCountResponse;
import com.example.MypageService.entity.FavoriteHospital;
import com.example.MypageService.repository.FavoriteHospitalRepository;
import com.example.MypageService.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteHospitalService {
    private static final Logger logger = LoggerFactory.getLogger(FavoriteHospitalService.class);

    @Autowired
    private FavoriteHospitalRepository favoriteHospitalRepository;
    @Autowired
    private HospitalServiceClient hospitalServiceClient;

    ///////// 관심 병원 저장 로직 //////////////////////////////////////////////////////////////////////////////////////////////////////
    public FavoriteHospitalResponse registerFavoriteHospital(String hpid, String userId) { // hpid랑 userId 프론트에서 받아야 하는 값
        // openFeign -> hospital-service
        ResponseEntity<FavoriteHospitalResponse> responseEntity = hospitalServiceClient.registerFavoriteHospital(hpid);
        FavoriteHospitalResponse favoriteHospitalResponse = responseEntity.getBody();

        if (favoriteHospitalResponse != null) {
            // 데이터 저장
            saveFavoriteHospital(favoriteHospitalResponse, userId);
        } else {
            logger.error("Failed to fetch data from hospital-service");
        }

        return favoriteHospitalResponse;
    }

    private void saveFavoriteHospital(FavoriteHospitalResponse response, String userId) {
        FavoriteHospital favoriteHospital = FavoriteHospital.builder()
                .userId(userId)
                .hpid(response.getHpid())
                .dutyName(response.getDutyName())
                .dutyAddr(response.getDutyAddr())
                .dutyTel1(response.getDutyTel1())
                //.diagnosisCount(0)  // 초기값 설정 -> reservation 엔티티 설계되면 해보기
                .build();

        favoriteHospitalRepository.save(favoriteHospital);
    }



    public List<FavoriteHospitalResponse> getFavoriteHospital(String userId) {
        List<FavoriteHospital> favoriteHospitals = favoriteHospitalRepository.findByUserId(userId);
        return favoriteHospitals.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private FavoriteHospitalResponse convertToDto(FavoriteHospital favoriteHospital) {
        return FavoriteHospitalResponse.builder()
                .hpid(favoriteHospital.getHpid())
                .dutyName(favoriteHospital.getDutyName())
                .dutyAddr(favoriteHospital.getDutyAddr())
                .dutyTel1(favoriteHospital.getDutyTel1())
                .build();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





}
