package com.InventoryManagementSoftware.application.payload.request;

import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import lombok.Builder;
import lombok.Data;

import java.util.List;


public class ProductRequest {

    private String productId;
    private String manufacturer;
    private String productName;
    private String navCode;
    private String barcode;
    private String batchExpiry;
    private Integer quantity;
    private String price;
    private String pipCode;
    private Integer vat;
    private String status;


    public ProductRequest() {

    }

    public ProductRequest(TblProduct tblProduct) {
        this.productId = tblProduct.getProductId();
        this.manufacturer = tblProduct.getManufacturer();
        this.productName = tblProduct.getProductName();
        this.navCode = tblProduct.getNavCode();
        this.pipCode = tblProduct.getPipCode();
        this.vat = tblProduct.getVat();
        this.batchExpiry = tblProduct.getBatchExpiry();
        this.barcode = tblProduct.getBarcode();
        this.quantity = tblProduct.getQuantity();
        this.status = tblProduct.getStatus();
        this.price = tblProduct.getPrice();

    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNavCode() {
        return navCode;
    }

    public void setNavCode(String navCode) {
        this.navCode = navCode;
    }

    public String getPipCode() {
        return pipCode;
    }

    public void setPipCode(String pipCode) {
        this.pipCode = pipCode;
    }

    public String getBatchExpiry() {
        return batchExpiry;
    }

    public void setBatchExpiry(String batchExpiry) {
        this.batchExpiry = batchExpiry;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
