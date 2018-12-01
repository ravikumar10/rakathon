package com.rakathon.cart.core.services;

import com.rakathon.cart.core.services.repository.ItemRepositoryService;
import com.rakathon.cart.core.services.repository.OrderByMemberIdService;
import com.rakathon.cart.core.services.repository.OrderRepositoryService;
import com.rakathon.cart.domain.Item;
import com.rakathon.cart.domain.Order;
import com.rakathon.cart.domain.OrderByMemberId;
import com.rakathon.cart.model.request.AddToCartRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddToCartService {
    @Autowired
    ItemRepositoryService itemRepositoryService;

    @Autowired
    OrderRepositoryService orderRepositoryService;

    @Autowired
    OrderByMemberIdService orderByMemberIdService;

    public boolean addItemToCart(AddToCartRequestDTO addToCartRequestDTO){

        Optional<Item> optionalItem = itemRepositoryService.findById(Integer.parseInt(addToCartRequestDTO.getItemNumber()));

        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            Optional<OrderByMemberId> orderByMemberId = orderByMemberIdService.findById(Integer.parseInt(addToCartRequestDTO.getMemberId()));
            if(orderByMemberId.isPresent()) {
                OrderByMemberId ordermemId = orderByMemberId.get();
                Optional<Order> orderOptional = orderRepositoryService.findById(ordermemId.getOrderId());
                if(orderOptional.isPresent()){
                    Order order = orderOptional.get();
                    Optional<Item> OptionalDbItem = order.getOrderItems()
                            .stream()
                            .filter(orderItem -> {
                                return orderItem.getItemNumber() == item.getItemNumber() ? true : false;
                            })
                            .findFirst();

                    if(OptionalDbItem.isPresent()){
                        Item itemToBeSaved = OptionalDbItem.get();
                        itemToBeSaved.setQuantity(itemToBeSaved.getQuantity()+1);
                        orderRepositoryService.save(order);
                    }
                    else {
                        order.getOrderItems().add(item);
                        orderRepositoryService.save(order);
                    }
                }
                else {
                    Order order = new Order();
                    order.getOrderItems().add(item);
                    orderRepositoryService.save(order);

                    ordermemId.setMemberId(Integer.parseInt(addToCartRequestDTO.getMemberId()));
                    ordermemId.setOrderId(order.getOrderNumber());
                    orderByMemberIdService.save(ordermemId);
                }
            }
            else {
                Order order = new Order();
                order.getOrderItems().add(item);
                orderRepositoryService.save(order);
                OrderByMemberId ordermemId = new OrderByMemberId();
                ordermemId.setMemberId(Integer.parseInt(addToCartRequestDTO.getMemberId()));
                ordermemId.setOrderId(order.getOrderNumber());
                orderByMemberIdService.save(ordermemId);
            }
            return true;
        }
        return false;
    }

}
