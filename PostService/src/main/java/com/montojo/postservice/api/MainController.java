package com.montojo.postservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String RootController() {
        return "Go to <a href=\"/api/v1/posts\" >api</a>";
    }


    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck(@RequestHeader("ReqHead") String header){
        Map<String, String> map = new HashMap<>();
        map.put("Message", "UP");
        System.out.println("\n****************\n /health has been called\n");
        System.out.println("Header is: " + header + "\n");
        return ResponseEntity.ok(map);
    }
}
