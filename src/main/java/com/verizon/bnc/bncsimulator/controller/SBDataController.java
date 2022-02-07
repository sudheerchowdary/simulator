package com.verizon.bnc.bncsimulator.controller;

import com.verizon.bnc.bncsimulator.bean.SBDataBean;
import com.verizon.bnc.bncsimulator.service.SBDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sb")
public class SBDataController {

    @Autowired
    private SBDataService sbDataService;

    @PostMapping("/save")
    private ResponseEntity<String> save(@RequestBody SBDataBean nbDataBean){
        if(nbDataBean!=null) {
            this.sbDataService.save(nbDataBean.getUrl(), nbDataBean.getData(), nbDataBean.getRequestType());
            return ResponseEntity.accepted().build();
        } else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/delete")
    private ResponseEntity<String> delete(@RequestBody SBDataBean nbDataBean){
        if(nbDataBean!=null) {
            this.sbDataService.delete(nbDataBean.getUrl(), nbDataBean.getRequestType(), nbDataBean.getRequestStatus());
            return ResponseEntity.accepted().build();
        } else
            return ResponseEntity.badRequest().build();
    }
}
