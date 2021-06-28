package com.parkmeright.proj.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Zones;


@Repository
public interface ZonesRepository extends JpaRepository<Zones, Long> 
{
	List<Zones> findByZonenumber(Integer zonenumber);
	List<Zones> findByCity(String city);
//	List<ParkingLot>  findByZonenumber(Integer zonenumber);

	//void saveAndFlush(int i, int j, int k, String string, String string2, String string3, int l, List<ParkingLot> p);
}
