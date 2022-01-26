package com.spring.basics.workout_app.workout_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkoutAppApplication {

	public static void main(String[] args) {
        Coach myCoach = new TrackCoach();
        System.out.println(myCoach.getWorkoutPlan());
	}

}
