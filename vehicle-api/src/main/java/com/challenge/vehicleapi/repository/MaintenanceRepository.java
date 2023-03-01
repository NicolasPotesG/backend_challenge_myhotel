package com.challenge.vehicleapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.vehicleapi.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
	List<Maintenance> findByVehicleId(Long vehicleId);

	List<Maintenance> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
