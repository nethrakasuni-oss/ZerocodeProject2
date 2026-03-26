package com.example.Test.controller;

import com.example.Test.controller.request.DoctorRequest;
import com.example.Test.controller.response.DoctorResponse;
import com.example.Test.model.Doctor;
import com.example.Test.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctors")
    public  void createDoctor(@RequestBody DoctorRequest doctorRequest){

        doctorService.createDoctor(doctorRequest);

    }

@GetMapping("doctor/{doctor-id}")
   public DoctorResponse findDoctorById(@PathVariable ("doctor-id") Long doctorId){

       Doctor doctor= doctorService.findDoctorById(doctorId);

        DoctorResponse doctorResponse = new DoctorResponse();
        doctorResponse.setDoctorName(doctor.getDoctorName());
        doctorResponse.setId(doctor.getId());

        return doctorResponse;

   }

   @GetMapping("doctors")
   public List<DoctorResponse>  findAllDoctor(){

        List<Doctor> doctorList=doctorService.findAllDoctor();
        List<DoctorResponse> doctorResponseList=new ArrayList<>();
        for (Doctor doctor : doctorList) {
            DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setId(doctor.getId());
            doctorResponse.setDoctorName(doctor.getDoctorName());
            doctorResponseList.add(doctorResponse);
        }
        return doctorResponseList;

   }


   @PutMapping("doctor/{doctor-id}")
   public  void docterUpdate(@PathVariable ("doctor-id") Long doctorId,@RequestBody DoctorRequest doctorRequest){



        doctorService.updateDoctor(doctorId,doctorRequest);




   }






}
