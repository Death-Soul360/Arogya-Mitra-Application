package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.DTO.Appointment;
import com.example.Nabha_HealthCare.Service.Appointment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class Appointment_Controller {

    @Autowired
    private Appointment_Service appointmentService;

    // 1. Get all appointments
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // 2. Get by ID
    @GetMapping("/byId/{id}")
    public Appointment getById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id);
    }

    // 3. Get by patient name
    @GetMapping("/byPatient")
    public List<Appointment> getByPatient(@RequestParam String name) {
        return appointmentService.getAppointmentsByPatient(name);
    }

    // 4. Get by doctor name
    @GetMapping("/byDoctor")
    public List<Appointment> getByDoctor(@RequestParam String name) {
        return appointmentService.getAppointmentsByDoctor(name);
    }

    // 5. Get by date
    @GetMapping("/byDate")
    public List<Appointment> getByDate(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        return appointmentService.getAppointmentsByDate(localDate);
    }

    // 6. Add new appointment
    @PostMapping("/add")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }

    // 7. Update appointment
    @PutMapping("/update/{id}")
    public Appointment updateAppointment(@PathVariable Integer id, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointment(id, updatedAppointment);
    }

    // 8. Delete appointment
    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointment(id);
    }
}

