package com.example.MypageService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiServerRequest {
    private String userIdentity; // 프론트 받아와야 함
    private String startDate; // 조회시작일
    private String endDate; // 조회마지막일
    private String token; // doctorforUdb - table Root -> access, refresh, organizationName, organizationEmail, organizationPW
    // date 두개 더 온다는 거

}
