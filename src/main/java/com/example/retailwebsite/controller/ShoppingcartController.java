package com.example.retailwebsite.controller;

import com.example.retailwebsite.model.Shoppingcart;
import com.example.retailwebsite.model.User;
import com.example.retailwebsite.repository.ShoppingcartRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/cart")
public class ShoppingcartController {

    ShoppingcartRepo shoppingcartRepo;

    @GetMapping("/getallcart")
    public ResponseEntity<List<Shoppingcart>> getAllCart() {
        try {
            List<Shoppingcart> carts = new ArrayList<Shoppingcart>();
            carts.addAll(shoppingcartRepo.findAll());
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createcart")
    public ResponseEntity<Shoppingcart> createShoppingcart(@RequestBody Shoppingcart shoppingcart) {
        try {
            Shoppingcart _cart = shoppingcartRepo.save(new Shoppingcart(shoppingcart.getUserId(), shoppingcart.getInventoryId(), shoppingcart.getTotalprice()))

            return new ResponseEntity<>(_cart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/finishcart")
    public ResponseEntity<Shoppingcart> hesapla(@RequestBody Shoppingcart shoppingcart) {
        try {
            Shoppingcart _cart = shoppingcartRepo.save(new Shoppingcart(shoppingcart.getUserId(), shoppingcart.getInventoryId(), shoppingcart.getTotalprice()));
            // findbyuserid cart döncek sonra gelen cartın içinden ....
            // total price gelicek nasıkl gelicek şöyle.. cartın içindne tüm productların priiceları toplancak
            // cartin içndne user id yi çek daha sonra userın özelliğine göre ifflere gir olcak
            return new ResponseEntity<>(_cart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
