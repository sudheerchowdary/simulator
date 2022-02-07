package com.verizon.bnc.bncsimulator.service;

import com.verizon.bnc.bncsimulator.dao.BNCRepository;
import com.verizon.bnc.bncsimulator.entity.SBData;
import com.verizon.bnc.bncsimulator.entity.SBDataId;
import com.verizon.bnc.bncsimulator.util.RequestStatus;
import com.verizon.bnc.bncsimulator.util.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.Optional;

@Service
public class BNCServiceImpl implements BNCService {

    @Autowired
    private BNCRepository bncRepository;

    @Override
    public String getData(final String url, final RequestStatus status, final RequestType type) throws Exception {
        final Optional<SBData> data = this.bncRepository.findById(new SBDataId(url, type.name(), status.name()));
        if (data.isPresent())
            throw new Exception("Data not found for the url : " + url);
        else
            return data.get().getData();
    }

    @PreDestroy
    private void clean(){
        this.bncRepository = null;
    }
}
