package com.example.seleniumpractice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class QueueingState {

    public enum Status {
        PENDING,
        ERROR,
        SUCCESS
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public Status status;

    @Column(name = "created_at")
    public LocalDateTime created_at;

    @Column(name = "last_updated")
    public LocalDateTime last_updated;

    @Column(name = "deleted")
    public Boolean deleted;

    public QueueingState() {
        this.status = Status.PENDING;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void scheduleNextAttempt(LocalDateTime created_at) {
        this.created_at = Objects.requireNonNull(created_at);
    }

    public void registerAttemptSuccess(LocalDateTime time) {
        this.created_at = Objects.requireNonNull(created_at);
        this.last_updated = Objects.requireNonNull(time);
        this.deleted = Objects.requireNonNull(true);

        this.status = Status.SUCCESS;
    }

    public void registerAttemptFailure(LocalDateTime time, Throwable error) {
        this.created_at = Objects.requireNonNull(created_at);
        this.last_updated = Objects.requireNonNull(time);

        this.status = Status.ERROR;
    }

}
