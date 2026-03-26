package com.example.Test.service.impl;

import com.example.Test.controller.request.AppointmentRequest;
import com.example.Test.model.Appointment;
import com.example.Test.repositary.AppointmentRepository;
import com.example.Test.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;



    @Override
    public void createAppointment(AppointmentRequest appointmentRequest) {

        Appointment appointment =new Appointment();
        appointment.setId(appointment.getId());
        appointment.setDate(appointmentRequest.getDate());
        appointment.setDoctorName(appointmentRequest.getDoctorName());
        appointment.setPatientName(appointmentRequest.getPatientName());

        appointmentRepository.createAppointment(appointment);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAllAppointments();
    }

    @Override
    public Appointment findAppointmentById(Long appointmentId) {
        return appointmentRepository.findAppointmentById(appointmentId);
    }
}

