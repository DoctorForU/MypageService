package com.example.MypageService.controller;

import com.example.MypageService.dto.ApiServerRequest;
import com.example.MypageService.dto.ApiServerResponse;
import com.example.MypageService.dto.TreatResponse;
import com.example.MypageService.service.EasyResponseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage-service")
public class EasyResponseController {
//    @Autowired
//    private EasyResponseClient easyResponseClient;
    private final EasyResponseService easyResponseService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${api.access.token}")
    private String token;


    @PostMapping("/callGetTreat")
    public ResponseEntity<List<TreatResponse>> callGetTreat(@RequestBody ApiServerRequest apiServerRequest) { // post로 주민번호를 프론트에서 받아야함 // 이거 request를 그냥 token없애고 토큰을 받는 로직 추가 하면 더 좋음
        apiServerRequest.setToken(token);
        // 여기토큰 configserver로 관리해서 사용하기
        logger.info("request userIdentity: " + apiServerRequest.getUserIdentity());
        logger.info("request startDate: " + apiServerRequest.getStartDate());
        logger.info("request endDate: " + apiServerRequest.getEndDate());
        logger.info("request token: " + apiServerRequest.getToken());

        // 예시를 위해 하드코딩
//        ApiServerRequest apiServerRequest_sample = new ApiServerRequest();
//        apiServerRequest_sample.setUserIdentity("uj0791");
//        apiServerRequest_sample.setToken("token");

//        // TreatController의 getTreat 메서드 호출
//        ResponseEntity<ApiServerResponse> response = easyResponseClient.getTreat(apiServerRequest_sample); // 이거 다시
//        logger.info(String.valueOf(response));



        try {
            List<TreatResponse> treatResponses = easyResponseService.fetchTreats(apiServerRequest);
            logger.info(String.valueOf(treatResponses));
            return ResponseEntity.ok(treatResponses);
        } catch (Exception e) {
            logger.error("Error processing getTreat request", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
