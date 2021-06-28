package com.parkmeright.proj.repository;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkmeright.proj.entity.Timeslot;
@Repository
public interface TimeSlotRepository extends JpaRepository<Timeslot,Long>
{

	Calendar findByTimeslotid(int i);

	

}
