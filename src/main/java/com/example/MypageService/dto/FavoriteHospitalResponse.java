package com.example.MypageService.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class FavoriteHospitalResponse { // openFeign으로 받는 dto
    private String hpid;
    private String dutyAddr;
    private String dutyName;
    private String dutyTel1;
}
