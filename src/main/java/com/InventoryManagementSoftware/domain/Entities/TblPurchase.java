package com.InventoryManagementSoftware.domain.Entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection = "tblPurchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TblPurchase {

    @Id
    private String purchaseId;

    @Size(max = 50)
    @Field("number")
    private String number;

    @Size(max = 50)
    @Field("docType")
    private String documentType;

    @Size(max = 120)
    @Field("productName")
    private String productName;

    @Size(max = 120)
    @Field("navCode")
    private String navCode;

    @Size(max = 120)
    @Field("supplierName")
    private String supplierName;

    @Size(max = 120)
    @Field("PONO")
    private String PONO;

    @Size(max = 120)
    @Field("barcode")
    private String barcode;

    @Size(max = 120)
    @Field("pipcode")
    private String pipcode;

    @Size(max = 120)
    @Field("quantity")
    private Integer quantity;

    @Size(max = 120)
    @Field("unitPrice")
    private String unitPrice;

    @Size(max = 120)
    @Field("type")
    private String type;

    @Size(max = 120)
    @Field("username")
    private String username;

    @Size(max = 120)
    @Field("createdDate")
    private Date createdDate;

    private List<TblPurchase> purchases;

    public TblPurchase(PurchaseRequest pRequest) {
        this.number = pRequest.getNumber();
        this.purchaseId = pRequest.getPurchaseId();
        this.documentType = pRequest.getDocumentType();
        this.productName = pRequest.getProductName();
        this.navCode = pRequest.getNavCode();
        this.supplierName = pRequest.getSupplierName();
        this.PONO = pRequest.getPONO();
        this.barcode = pRequest.getBarcode();
        this.pipcode = pRequest.getPipcode();
        this.quantity = pRequest.getQuantity();
        this.unitPrice = pRequest.getUnitPrice();
        this.type = pRequest.getType();
        this.username = pRequest.getUsername();
        this.createdDate = pRequest.getCreatedDate();
    }




}
