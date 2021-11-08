package com.example.seleniumpractice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tender_queue")
public class TenderQueue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "tender_id", insertable = false, updatable = false)
    private Integer tender_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tender_id")
    Tender tender;

    @Embedded
    private QueueingState queueingState = new QueueingState();

    //public TenderQueue(Integer id, Integer tender_id, Tender tender) {
    //  this.id = id;
    //this.tender_id = tender_id;
    //this.tender = tender;
    //this.sendingState = new QueueingState();
    //}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTender_id() {
        return tender_id;
    }

    public void setTender_id(Integer tender_id) {
        this.tender_id = tender_id;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public QueueingState getQueueingState() {
        return queueingState;
    }

    public void setQueueingState(QueueingState queueingState) {
        this.queueingState = queueingState;
    }

}
