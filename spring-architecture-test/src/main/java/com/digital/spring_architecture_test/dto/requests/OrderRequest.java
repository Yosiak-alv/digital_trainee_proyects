package com.digital.spring_architecture_test.dto.requests;

import com.digital.spring_architecture_test.common.validation.NotEmptyArray;
import com.digital.spring_architecture_test.common.validation.ValidPaymentType;
import com.digital.spring_architecture_test.enums.PaymentType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrderRequest {

    @NotNull
    @Digits(integer = 10, fraction = 0)
    @Min(value = 1, message = "Client id must be greater than 0")
    private Long clientId;

    @NotNull
    //@ValidPaymentType
    private PaymentType paymentType;

    @NotNull
    @NotEmptyArray
    private Long[] productIds;
}
