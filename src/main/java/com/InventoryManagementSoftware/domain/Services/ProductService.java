package com.InventoryManagementSoftware.domain.Services;

import com.InventoryManagementSoftware.application.Exception.EntityNotFoundException;
import com.InventoryManagementSoftware.application.payload.request.ProductRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    TblProduct saveProduct(TblProduct products);

    List<TblProduct> getAllProducts();

    List<TblProduct> getProductByManufacturer(String manufacturer);
    Optional<TblProduct> getProductById(String productId);

    TblProduct updateProduct(ProductRequest productRequest) throws EntityNotFoundException;



}

