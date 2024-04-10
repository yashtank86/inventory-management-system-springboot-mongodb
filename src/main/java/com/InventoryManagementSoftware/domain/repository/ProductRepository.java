package com.InventoryManagementSoftware.domain.repository;

import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import jdk.jfr.Enabled;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<TblProduct, String> {

    @Query("{manufacturer : ?0 }")
    List<TblProduct> findByManufacturer(String manufacturer);

    Optional<TblProduct> findByProductId(String productId);
}
