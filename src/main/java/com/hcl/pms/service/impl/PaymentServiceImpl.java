package com.hcl.pms.service.impl;

import com.hcl.pms.dto.CreatePaymentDto;
import com.hcl.pms.model.request.CreatePaymentRequest;
import com.hcl.pms.service.PaymentService;
import com.hcl.pms.service.PaymentSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);


    @Override
    public CompletableFuture<CreatePaymentDto> createPayment(CreatePaymentRequest request) {

        System.out.println(request);

        PaymentSubscriber<CreatePaymentDto> subscriber = new PaymentSubscriber<>();
        CreatePaymentDto paymentResponseDTO = null;
        try {

            paymentResponseDTO = CompletableFuture.supplyAsync(subscriber::getResponse).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("an exception occurred", e);
        }
        return CompletableFuture.completedFuture(paymentResponseDTO);
    }
}
