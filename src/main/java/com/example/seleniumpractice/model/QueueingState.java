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

    @Column(name = "attempt_count")
    private int attempt_count;

    public QueueingState() {
        this.status = Status.PENDING;
        this.attempt_count = 0;
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

    public int getAttempt_count() {
        return attempt_count;
    }

    public void registerAttemptSuccess(LocalDateTime time) {
        this.attempt_count++;
        this.created_at = Objects.requireNonNull(created_at);
        this.last_updated = Objects.requireNonNull(time);
        this.deleted = Objects.requireNonNull(true);

        this.status = Status.SUCCESS;
    }

    public void registerAttemptFailure(LocalDateTime time, Throwable error) {
        this.attempt_count++;
        this.created_at = Objects.requireNonNull(created_at);
        this.last_updated = Objects.requireNonNull(time);

        if (attempt_count == 2) {
            this.status = Status.ERROR;
            this.deleted= true;
        }
    }

}
