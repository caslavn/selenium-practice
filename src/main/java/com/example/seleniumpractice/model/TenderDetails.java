package com.example.seleniumpractice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tender_details")
public class TenderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tender_id", insertable = false, updatable = false)
    private Integer tender_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tender_id")
    Tender tender;

    @Column(name = "field")
    private String field;

    @Column(name = "value")
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Integer getTender_id() {
        return tender_id;
    }

    public void setTender_id(Integer tender_id) {
        this.tender_id = tender_id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
