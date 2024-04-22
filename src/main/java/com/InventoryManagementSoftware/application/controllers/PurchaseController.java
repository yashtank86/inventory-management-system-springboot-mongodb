package com.InventoryManagementSoftware.application.controllers;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.InventoryManagementSoftware.application.ServiceImpl.PurchaseServiceImpl;
import com.InventoryManagementSoftware.application.payload.request.PurchaseRequest;
import com.InventoryManagementSoftware.domain.Entities.TblPurchase;

@Controller
public class PurchaseController {

    // @Autowired
    PurchaseServiceImpl purchaseService;

    @GetMapping("/admin/purchaseList")
    public String purchaseList() {
        return "admin/purchaseList";
    }

    @GetMapping("/admin/addPurchase")
    public String addProduct(Model model) {
        // model.addAttribute("objPurchases", new PurchaseRequest());
        return "admin/addPurchaseForm";
    }

    @PostMapping("/admin/addpurchase/save")
    public String addProduct(@ModelAttribute("objPurchases") PurchaseRequest purchaseRequest, Model model,
            BindingResult result) throws IOException {

        try {

            TblPurchase purchase = new TblPurchase(purchaseRequest);
            purchase.setCreatedDate(new Date());
            purchaseService.savePurchases(purchase);

        } catch (Exception e) {
            if (result.hasErrors()) {
                model.addAttribute("objPurchases", purchaseRequest);
                return "redirect:/admin/addPurchaseForm";

            } else
                throw new IOException(e);

        }
        return "redirect:/admin/purchaseList";
    }

}
