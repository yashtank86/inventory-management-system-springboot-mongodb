package com.InventoryManagementSoftware.domain.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tblRoles")
public class TblRole {
    @Id
    private String id;
    private ERole name;

    public TblRole() { }

    public TblRole(ERole name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}

