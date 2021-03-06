package com.hcl.pms.controller;

import com.hcl.pms.dto.CreatePaymentDto;
import com.hcl.pms.model.OrderDetail;
import com.hcl.pms.model.exception.PaymentInputException;
import com.hcl.pms.model.request.CreatePaymentRequest;
import com.hcl.pms.model.response.ResponseDTO;
import com.hcl.pms.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO<OrderDetail>> createPayment(@RequestBody CreatePaymentRequest request) {
        LOGGER.info("request : " + request);

        ResponseDTO<OrderDetail> responseDTO = new ResponseDTO<>();

        if(request.getOrderRef() == null) {
            throw new PaymentInputException("invalid oder ref", "error in order ref");
        }
        if(request.getAmount() == null) {
            throw new PaymentInputException("invalid amount", "error in amount");
        }
        try {
            CompletableFuture<OrderDetail> response = paymentService.createPayment(request);
            OrderDetail dto = response.get();
            if (dto == null) {
                LOGGER.error("request is timeout");
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
            } else if (!dto.isOperationSuccess()) {
                responseDTO.setSuccess(false);
                responseDTO.setMessage(dto.getMessage());
                LOGGER.error(dto.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
            } else {
                responseDTO.setSuccess(true);
                responseDTO.setMessage(dto.getMessage());
                responseDTO.setResponse(dto);
                LOGGER.info(dto.getMessage());
                return ResponseEntity.ok(responseDTO);
            }
        } catch (Exception ex) {
            LOGGER.error("an exception occurred", ex);
            responseDTO.setSuccess(false);
            responseDTO.setMessage("An error occurred while processing the request");
        }
        return ResponseEntity.internalServerError().body(responseDTO);
    }

}
