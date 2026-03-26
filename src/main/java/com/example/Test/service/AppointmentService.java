package com.example.Test.service;

import com.example.Test.controller.request.AppointmentRequest;
import com.example.Test.controller.response.AppointmentResponse;
import com.example.Test.model.Appointment;
import com.example.Test.repositary.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    void createAppointment(AppointmentRequest appointmentRequest);

    List<Appointment> findAllAppointments();

    Appointment findAppointmentById (Long appointmentId);
}
