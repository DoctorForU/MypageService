//package com.example.MypageService.controller;
//
//import com.example.MypageService.dto.FavoriteHospitalResponse;
//import com.example.MypageService.dto.FavoriteHospitalWithCountResponse;
//import com.example.MypageService.service.FavoriteHospitalService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/mypage-service")
//public class FavoriteHospitalController {
//    @Autowired
//    private FavoriteHospitalService favoriteHospitalService;
//
//    @PostMapping("/favorite") // openfeign을 이용해 데이터 저장  -> hospitalList에 '관심병원 버튼'에 연결하는 컨트롤러
//    public ResponseEntity<FavoriteHospitalResponse> registerFavoriteHospital(@RequestParam String hpid, @RequestParam String userId) { // 이걸 바디로 보내던가 방법을 바꾸는 게 좋음
//        FavoriteHospitalResponse response = favoriteHospitalService.registerFavoriteHospital(hpid, userId);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/favorite-hospitals")
//    public ResponseEntity<List<FavoriteHospitalWithCountResponse>> getFavoriteHospitals(@RequestParam String userId) {  // 로그인 후 mypage에 들어갈 때 -> 자동으로 렌더링되어서 관심병원 리스트가 상단에 나오게 할 때 부르는 컨트롤러
//        List<FavoriteHospitalWithCountResponse> favoriteHospitals = favoriteHospitalService.getFavoriteHospitalsWithReservationCount(userId);
//        return ResponseEntity.ok(favoriteHospitals);
//    }
//}
//
