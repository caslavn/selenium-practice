package com.example.seleniumpractice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tender")
public class Tender implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tender")
    Set<TenderDetails> tenderDetails = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tender")
    Set<TenderDetails> tenderQueue = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<TenderDetails> getTenderDetails() {
        return tenderDetails;
    }

    public void setTenderDetails(Set<TenderDetails> tenderDetails) {
        this.tenderDetails = tenderDetails;
    }

    public Set<TenderDetails> getTenderQueue() {
        return tenderQueue;
    }

    public void setTenderQueue(Set<TenderDetails> tenderQueue) {
        this.tenderQueue = tenderQueue;
    }
}
