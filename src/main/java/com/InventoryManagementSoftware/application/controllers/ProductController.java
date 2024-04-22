package com.InventoryManagementSoftware.application.controllers;

import com.InventoryManagementSoftware.application.ServiceImpl.ProductServiceImpl;
import com.InventoryManagementSoftware.application.payload.request.ProductRequest;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.infrastructure.ExcelProductListView;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.*;

@Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(ProductController.class);

    @GetMapping("/export-to-excel")
    public void exportInfoExcelFile(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.ms-excel");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=productList_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<TblProduct> productList = productService.getAllProducts();
        ExcelProductListView generator = new ExcelProductListView(productList);
        generator.generateExcelFile(response);

    }

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

    @PostMapping("/user/addProduct")
    public String addProduct(@ModelAttribute("addProducts") ProductRequest productRequest, Model model,
            BindingResult result) throws IOException {

        try {
            TblProduct product = new TblProduct(productRequest);
            product.setCreateDate(new Date());
            logger.info("saving product : " + product);
            productService.saveProduct(product);
            logger.info("Product added successfully");
        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("addProducts", productRequest);
                return "redirect:/user/addProductForm";
            }
        }
        return "redirect:/user/productList";
    }

    @GetMapping(path = { "/user/editProduct", "/user/editProduct/{productId}" })
    public String editProduct(String productId, Model model, ProductRequest request) {
        TblProduct product = productService.getProductById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productId));

        model.addAttribute("productget", product);
        return "user/editProductForm";
    }

    @PostMapping(path = { "/user/editProduct", "/user/editProduct/{productId}" })
    public String editProduct(@ModelAttribute("productget") ProductRequest productRequest, Model model,
            BindingResult result, Optional<TblProduct> productId) throws IOException {

        try {

            if (productId.isPresent()) {
                Optional<TblProduct> edtUser = productService.getProductById(productRequest.getProductId());
                model.addAttribute("productget", edtUser);
                model.addAttribute("productget", new ProductRequest());
                productService.updateProduct(productRequest);
            }

        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("productget", productRequest);
                return "redirect:/user/editProductForm";
            }
            throw new IOException(e);
        }

        return "redirect:/user/productList";
    }

}