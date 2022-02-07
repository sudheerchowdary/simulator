package com.verizon.bnc.bncsimulator.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.EmbeddedId;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "SB_DATA")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class SBData implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @EmbeddedId
    private SBDataId sbDataId;

    @Type(type = "json")
    @Column(name = "data", columnDefinition = "json", nullable = false)
    private String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SBDataId getSbDataId() {
        if(sbDataId==null)
            sbDataId = new SBDataId();
        return sbDataId;
    }

    public void setSbDataId(SBDataId sbDataId) {
        this.sbDataId = sbDataId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
