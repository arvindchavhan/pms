package com.hcl.pms.service;

import com.hcl.pms.dto.CreatePaymentDto;
import com.hcl.pms.model.request.CreatePaymentRequest;

import java.util.concurrent.CompletableFuture;

public interface PaymentService {

    CompletableFuture<CreatePaymentDto>  createPayment(CreatePaymentRequest request);
}
