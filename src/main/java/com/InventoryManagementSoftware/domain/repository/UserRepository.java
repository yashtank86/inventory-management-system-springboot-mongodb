package com.InventoryManagementSoftware.domain.repository;

import com.InventoryManagementSoftware.domain.Entities.TblUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<TblUser, String> {

    Optional<TblUser>findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);



}
