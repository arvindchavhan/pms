package com.hcl.pms.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PmsExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<CustomGlobalError>


}
