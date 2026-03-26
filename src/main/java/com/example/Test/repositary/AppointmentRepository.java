package com.example.Test.repositary;

import com.example.Test.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepository {

    List<Appointment> appointmentList=new ArrayList<Appointment>();

    public void createAppointment(Appointment appointment){
        appointmentList.add(appointment);
    }

    public List<Appointment> findAllAppointments(){
        return appointmentList;
    }

    public Appointment findAppointmentById (Long appointmentId){
        for(Appointment appointment:appointmentList){
            if (appointment.getId().equals(appointmentId)){
                return appointment;
            }
        }
        return null;
    }
}

