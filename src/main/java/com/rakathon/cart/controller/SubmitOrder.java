package com.rakathon.cart.controller;


import com.rakathon.cart.core.services.OrderSubmitService;
import com.rakathon.cart.model.request.OrderSubmitRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(SubmitOrder.SUBMIT_CART)
public class SubmitOrder {
    static final String SUBMIT_CART="/order";

    @Autowired
    OrderSubmitService orderSubmitService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder(@RequestBody @Valid OrderSubmitRequestDTO orderSubmitRequestDTO) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
