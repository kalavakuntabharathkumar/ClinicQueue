package com.clinicqueue.model;
import jakarta.persistence.*; import java.time.LocalDate; import java.time.LocalTime;
@Entity @Table(name="appointments",indexes={@Index(name="idx_slot_search",columnList="doctor_id,appointment_date,status"),@Index(name="idx_patient_appointments",columnList="patient_id,appointment_date")})
public class Appointment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private AppUser patient;
 @ManyToOne(optional=false) private AppUser doctor;
 @Column(name="appointment_date",nullable=false) private LocalDate date;
 @Column(nullable=false) private LocalTime time;
 @Column(nullable=false) private String status="BOOKED";
 protected Appointment(){}
 public Appointment(AppUser p,AppUser d,LocalDate date,LocalTime time){patient=p;doctor=d;this.date=date;this.time=time;}
 public Long getId(){return id;} public AppUser getPatient(){return patient;} public AppUser getDoctor(){return doctor;} public LocalDate getDate(){return date;} public LocalTime getTime(){return time;} public String getStatus(){return status;} public void setStatus(String s){status=s;}
}
