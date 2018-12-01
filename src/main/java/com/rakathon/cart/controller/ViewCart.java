package com.rakathon.cart.controller;

import com.rakathon.cart.model.request.ViewCartRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(ViewCart.VIEW_CART)
public class ViewCart {
    static final String VIEW_CART="/view";

    @GetMapping("/")
    public ResponseEntity<String> viewCart(@RequestBody @Valid ViewCartRequestDTO viewCartRequestDTO){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
