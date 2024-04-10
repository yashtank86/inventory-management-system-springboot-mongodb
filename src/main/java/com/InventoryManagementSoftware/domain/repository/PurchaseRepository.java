package com.InventoryManagementSoftware.domain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.domain.Entities.TblPurchase;

@Repository
public interface PurchaseRepository extends MongoRepository<TblPurchase, String> {
    
    //Optional<TblPurchase> findByProductId(String purchaseId);

}
