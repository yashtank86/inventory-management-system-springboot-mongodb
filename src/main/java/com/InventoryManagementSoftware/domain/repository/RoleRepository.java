package com.InventoryManagementSoftware.domain.repository;

import com.InventoryManagementSoftware.domain.Entities.ERole;
import com.InventoryManagementSoftware.domain.Entities.TblRole;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<TblRole, String> {

    Optional<TblRole> findByName(ERole name);

}
