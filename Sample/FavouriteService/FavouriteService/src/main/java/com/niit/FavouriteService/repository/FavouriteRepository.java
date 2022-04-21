package com.niit.FavouriteService.repository;

import com.niit.FavouriteService.domain.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite,String> {

}
