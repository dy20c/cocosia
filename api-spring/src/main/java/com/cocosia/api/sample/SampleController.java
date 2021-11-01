package com.cocosia.api.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Value("${localhost.uri}")
    private String reqUri;

    @GetMapping("/test")
    public String test(){
        return reqUri;
    }

}
