package com.example.MypageService.service;

import com.example.MypageService.dto.exercise.*;
import com.example.MypageService.entity.Exercise;
import com.example.MypageService.repository.ExerciseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GetTotalInfo getExerciseStatsByUserIdAndDate(GetExerciseRequest getExerciseRequest) { // 대시보드에 총 운동시간, 총 운동 개수, 총 중량을 받아오는 서비스
        List<Exercise> exercises = exerciseRepository.findByUserIdAndCreatAt(getExerciseRequest.getUserId(), getExerciseRequest.getSelectedDate());
        Duration totalDuration = Duration.ZERO;
        int totalCount = exercises.size();
        int totalWeight = 0;

        for (Exercise exercise : exercises) {
            totalDuration = totalDuration.plus(exercise.getExerciseDuration());
            totalWeight += exercise.getExerciseWeight() != null && exercise.getExerciseSets() != null ? exercise.getExerciseWeight() * exercise.getExerciseSets() : 0;
        }

        logger.info("In Service totalDuration: " +  totalDuration);
        logger.info("In Service totalCount: " +  totalCount);
        logger.info("In Service totalWeight: " +  totalWeight);

        String totalDurationInMinutes = String.valueOf(totalDuration.toMinutes());
        logger.info("In Service totalDurationInMinutes: " +  totalDurationInMinutes);

        return new GetTotalInfo(totalDurationInMinutes, totalCount, totalWeight);
    }



    public List<GetExerciseResponse> getExercisesByUserIdAndDate(GetExerciseRequest getExerciseRequest) {
        List<Exercise> exercises = exerciseRepository.findByUserIdAndCreatAt(getExerciseRequest.getUserId(), getExerciseRequest.getSelectedDate());
        return exercises.stream().map(exercise -> {
            GetExerciseResponse response = new GetExerciseResponse();
            response.setExerciseName(exercise.getExerciseName());
            response.setExerciseSets(exercise.getExerciseSets());
            response.setExerciseWeight(exercise.getExerciseWeight());
            response.setExerciseCount(exercise.getExerciseCount());
            response.setCompleted(exercise.isCompleted());
            response.setExerciseDuration(exercise.getExerciseDuration());
            return response;
        }).collect(Collectors.toList());
    }

   /////////////////////
    public void registerExercise(List<RegisterExerciseRequest> registerExerciseRequests){
        List<Exercise> exercises = registerExerciseRequests.stream().map(request -> {
            Exercise exercise = new Exercise();
            exercise.setUserId(request.getUserId());
            exercise.setExerciseName(request.getExerciseName());
            exercise.setExerciseSets(request.getExerciseSets());
            exercise.setExerciseWeight(request.getExerciseWeight());
            exercise.setExerciseCount(request.getExerciseCount());
            exercise.setCompleted(request.isCompleted());
            exercise.setCreatAt(LocalDate.now());
            exercise.setExerciseDuration(request.getExerciseDuration());
            return exercise;
        }).collect(Collectors.toList());
        exerciseRepository.saveAll(exercises);
    }

//    public Duration getTotalExerciseDuration() {
//        List<Exercise> exercises = exerciseRepository.findAll();
//        Duration totalDuration = Duration.ZERO;
//
//        for (Exercise exercise : exercises) {
//            totalDuration = totalDuration.plus(exercise.getExerciseDuration());
//        }
//
//        return totalDuration;
//    }
}
