package com.parkmeright.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Zones;


@Repository	
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> 
{

	List<ParkingLot> findByAvailabilityAndParkinglotid(Boolean availabilty, Integer parkinglotnumber);

	List<ParkingLot> findByParkinglotid(Integer parkinglotid);

    
		
	
}


