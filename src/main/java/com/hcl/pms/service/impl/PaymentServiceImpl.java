package com.hcl.pms.service.impl;

import com.hcl.pms.dto.CreatePaymentDto;
import com.hcl.pms.dto.PaymentStatusDto;
import com.hcl.pms.model.OrderDetail;
import com.hcl.pms.model.request.CreatePaymentRequest;
import com.hcl.pms.repository.OrderDetailRepository;
import com.hcl.pms.service.PaymentService;
import com.hcl.pms.service.PaymentSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public CompletableFuture<OrderDetail> createPayment(CreatePaymentRequest request) {

        OrderDetail orderDetail = orderDetailRepository.getById(request.getOrderRef());

        UUID uuid = UUID.randomUUID();
        orderDetail.setTransactionId(uuid.toString());

        orderDetail.setOrderStatus(PaymentStatusDto.COMPLETED.name());

        PaymentSubscriber<OrderDetail> subscriber = new PaymentSubscriber<>();
        CreatePaymentDto paymentResponseDTO = null;
        CompletableFuture<OrderDetail> savedOderDetail = CompletableFuture.supplyAsync(() -> orderDetailRepository.save(orderDetail));
        //  OrderDetail orderDetail1Resp = CompletableFuture.supplyAsync(subscriber::getResponse).get();
        return  savedOderDetail;
    }
}
