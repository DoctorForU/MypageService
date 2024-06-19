package com.example.MypageService.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTotalInfo { // 대시보드에 보여줄 총 운동시간 중량 등등
    private String totalDurationInMinutes; // 총 운동시간
    private int totalCount; // 총 운동개수
    private int totalWeight; // 총 중량
}
