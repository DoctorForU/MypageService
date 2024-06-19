package com.example.MypageService.controller;

import com.example.MypageService.api.CommonResponse;
import com.example.MypageService.dto.exercise.*;
import com.example.MypageService.entity.Exercise;
import com.example.MypageService.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage-service")
public class ExerciseController {
    @Autowired
    private  ExerciseService exerciseService;
    private static final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @PostMapping ("/exercise/get") // DailyHealth쪽 운동 리스트 -> 여기 response
    public  ResponseEntity<List<GetExerciseResponse>> getExercise (@RequestBody GetExerciseRequest getExerciseRequest){
        logger.info("userId for exercise/get: " + getExerciseRequest.getUserId());
        logger.info("selectedDate for exercise/get: " + getExerciseRequest.getSelectedDate());
        return ResponseEntity.ok(exerciseService.getExercisesByUserIdAndDate(getExerciseRequest));
    }

    @PostMapping ("/exercise/dashboard") // mypage키지마자 대시보드에 뜨는 전체 운동시간, 전체 운동개수, 전체 중량을 보내주는 컨트롤러
    public  ResponseEntity<GetTotalInfo> getTotalExercise (@RequestBody GetExerciseRequest getExerciseRequest){
        logger.info("userId for exercise/dashboard: " + getExerciseRequest.getUserId());
        logger.info("selectedDate for exercise/dashboard: " + getExerciseRequest.getSelectedDate());
        GetTotalInfo total = exerciseService.getExerciseStatsByUserIdAndDate(getExerciseRequest);
        logger.info(total.toString());
        return ResponseEntity.ok(total);
    }

    @PostMapping ("/exercise/register")
    public CommonResponse<String> registerExercise (@RequestBody List<RegisterExerciseRequest> registerExerciseRequests){
        logger.info(registerExerciseRequests.toString());
        exerciseService.registerExercise(registerExerciseRequests);

        return CommonResponse.ok("운동 기록 완료");
    }
}
