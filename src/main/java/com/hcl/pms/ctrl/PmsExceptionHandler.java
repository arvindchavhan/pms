package com.hcl.pms.ctrl;

import com.hcl.pms.custom.OrderEntryException;
import com.hcl.pms.model.CustomGlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PmsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderEntryException.class)
    public ResponseEntity<CustomGlobalError> orderEntryException() {
        CustomGlobalError globalError=new CustomGlobalError();
        globalError.setErrorReason("Internal Server Error");
        globalError.setMessage("Order Entry Exception");
        return new ResponseEntity<>(globalError, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
