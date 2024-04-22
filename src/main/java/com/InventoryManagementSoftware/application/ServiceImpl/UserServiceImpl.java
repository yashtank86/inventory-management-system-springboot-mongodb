package com.InventoryManagementSoftware.application.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.InventoryManagementSoftware.domain.Entities.TblUser;
import com.InventoryManagementSoftware.domain.Services.UserService;
import com.InventoryManagementSoftware.domain.repository.UserRepository;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<TblUser> getAllUsers() {
        return userRepository.findAll();
    }

}
