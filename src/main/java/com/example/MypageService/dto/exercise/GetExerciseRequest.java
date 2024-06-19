package com.example.MypageService.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetExerciseRequest {
    private String userId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate selectedDate; // "2024-06-19" // 여기는 프론트쪽으로 string이오면

}
