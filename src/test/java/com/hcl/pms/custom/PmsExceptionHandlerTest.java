package com.hcl.pms.custom;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

class PmsExceptionHandlerTest {

    OrderEntryException orderEntryException = new OrderEntryException(Mockito.anyString(), Mockito.anyString());

    @Test
    void orderEntryException() {
        PmsExceptionHandler pmsExceptionHandler = new PmsExceptionHandler();
       Assert.notNull(pmsExceptionHandler.orderEntryException(orderEntryException));
    }
}