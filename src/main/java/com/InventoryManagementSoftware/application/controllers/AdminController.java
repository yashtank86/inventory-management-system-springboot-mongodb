package com.InventoryManagementSoftware.application.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.InventoryManagementSoftware.application.Exception.EntityNotFoundException;
import com.InventoryManagementSoftware.application.ServiceImpl.ProductServiceImpl;
import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;

@Controller
public class AdminController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/admin/productList")
    public String adminProduct(Model model) {
        List<TblProduct> productList = productService.getAllProducts();
        if (!productList.isEmpty())
            model.addAttribute("getProducts", productList);

        return "admin/ProductList";
    }

    @GetMapping("/admin/purchaseList")
    public String adminpurchaseList(Model model) {
        List<TblProduct> productList = productService.getAllProducts();
        if (!productList.isEmpty())
            model.addAttribute("getpuchaseList", productList);

        return "admin/purchaseList";
    }

    @GetMapping("/admin/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("addProducts", new PurchaseRequest());
        return "admin/addProductForm";
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(@ModelAttribute("addProducts") PurchaseRequest productRequest, Model model,
            BindingResult result) throws IOException {

        try {

            TblProduct product = new TblProduct(productRequest);
            product.setCreateDate(new Date());
            productService.saveProduct(product);

            // if (product.getProductList().isEmpty()) {
            // throw new EntityNotFoundException("There is no products found!!");
            // }

        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("addProducts", productRequest);
                return "redirect:/admin/addProductForm";
            }
            throw new IOException(e);
        }
        return "redirect:/admin/productList";
    }

    @GetMapping("/admin/editProduct")
    public String editProduct(String productId, Model model) {
        model.addAttribute("editProducts", productService.getAllProducts());
        model.addAttribute("editProducts", new PurchaseRequest());
        return "admin/editProductForm";
    }

    @PostMapping("/admin/editProduct")
    public String editProduct(@ModelAttribute("editProducts") TblProduct productRequest, Model model,
            BindingResult result) throws IOException {

        try {

            Optional<TblProduct> existingProducts = productService.getProductById(productRequest.getProductId());
            if (!existingProducts.isPresent()) {
                throw new EntityNotFoundException("There is no products found!!");
            }
            // productService.updateProduct(productRequest);

        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("editProducts", productRequest);
                return "redirect:/user/editProductForm";
            }
            throw new IOException(e);
        }

        return "redirect:/admin/productList";
    }

}
