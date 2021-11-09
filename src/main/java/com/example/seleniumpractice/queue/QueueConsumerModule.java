package com.example.seleniumpractice.queue;

import com.example.seleniumpractice.model.QueueingState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QueueConsumerModule<Integer> {

    List<Long> findItemIdsWhereStatusIsPending(LocalDateTime time, int limit);

    Optional<QueueingState> getQueueingStateForItem(Integer itemId);

    Optional<QueueingState> processItem(Integer itemId);
}
