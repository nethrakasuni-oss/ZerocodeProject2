package com.example.Test.service.impl;

import com.example.Test.controller.request.DoctorRequest;
import com.example.Test.model.Doctor;
import com.example.Test.repositary.DoctorRepositary;
import com.example.Test.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorImpl implements DoctorService {

    @Autowired
    DoctorRepositary doctorRepositary;


    @Override
    public void createDoctor(DoctorRequest doctorRequest) {

        Doctor doctor = new Doctor();
        doctor.setId(doctorRequest.getId());
        doctor.setDoctorName(doctorRequest.getDoctorName());

        doctorRepositary.createDoctor(doctor);
    }

    @Override
    public Doctor findDoctorById(Long doctorId) {

     return doctorRepositary.findDoctorById(doctorId);

    }

    @Override
    public List<Doctor> findAllDoctor() {

        return doctorRepositary.findAllDoctor();
    }

    @Override
    public void updateDoctor(Long doctorId, DoctorRequest doctorRequest) {
        doctorRepositary.updateDoctor(doctorId, doctorRequest);

    }
}
