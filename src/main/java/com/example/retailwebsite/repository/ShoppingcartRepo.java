package com.example.retailwebsite.repository;

import com.example.retailwebsite.model.Shoppingcart;
import com.example.retailwebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingcartRepo extends JpaRepository <Shoppingcart,Long> {

    @Query("select " +
             "i " +
                "from Shoppingcart sc left join sc.inventoryId i " +
            "where sc.userId = :id")
    List<Shoppingcart>findAllProductOfUser(User id);
}
