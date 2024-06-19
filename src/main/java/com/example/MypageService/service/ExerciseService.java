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
//    public GetTotalInfo getExercise(GetExerciseRequest getExerciseRequest){ // 대시보드 운동 항목
//
//        return exerciseRepository.toResponseList(userHealthList);
//    }
//
//    public List<ExerciseResponse> getExerciseList(GetExerciseRequest GetExerciseRequest){
//        List<Exercise> exerciseList = exerciseRepository.getExercisesByUserIdAndDate(GetExerciseRequest.get);
//        return ExerciseConverter.toResponseList(userHealthList);
//    }
//    public List<Exercise> getExercisesByUserIdAndDate(GetExerciseRequest getExerciseRequest) {
//        return exerciseRepository.findByUserIdAndCreatAt(getExerciseRequest.getUserId(), getExerciseRequest.getSelectedDate());
//    }

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

    public Duration getTotalExerciseDuration() {
        List<Exercise> exercises = exerciseRepository.findAll();
        Duration totalDuration = Duration.ZERO;

        for (Exercise exercise : exercises) {
            totalDuration = totalDuration.plus(exercise.getExerciseDuration());
        }

        return totalDuration;
    }
}
