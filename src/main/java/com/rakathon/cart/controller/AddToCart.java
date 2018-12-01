package com.rakathon.cart.controller;


import com.rakathon.cart.core.services.AddToCartService;
import com.rakathon.cart.model.request.OrderSubmitRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(AddToCart.ADD_TO_CART)
public class AddToCart {
    static final String ADD_TO_CART="/add";

    @Autowired
    AddToCartService addToCartService;

    @GetMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody @Valid OrderSubmitRequestDTO submitRequestDTO) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
