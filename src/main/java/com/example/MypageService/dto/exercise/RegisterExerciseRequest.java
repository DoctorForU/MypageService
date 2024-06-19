package com.example.MypageService.dto.exercise;

import com.example.MypageService.entity.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterExerciseRequest {
    private String userId;
    private String exerciseName;
    private int exerciseSets;
    private int exerciseWeight;
    private int exerciseCount;
    private boolean isCompleted;
    private String exerciseDuration; // "01:50" 형식의 문자열

}
