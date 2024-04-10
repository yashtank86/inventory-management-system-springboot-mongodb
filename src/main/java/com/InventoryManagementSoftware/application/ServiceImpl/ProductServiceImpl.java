package com.InventoryManagementSoftware.application.ServiceImpl;

import com.InventoryManagementSoftware.application.Exception.EntityNotFoundException;
import com.InventoryManagementSoftware.application.payload.request.ProductRequest;
import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.domain.Services.ProductService;
import com.InventoryManagementSoftware.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public TblProduct saveProduct(TblProduct products) {
        products.setProductId(UUID.randomUUID().toString().split("-")[0]);
        return productRepository.save(products);
    }

    @Override
    public List<TblProduct> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<TblProduct> getProductByManufacturer(String manufacturer) {
        return productRepository.findByManufacturer(manufacturer);
    }

    @Override
    public Optional<TblProduct> getProductById(String productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public TblProduct updateProduct(ProductRequest productRequest) {

        Optional<TblProduct> existingProducts = productRepository.findById(productRequest.getProductId());
        if (!existingProducts.isPresent()){
            throw new EntityNotFoundException("products is not Found");
        }
        TblProduct updateProducts = existingProducts.get();
        updateProducts.setManufacturer(productRequest.getManufacturer());
        updateProducts.setProductName(productRequest.getProductName());
        updateProducts.setNavCode(productRequest.getNavCode());
        updateProducts.setBarcode(productRequest.getBarcode());
        updateProducts.setBatchExpiry(productRequest.getBatchExpiry());
        updateProducts.setQuantity(productRequest.getQuantity());
        updateProducts.setPrice(productRequest.getPrice());
        updateProducts.setPipCode(productRequest.getPipCode());
        updateProducts.setVat(productRequest.getVat());
        return productRepository.save(updateProducts);
    }


}
