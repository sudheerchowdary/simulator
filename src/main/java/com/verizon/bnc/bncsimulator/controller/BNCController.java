package com.verizon.bnc.bncsimulator.controller;

import com.verizon.bnc.bncsimulator.service.BNCService;
import com.verizon.bnc.bncsimulator.util.JsonUtil;
import com.verizon.bnc.bncsimulator.util.RequestStatus;
import com.verizon.bnc.bncsimulator.util.RequestType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/restconf")
public class BNCController {

    private static final Logger LOG = LoggerFactory.getLogger(BNCController.class);

    @Value("${server.port}")
    private String port;

    @Autowired
    private JsonUtil util;
    @Autowired
    private BNCService bncService;

    @GetMapping(value = "/**", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(HttpServletRequest request) {
        try {
            final String response = this.getResponse(request, RequestType.GET);
            LOG.debug("Response : {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Exception while executing get -  Ex: {}", e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/**")
    public ResponseEntity<String> post(HttpServletRequest request) {
        try {
            final String response = this.getResponse(request, RequestType.POST);
            LOG.debug("Response : {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            LOG.error("Exception while executing post -  Ex: {}", e);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/**")
    public ResponseEntity<String> put(HttpServletRequest request) {
        try {
            final String response = this.getResponse(request, RequestType.PUT);
            LOG.debug("Response : {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            LOG.error("Exception while executing post -  Ex: {}", e);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/**")
    public ResponseEntity<String> delete(HttpServletRequest request) {
        try {
            final String response = this.getResponse(request, RequestType.DELETE);
            LOG.debug("Response : {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            LOG.error("Exception while executing post -  Ex: {}", e);
            return ResponseEntity.notFound().build();
        }
    }

    public String getResponse(final HttpServletRequest request, final RequestType requestType) throws Exception {
        final String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .build()
                .toUriString()
                .split(port)[1];
        LOG.debug("Base URL: {}", baseUrl);
        final String response = this.bncService.getData(baseUrl, RequestStatus.SUCCESS, requestType);
        return response.substring(1,response.length()-1).replaceAll("\\\\","");
    }

    @PreDestroy
    private void clean(){
        this.bncService = null;
    }
}
