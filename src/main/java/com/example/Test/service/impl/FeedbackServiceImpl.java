package com.example.Test.service.impl;

import com.example.Test.controller.request.FeedbackRequest;
import com.example.Test.model.Feedback;
import com.example.Test.repositary.FeedbackRepository;
import com.example.Test.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public void createFeedback(FeedbackRequest feedbackRequest) {

        Feedback feedback= new Feedback();
        feedback.setId(feedbackRequest.getId());
        feedback.setMessage(feedbackRequest.getMessage());

        feedbackRepository.create(feedback);
    }

    @Override
    public Feedback findById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }
}
