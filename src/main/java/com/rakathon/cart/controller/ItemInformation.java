package com.rakathon.cart.controller;

import com.rakathon.cart.core.services.repository.ItemRepositoryService;
import com.rakathon.cart.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ItemInformation.BASE_URL)
public class ItemInformation {
    static final String BASE_URL="/item";

    @Autowired
    ItemRepositoryService itemRepositoryServicel;

    @GetMapping("/list")
    public ResponseEntity<String> getItemList(){
        List<Item> itemList = itemRepositoryServicel.findAll();

        return new ResponseEntity(itemList, HttpStatus.OK);
    }
}
