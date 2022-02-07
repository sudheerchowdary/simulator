package com.verizon.bnc.bncsimulator.service;

import com.verizon.bnc.bncsimulator.util.RequestStatus;
import com.verizon.bnc.bncsimulator.util.RequestType;
import org.springframework.stereotype.Service;

@Service
public interface BNCService {
    public String getData(final String url, final RequestStatus status, final RequestType type) throws Exception;
}
