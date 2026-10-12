package com.clinicqueue.repo;
import com.clinicqueue.model.*; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import java.time.*; import java.util.*;
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
 List<Appointment> findByPatientIdOrderByDateAscTimeAsc(Long id);
 @Query("select a from Appointment a where a.doctor.id=:doctor and a.date=:date and a.status <> 'CANCELLED' order by a.time") List<Appointment> findSlots(@Param("doctor") Long doctor,@Param("date") LocalDate date);
 @Query("select a from Appointment a order by a.date desc,a.time desc") List<Appointment> findAllRecent();
 boolean existsByDoctorIdAndDateAndTimeAndStatusNot(Long doctor,LocalDate date,LocalTime time,String status);
}
