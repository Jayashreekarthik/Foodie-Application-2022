package com.niit.vendorService.repositroy;

import com.niit.vendorService.model.Cusine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CusineRepository extends JpaRepository<Cusine,Integer> {
    public List<Cusine> findByEmail(String email);
}
