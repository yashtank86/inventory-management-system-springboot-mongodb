package com.InventoryManagementSoftware.domain.Entities;

import com.InventoryManagementSoftware.application.payload.request.ProductRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;


@Document(collection = "tblProduct")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TblProduct {

    @Id
    private String productId;

    @Size(max = 50)
    @Field("manufacturer")
    private String manufacturer;

    @Size(max = 50)
    @Field("productName")
    private String productName;

    @Size(max = 120)
    @Field("navCode")
    private String navCode;

    @Size(max = 120)
    @Field("barcode")
    private String barcode;

    @Size(max = 120)
    @Field("batchExpiry")
    private String batchExpiry;

    @Size(max = 120)
    @Field("quantity")
    private Integer quantity;

    @Size(max = 120)
    @Field("price")
    private String price;

    @Size(max = 120)
    @Field("pipCode")
    private String pipCode;

    @Size(max = 120)
    @Field("vat")
    private Integer vat;

    @Size(max = 120)
    @Field("status")
    private String status;

    @Size(max = 120)
    @Field("createDate")
    private Date createDate;

    @Size(max = 120)
    @Field("lastSoldDate")
    private Date lastSoldDate;

    @Size(max = 120)
    @Field("orderStatus")
    private String orderStatus;

    @Size(max = 120)
    @Field("restriction")
    private String restriction;

    private List<TblProduct> productList;


    public TblProduct(){

    }

    /*public TblProduct(ProductRequest productRequest){
        this.productId = productRequest.getProductId();
        this.productName = productRequest.getProductName();
        this.navCode = productRequest.getNavCode();
        this.dcCode = productRequest.getDcCode();
        this.price = productRequest.getPrice();

    }*/


    public TblProduct(ProductRequest productRequest){
        this.productId = productRequest.getProductId();
        this.manufacturer = productRequest.getManufacturer();
        this.productName = productRequest.getProductName();
        this.navCode = productRequest.getNavCode();
        this.pipCode = productRequest.getPipCode();
        this.vat = productRequest.getVat();
        this.batchExpiry = productRequest.getBatchExpiry();
        this.barcode = productRequest.getBarcode();
        this.quantity = productRequest.getQuantity();
        this.status = productRequest.getStatus();
        this.price = productRequest.getPrice();

    }


    public List<TblProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<TblProduct> productList) {
        this.productList = productList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNavCode() {
        return navCode;
    }

    public void setNavCode(String navCode) {
        this.navCode = navCode;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPipCode() {
        return pipCode;
    }

    public void setPipCode(String pipCode) {
        this.pipCode = pipCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastSoldDate() {
        return lastSoldDate;
    }

    public void setLastSoldDate(Date lastSoldDate) {
        this.lastSoldDate = lastSoldDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }
}
