package com.internet.base.application.repository;


import com.internet.base.application.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query(value = "SELECT * FROM Tour WHERE tourID = :tourID", nativeQuery = true)
    Tour findOne(long tourID);
}
