package com.verizon.bnc.bncsimulator.service;

import com.verizon.bnc.bncsimulator.dao.BNCRepository;
import com.verizon.bnc.bncsimulator.entity.SBData;
import com.verizon.bnc.bncsimulator.entity.SBDataId;
import com.verizon.bnc.bncsimulator.util.RequestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SBDataServiceImpl implements SBDataService {

    private static Logger LOG = LoggerFactory.getLogger(SBDataServiceImpl.class);

    @Autowired
    private BNCRepository bncRepository;

    public void save(final String url, final String data, final String requestType) {
        LOG.debug("Saving data to db started for url: {}, data: {}, request-type: {}", url, data, requestType);
        try {
            final SBData sbData = new SBData();
            sbData.getSbDataId().setUrl(url);
            sbData.setData(data);
            sbData.getSbDataId().setRequestType(requestType);
            sbData.getSbDataId().setRequestStatus(RequestStatus.SUCCESS.name());
            this.bncRepository.save(sbData);
        } catch (Exception e) {
            LOG.error("Exception while saving data to DB. ex: {}", e);
        }
    }

    @Override
    public void delete(String url, String requestType, String requestStatus) {
        LOG.debug("Deleting data from db started for url: {}, request-type: {}, requestStatus: {}", url, requestType, requestStatus);
        try {
            final Optional<SBData> data = this.bncRepository.findById(new SBDataId(url, requestType, requestStatus));
            this.bncRepository.delete(data.get());
        } catch (Exception e) {
            LOG.error("Exception while deleting data from DB. ex: {}", e);
        }
    }
}
