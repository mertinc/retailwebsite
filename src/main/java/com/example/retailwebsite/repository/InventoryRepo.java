package com.example.retailwebsite.repository;

import com.example.retailwebsite.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {

    List<Inventory> findByStock(boolean stock);
    List<Inventory> findByProductContaining(String product);
}
