package com.internet.base.application.repository;



import com.internet.base.application.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    @Query(value = "SELECT * FROM Destination WHERE id = :id", nativeQuery = true)
    Destination findOne(Long id);
}
