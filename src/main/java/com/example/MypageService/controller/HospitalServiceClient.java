package com.example.MypageService.controller;

import com.example.MypageService.dto.FavoriteHospitalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hospital-service", url = "http://localhost:8000" ) // 관심병원을 달기 위해 DATA를 다른 프로젝트에서 요청하기
public interface HospitalServiceClient {
    @GetMapping(value = "/registerFavoriteHospital") // /hospital-service/favoriteHospital
    ResponseEntity<FavoriteHospitalResponse> registerFavoriteHospital(@RequestParam String hpid);
}
