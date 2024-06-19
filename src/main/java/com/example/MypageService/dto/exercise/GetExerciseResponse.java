package com.example.MypageService.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExerciseResponse { // DailyHealth에 보여줄 운동 항목 (그날 한 운동 list)
    private String exerciseName;
    private Integer exerciseSets;
    private Integer exerciseWeight;
    private Integer exerciseCount;
    private boolean isCompleted;
    private Duration exerciseDuration;
//    private boolean isCompleted;
}
