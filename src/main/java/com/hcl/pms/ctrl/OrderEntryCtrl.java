package com.hcl.pms.ctrl;

import com.hcl.pms.dto.OrderEntryDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderEntryCtrl {
    
    @PostMapping("orderentry")
    private String createOrderEntry(@RequestBody OrderEntryDto dto){

        return "";
    }
}
