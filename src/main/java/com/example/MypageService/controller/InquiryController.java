package com.example.MypageService.controller;

import com.example.MypageService.api.CommonResponse;
import com.example.MypageService.dto.Inquiry.GetInquiryRequest;
import com.example.MypageService.dto.Inquiry.InquiryResponse;
import com.example.MypageService.entity.Inquiry;
import com.example.MypageService.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage-service")
public class InquiryController {
    private final InquiryService inquiryService;
    private static final Logger logger = LoggerFactory.getLogger(HealthCareController.class);
    @PostMapping("/inquiry/get") // 문의 내역 가져오기 -> 사용자 id를 통해
    public List<InquiryResponse> getInquiry(@RequestBody GetInquiryRequest getInquiryRequest) {
        logger.info("userId: " + getInquiryRequest.getUserId());
        //List<HealthResponse> response = inquiryService.getHealth(userId);
        return inquiryService.getInquiry(getInquiryRequest);
    }
    @PostMapping("/inquiry/register")
    public CommonResponse<String> registerInquiry(@RequestBody Inquiry inquiry){
        logger.info("userId: " + inquiry.getUserId() + "title: " + inquiry.getTitle());

        inquiryService.registerInquiry(inquiry);
        return CommonResponse.ok("문의 내역 등록 완료");
    }
}
