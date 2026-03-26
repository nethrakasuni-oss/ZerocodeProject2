package com.example.Test.controller;

import com.example.Test.controller.request.FeedbackRequest;
import com.example.Test.controller.response.FeedbackResponse;
import com.example.Test.model.Feedback;
import com.example.Test.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedbacks")
    public void createFeedback(@RequestBody FeedbackRequest feedbackRequest){
        feedbackService.createFeedback(feedbackRequest);
    }

    @GetMapping("/feedbacks")
    public List<FeedbackResponse> findAll(){
        List<Feedback> feedbackList = feedbackService.findAll();

        List<FeedbackResponse> responseList = new ArrayList<>();

        for(Feedback feedback:feedbackList){
            FeedbackResponse feedbackResponse = new FeedbackResponse();
            feedbackResponse.setId(feedback.getId());
            feedbackResponse.setMessage(feedback.getMessage());
            responseList.add(feedbackResponse);
        }
        return responseList;
    }


    @GetMapping("/feedbacks/{id}")
    public FeedbackResponse findById(@PathVariable Long id){
        Feedback fb = feedbackService.findById(id);
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setId(fb.getId());
        feedbackResponse.setMessage(fb.getMessage());
        return feedbackResponse;
    }



}
