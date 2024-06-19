//package com.example.MypageService.dto.exercise;
//
//import com.example.MypageService.dto.health.HealthCareConverter;
//import com.example.MypageService.dto.health.HealthResponse;
//import com.example.MypageService.entity.HealthCare;
//import com.example.MypageService.entity.UserHealth;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ExerciseConverter {
//    public static ExerciseResponse toResponse(UserHealth userHealth) {
//        return ExerciseResponse.builder()
//                .exerciseId((userHealth.getId())
//                .exerciseName(userHealth.getExerciseName())
//                .exerciseCount(userHealth.getExerciseCount())
//                .exerciseWeight(userHealth.getExerciseWeight())
//                .isCompleted
//                .build();
//    }
//
//    public static List<HealthResponse> toResponseList(List<HealthCare> healthCareList) {
//        return healthCareList.stream()
//                .map(HealthCareConverter::toResponse)
//                .collect(Collectors.toList());
//    }
//}
