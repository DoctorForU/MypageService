package com.example.MypageService.service;

import com.example.MypageService.dto.Inquiry.InquiryConverter;
import com.example.MypageService.dto.Inquiry.InquiryResponse;
import com.example.MypageService.entity.HealthCare;
import com.example.MypageService.entity.Inquiry;
import com.example.MypageService.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {
    @Autowired
    private InquiryRepository inquiryRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<InquiryResponse> getInquiry(String userId) {
        List<Inquiry> inquiryList = inquiryRepository.findByUserId(userId);
        return InquiryConverter.toResponseList(inquiryList);
    }

    public void registerInquiry(Inquiry inquiry) {
        Inquiry newInquiry = new Inquiry(
                inquiry.getUserId(),
                inquiry.getTitle(),
                inquiry.getContent()
        );

        logger.info("newInquiry: " + newInquiry);
        inquiryRepository.save(newInquiry);
    }
}
