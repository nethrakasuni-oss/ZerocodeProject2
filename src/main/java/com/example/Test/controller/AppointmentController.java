package com.example.Test.controller;

import com.example.Test.controller.request.AppointmentRequest;
import com.example.Test.controller.response.AppointmentResponse;
import com.example.Test.model.Appointment;
import com.example.Test.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointments")
    void createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.createAppointment(appointmentRequest);
    }

    @GetMapping("/appointments")
    public List<AppointmentResponse> getAllAppointments() {

        List<Appointment> appointmentList=appointmentService.findAllAppointments();

        List<AppointmentResponse> appointmentResponseList=new ArrayList<>();

        for (Appointment appointment : appointmentList) {
            AppointmentResponse appointmentResponse=new AppointmentResponse();
            appointmentResponse.setId(appointment.getId());
            appointmentResponse.setDate(appointment.getDate());
            appointmentResponse.setDoctorName(appointment.getDoctorName());

            appointmentResponseList.add(appointmentResponse);
        }
        return appointmentResponseList;
    }
    @GetMapping("appointments/{appointment_id}")
    public AppointmentResponse getAppointmentById(@PathVariable ("appointment_id") Long appointmentId) {
        Appointment appointment=appointmentService.findAppointmentById(appointmentId);

        AppointmentResponse appointmentResponse=new AppointmentResponse();
        appointmentResponse.setId(appointment.getId());
        appointmentResponse.setDate(appointment.getDate());
        appointmentResponse.setDoctorName(appointment.getDoctorName());
        return appointmentResponse;
    }
}
