package com.example.MypageService.service;

import com.example.MypageService.controller.EasyResponseClient;
import com.example.MypageService.dto.ApiServerRequest;
import com.example.MypageService.dto.ApiServerResponse;
import com.example.MypageService.dto.TreatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EasyResponseService {

    @Autowired
    private EasyResponseClient easyResponseClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;


    public List<TreatResponse> fetchTreats(ApiServerRequest apiServerRequest){
        //ApiServerRequest request = new ApiServerRequest(userIdentity, token); // 이것도 토큰 properties에 저장
        //ResponseEntity<List<TreatResponse>> responseEntity = easyResponseClient.getTreat(apiServerRequest);
        // 일단 6월 23일날 날짜 조회기능을 추가한 컨트롤러로 변경 (아래꺼)
        ResponseEntity<List<TreatResponse>> responseEntity = easyResponseClient.getTreatAndDate(apiServerRequest);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }
        else{
            throw new RuntimeException("진단 내역을 가져오는데 실패했습니다.");
        }

    }

//    public List<TreatResponse> fetchTreats(ApiServerRequest apiServerRequest) {
//        // 회로 차단기 설정
//        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("easyResponseCircuitBreaker");
//
//        // Feign 클라이언트를 호출하고, Fallback 메서드를 지정합니다.
//        return circuitBreaker.run(() -> {
//            ResponseEntity<List<TreatResponse>> responseEntity = easyResponseClient.getTreatAndDate(apiServerRequest);
//            if (responseEntity.getStatusCode().is2xxSuccessful()) {
//                return responseEntity.getBody();
//            } else {
//                throw new RuntimeException("진단 내역을 가져오는데 실패했습니다.");
//            }
//        }, throwable -> fallbackMethod(apiServerRequest, throwable));
//    }
//
//    public List<TreatResponse> fallbackMethod(ApiServerRequest apiServerRequest, Throwable throwable) {
//        // Fallback 로직
//        return Collections.emptyList();
//    }

}
