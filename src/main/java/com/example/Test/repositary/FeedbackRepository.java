package com.example.Test.repositary;

import com.example.Test.controller.request.FeedbackRequest;
import com.example.Test.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedbackRepository {

    List<Feedback> feedbackList= new ArrayList<>();

    public void create(Feedback feedback){
        feedbackList.add(feedback);
    }

    public List<Feedback> findAll(){
        return feedbackList;
    }

    public Feedback findById(Long Id){
        for(Feedback feedback:feedbackList){
            if (feedback.getId().equals(Id)){
                return feedback;
            }

        }return null;
    }

}
