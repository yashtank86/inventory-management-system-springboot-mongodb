package com.InventoryManagementSoftware.application.payload.request;

import java.util.Date;

import com.InventoryManagementSoftware.domain.Entities.TblPurchase;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PurchaseRequest {

    private String number;
    private String purchaseId;
    private String documentType;
    private String productName;
    private String navCode;
    private String supplierName;
    private String PONO;
    private String barcode;
    private String pipcode;
    private Integer quantity;
    private String unitPrice;
    private String type;
    private String username;
    private Date createdDate;

    

     public PurchaseRequest() {

     }

     public PurchaseRequest(TblPurchase tblPurchase) {
         this.number = tblPurchase.getNumber();
         this.purchaseId = tblPurchase.getPurchaseId();
         this.documentType = tblPurchase.getDocumentType();
         this.productName = tblPurchase.getProductName();
         this.navCode = tblPurchase.getNavCode();
         this.supplierName = tblPurchase.getSupplierName();
         this.PONO = tblPurchase.getPONO();
         this.barcode = tblPurchase.getBarcode();
         this.pipcode = tblPurchase.getPipcode();
         this.quantity = tblPurchase.getQuantity();
         this.unitPrice = tblPurchase.getUnitPrice();
         this.type = tblPurchase.getType();
         this.username = tblPurchase.getUsername();
         this.createdDate = tblPurchase.getCreatedDate();
     }
    
     
     

}
