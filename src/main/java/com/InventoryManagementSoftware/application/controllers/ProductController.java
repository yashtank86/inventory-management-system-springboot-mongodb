package com.InventoryManagementSoftware.application.controllers;

import com.InventoryManagementSoftware.application.Exception.EntityNotFoundException;
import com.InventoryManagementSoftware.application.ServiceImpl.ProductServiceImpl;
import com.InventoryManagementSoftware.application.payload.request.ProductRequest;
import com.InventoryManagementSoftware.application.payload.response.MessageResponse;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.domain.Entities.TblUser;
import com.InventoryManagementSoftware.domain.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/user/productList")
    public String getProducts(Model model) {

        List<TblProduct> productList = productService.getAllProducts();
        if (!productList.isEmpty()) {
            model.addAttribute("getProducts", productList);
        }
        return "user/productList";
    }

    @GetMapping("/user/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("addProducts", new ProductRequest());
        return "user/addProductForm";
    }

    @PostMapping("/user/addProduct/save")
    public String addProduct(@ModelAttribute("addProducts") ProductRequest productRequest, Model model,
            BindingResult result) throws IOException {

        try {

            TblProduct product = new TblProduct(productRequest);
            if (product.getProductList().isEmpty()) {
                throw new EntityNotFoundException("There is no products found!!");
            }
            product.setCreateDate(new Date());
            productService.saveProduct(product);

        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("addProducts", productRequest);
                return "redirect:/user/addProductForm";
            }
            throw new IOException(e);
        }
        return "redirect:/user/productList";
    }

    @GetMapping("/user/editProduct")
    public String editProduct(String productId, Model model) {
        Optional<TblProduct> existingProducts = productService.getProductById(productId);
        model.addAttribute("editProducts", existingProducts);
        model.addAttribute("editProducts", new ProductRequest());
        return "user/editProductForm";
    }

    @PostMapping("/user/editProduct/save")
    public String editProduct(@ModelAttribute("editProducts") ProductRequest productRequest, Model model,
            BindingResult result) throws IOException {

        try {

            Optional<TblProduct> existingProducts = productService.getProductById(productRequest.getProductId());
            if (!existingProducts.isPresent()) {
                throw new EntityNotFoundException("There is no products found!!");
            }
            productService.updateProduct(productRequest);

        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("editProducts", productRequest);
                return "redirect:/user/editProductForm";
            }
            throw new IOException(e);
        }

        return "redirect:/user/productList";
    }

}