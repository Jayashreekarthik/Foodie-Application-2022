package com.niit.vendorService.repositroy;


import com.niit.vendorService.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    public List<Restaurant> findByEmail(String email);
}
