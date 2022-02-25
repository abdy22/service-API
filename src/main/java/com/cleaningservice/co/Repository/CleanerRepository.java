package com.cleaningservice.co.Repository;

import com.cleaningservice.co.Model.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CleanerRepository extends JpaRepository<Cleaner,Integer> {
    List<Cleaner> findByCityOfService(String name);
}
