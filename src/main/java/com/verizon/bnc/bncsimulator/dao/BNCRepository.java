package com.verizon.bnc.bncsimulator.dao;

import com.verizon.bnc.bncsimulator.entity.SBData;
import com.verizon.bnc.bncsimulator.entity.SBDataId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BNCRepository extends CrudRepository<SBData, SBDataId> {
}
