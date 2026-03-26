package com.example.Test.repositary;

import com.example.Test.controller.request.DoctorRequest;
import com.example.Test.model.Doctor;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepositary {


    List<Doctor> DoctorList = new ArrayList<>();

    public void createDoctor(Doctor doctor){
        DoctorList.add(doctor);
    }

    public List<Doctor> findAllDoctor() {
        return DoctorList;
    }

    public Doctor findDoctorById(Long doctorId) {
        for (Doctor doctor : DoctorList) {

            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }


    public Doctor updateDoctor(Long doctorId, DoctorRequest request) {
        for (Doctor doctor : DoctorList) {

            if (doctor.getId().equals(doctorId)) {

               doctor.setDoctorName(request.getDoctorName());
               doctor.setId(request.getId());

                return doctor;
            }
        }

        return null;
    }




}
