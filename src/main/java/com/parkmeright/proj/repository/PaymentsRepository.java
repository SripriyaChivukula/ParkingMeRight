package com.parkmeright.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Payments;
@Repository
public interface PaymentsRepository extends JpaRepository<Payments,Long>
{
	List<Payments> findByReservationid(Integer r);

}
