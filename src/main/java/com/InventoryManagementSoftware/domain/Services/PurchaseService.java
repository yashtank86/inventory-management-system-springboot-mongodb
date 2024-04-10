package com.InventoryManagementSoftware.domain.Services;

import java.util.List;
import java.util.Optional;

import com.InventoryManagementSoftware.application.Exception.EntityNotFoundException;
import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.domain.Entities.TblPurchase;

public interface PurchaseService {


    TblPurchase savePurchases(TblPurchase purchase);

    List<TblPurchase> getAllPurchases();

    List<TblPurchase> getPurchasesFromSupplier(String supplierName);
    Optional<TblPurchase> getPurchasesFromId(String purchaseId);

    TblPurchase updateProduct(PurchaseRequest purchaseRequest) throws EntityNotFoundException;
    
}
