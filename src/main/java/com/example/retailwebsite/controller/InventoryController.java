package com.example.retailwebsite.controller;


import com.example.retailwebsite.model.Inventory;
import com.example.retailwebsite.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InventoryController {
    @Autowired
    InventoryRepo inventoryRepo;

    @GetMapping("/products")
    public ResponseEntity<List<Inventory>> getAllInventories(@RequestParam(required = false) String product) {
        try {
            List<Inventory> products = new ArrayList<Inventory>();
            if (product == null)
                inventoryRepo.findAll().forEach(products::add);
            else
                inventoryRepo.findByProductContaining(product).forEach(products::add);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") long id) {
        Optional<Inventory> inventoryData = inventoryRepo.findById(id);
        if (inventoryData.isPresent()) {
            return new ResponseEntity<>(inventoryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        try {
            Inventory _inventory = inventoryRepo.save(new Inventory(inventory.getProduct(), inventory.getDescription(), inventory.getPrice(), false));
            return new ResponseEntity<>(_inventory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable("id") long id, @RequestBody Inventory inventory) {
        Optional<Inventory> inventoryData = inventoryRepo.findById(id);
        if (inventoryData.isPresent()) {
            Inventory _inventory = inventoryData.get();
            _inventory.setProduct(inventory.getProduct());
            _inventory.setDescription(inventory.getDescription());
            _inventory.setPrice(inventory.getPrice());
            _inventory.setStock(inventory.isStock());
            return new ResponseEntity<>(inventoryRepo.save(_inventory), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteInventory(@PathVariable("id") long id) {
        try {
            inventoryRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllInventory(){
        try{
        inventoryRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch(Exception e)
    {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Inventory>> findByPublished() {
        try {
            List<Inventory> inventories = inventoryRepo.findByStock(true);
            if (inventories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
