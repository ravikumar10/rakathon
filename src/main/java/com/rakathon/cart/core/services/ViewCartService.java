package com.rakathon.cart.core.services;

import com.rakathon.cart.core.services.repository.OrderByMemberIdService;
import com.rakathon.cart.core.services.repository.OrderRepositoryService;
import com.rakathon.cart.domain.Order;
import com.rakathon.cart.domain.OrderByMemberId;
import com.rakathon.cart.model.request.ViewCartRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViewCartService {

    @Autowired
    OrderRepositoryService orderRepositoryService;

    @Autowired
    OrderByMemberIdService orderByMemberIdService;

    public Order getOrderItems(ViewCartRequestDTO viewCartRequestDTO){
        String memberId = viewCartRequestDTO.getMemberId();
        Order order = null;
        Optional<OrderByMemberId> orderByMemberId = orderByMemberIdService.findById(Integer.parseInt(memberId));
        if(orderByMemberId.isPresent()) {
            OrderByMemberId orderMid = orderByMemberId.get();
            Integer orderId = orderMid.getOrderId();
            Optional<Order> orderOptional = orderRepositoryService.findById(orderId);
            if (orderOptional.isPresent()) {
                order = orderOptional.get();
            }
        }
        return order;
    }

}
