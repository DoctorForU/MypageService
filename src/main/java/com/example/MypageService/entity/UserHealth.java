//package com.example.MypageService.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//
//@Entity
//@Data
//@Builder
//@Table(name = "user_health")
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserHealth {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "exercise_id")
//    @JsonBackReference // 순환 참조 방지를 위해
//    private Exercise exercise;
//
//    @Column(name = "user_id", nullable = false)
//    private String userId;
//
//    @Column(name = "exercise_name", nullable = false)
//    private String exerciseName;
//
//    @Column(name = "exercise_sets", nullable = false)
//    private int exerciseSets;
//
//    @Column(name = "exercise_weight", nullable = false)
//    private int exerciseWeight;
//
//    @Column(name = "exercise_count", nullable = false)
//    private int exerciseCount;
//
//    @Column(name = "is_completed", nullable = false)
//    private boolean isCompleted;
//
//    @Column(name = "creatAt", nullable = false)
//    private LocalDate creatAt;
//}
