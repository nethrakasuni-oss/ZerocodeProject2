package com.example.Test.service;

import com.example.Test.controller.request.FeedbackRequest;
import com.example.Test.model.Feedback;

import java.util.List;

public interface FeedbackService {

    void createFeedback(FeedbackRequest feedbackRequest);

    Feedback findById(Long id);

    List<Feedback> findAll();
}