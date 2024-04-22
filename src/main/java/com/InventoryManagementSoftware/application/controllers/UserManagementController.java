package com.InventoryManagementSoftware.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.InventoryManagementSoftware.application.ServiceImpl.UserServiceImpl;
import com.InventoryManagementSoftware.application.payload.response.UserInfoResponse;
import com.InventoryManagementSoftware.application.security.services.UserDetailsImpl;
import com.InventoryManagementSoftware.domain.Entities.TblUser;

@Controller
public class UserManagementController {

    UserServiceImpl userService;

    @GetMapping("/admin/userList")
    public String userList(Model model) {
        // List<TblUser> userList = userService.getAllUsers();
        // model.addAttribute("getuser", userList);
        return "admin/usermanagementpage";
    }

}
