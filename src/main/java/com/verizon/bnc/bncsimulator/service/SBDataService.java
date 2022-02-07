package com.verizon.bnc.bncsimulator.service;

import org.springframework.stereotype.Service;

@Service
public interface SBDataService {
    public void save(final String url, final String data, final String requestType);
    public void delete(final String url, final String requestType, final String requestStatus);
}
