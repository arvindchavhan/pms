package com.hcl.pms.ctrl;

import java.text.DecimalFormat;
import java.util.Random;

import com.hcl.pms.custom.OrderEntryException;
import com.hcl.pms.dto.OrderEntryDto;
import com.hcl.pms.model.AssetDetail;
import com.hcl.pms.repository.AssetDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderEntryCtrl {

    private DecimalFormat df = new DecimalFormat("0.00");
    private Random random = new Random();
    private RestTemplate restTemplate = new RestTemplate();
    
    @Value("${legacy_api_url:http://localhost:8080}")
    private String legacyAPIURL;

    @Autowired
    private AssetDetailRepository assetDetailRepository;
    
    @PostMapping("/orderentry")
    public String createOrderEntry(@RequestBody OrderEntryDto dto){
        AssetDetail assetDetail = assetDetailRepository.findBySecurityName(dto.getFundName());
        if(assetDetail==null) throw new OrderEntryException();
        System.err.println(assetDetail);
        Double unitPrice = restTemplate.getForObject(legacyAPIURL+"/legacy/getUnitPrice/"+dto.getFundName(), Double.class);
        
        return unitPrice+"";
    }

    @GetMapping("/legacy/getUnitPrice/{fundName}")
    public Double getUnitPrice(@PathVariable("fundName") String fundName){
        return Double.valueOf(df.format(random.nextDouble()*100));
    }
}
