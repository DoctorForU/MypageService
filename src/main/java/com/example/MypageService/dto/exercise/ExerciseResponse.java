package com.example.MypageService.dto.exercise;

import com.example.MypageService.entity.Exercise;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class ExerciseResponse {
    private long exerciseId;
    private String exerciseName;
    private int exerciseSet;
    private int exerciseWeight;
    private int exerciseCount;
    private boolean isCompleted;
}
