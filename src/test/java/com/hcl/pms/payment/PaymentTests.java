package com.hcl.pms.payment;

import com.hcl.pms.dto.PaymentStatusDto;
import com.hcl.pms.model.OrderDetail;
import com.hcl.pms.model.exception.PaymentInputException;
import com.hcl.pms.repository.OrderDetailRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class PaymentTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

//    @Test
//    void createPaymentWithInputOderRefAndAmountAndSetOderStatusAndTransactionId() {
//        Long orderRefNo = 1L;
//        double orderValue = 700.00;
//        String orderStatus  = PaymentStatusDto.COMPLETED.name();
//        String transactionId = UUID.randomUUID().toString();
//
//        Optional<OrderDetail> orderDetailOp = orderDetailRepository.findById(orderRefNo);
//        OrderDetail orderDetail =  orderDetailOp.get();
//        orderDetail.setOrderStatus(orderStatus);
//        orderDetail.setOrderRefNo(orderRefNo);
//        orderDetail.setTransactionId(transactionId);
//        orderDetail.setOrderValue(orderValue);
//
//        OrderDetail updatedOderDetail = orderDetailRepository.save(orderDetail);
//        Assertions.assertThat(updatedOderDetail.getOrderRefNo()).isEqualTo(orderRefNo);
//        Assertions.assertThat(updatedOderDetail.getTransactionId()).isEqualTo(transactionId);
//        Assertions.assertThat(updatedOderDetail.getOrderStatus()).isEqualTo(orderStatus);
//        Assertions.assertThat(updatedOderDetail.getOrderValue()).isEqualTo(orderValue);
//
//    }
//
//    @Test
//    void createPaymentWithInvalidAmount() {
//        Long orderRefNo = 1L;
//        String orderStatus  = PaymentStatusDto.COMPLETED.name();
//        String transactionId = UUID.randomUUID().toString();
//
//        Optional<OrderDetail> orderDetailOp = orderDetailRepository.findById(orderRefNo);
//        OrderDetail orderDetail =  orderDetailOp.get();
//        orderDetail.setOrderStatus(orderStatus);
//        orderDetail.setOrderRefNo(orderRefNo);
//        orderDetail.setTransactionId(transactionId);
//        orderDetail.setOrderValue(null);
//
//        OrderDetail updatedOderDetail = orderDetailRepository.save(orderDetail);
//
//    }
//


}
