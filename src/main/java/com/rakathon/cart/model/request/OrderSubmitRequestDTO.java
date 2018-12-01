package com.rakathon.cart.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderSubmitRequestDTO {
    @JsonProperty("memberId")
    String memberId;
}
