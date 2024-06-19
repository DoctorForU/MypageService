package com.example.MypageService.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name = "exercise")
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    @Id
    @Column(name = "exercise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;

    @Column(name = "exercise_sets", nullable = true)
    private Integer exerciseSets;

    @Column(name = "exercise_weight", nullable = true)
    private Integer exerciseWeight;

    @Column(name = "exercise_count", nullable = true)
    private Integer exerciseCount;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    @Column(name = "creatAt", nullable = false)
    private LocalDate creatAt;

    @Column(name = "exercise_duration", nullable = false)
    private Duration exerciseDuration;

    // Utility methods to handle Duration
    public void setExerciseDuration(String timeString) {
        this.exerciseDuration = parseDuration(timeString);
    }

    public static Duration parseDuration(String timeString) {
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return Duration.ofHours(hours).plusMinutes(minutes);
    }
}
