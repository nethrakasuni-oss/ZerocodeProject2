package com.example.Test.service;

import com.example.Test.controller.request.DoctorRequest;
import com.example.Test.model.Doctor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DoctorService {

    void createDoctor(@RequestBody DoctorRequest doctorRequest);

    Doctor findDoctorById( Long doctorId);

    List<Doctor>  findAllDoctor();

    void updateDoctor(Long doctorId, DoctorRequest doctorRequest);


}
