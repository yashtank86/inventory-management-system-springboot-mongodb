package com.InventoryManagementSoftware.domain.Services;

import java.util.List;

import com.InventoryManagementSoftware.application.payload.response.UserInfoResponse;
import com.InventoryManagementSoftware.domain.Entities.TblUser;

public interface UserService {

    List<TblUser> getAllUsers();

}
