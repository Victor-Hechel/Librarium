package com.librarium.booking.repositories;

import com.librarium.booking.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, String> {
}
