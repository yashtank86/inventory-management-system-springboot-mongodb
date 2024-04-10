package com.InventoryManagementSoftware.application.ServiceImpl;

import com.InventoryManagementSoftware.application.Exception.EntityNotFoundException;
import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.domain.Entities.TblPurchase;
import com.InventoryManagementSoftware.domain.Services.ProductService;
import com.InventoryManagementSoftware.domain.Services.PurchaseService;
import com.InventoryManagementSoftware.domain.repository.ProductRepository;
import com.InventoryManagementSoftware.domain.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public TblPurchase savePurchases(TblPurchase purchase) {
        purchase.setPurchaseId(UUID.randomUUID().toString().split("-")[0]);
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<TblPurchase> getAllPurchases() {
        return null;
    }

    @Override
    public List<TblPurchase> getPurchasesFromSupplier(String supplierName) {
        return null;
    }

    @Override
    public Optional<TblPurchase> getPurchasesFromId(String purchaseId) {
        return null;
    }

    @Override
    public TblPurchase updateProduct(PurchaseRequest purchaseRequest) throws EntityNotFoundException {
        throw new EntityNotFoundException("Unimplemented method 'updateProduct'");
    }



}
