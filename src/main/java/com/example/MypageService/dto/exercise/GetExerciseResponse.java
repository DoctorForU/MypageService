package com.example.MypageService.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExerciseResponse { // DailyHealth에 보여줄 운동 항목 (그날 한 운동 list)
    private String exerciseName; // 운동명
    private Integer exerciseSets; // 운동세트 수
    private Integer exerciseWeight;
    private Integer exerciseCount;
    private boolean isCompleted;
    private Duration exerciseDuration;

    // 토탈
//    private boolean isCompleted;
}
