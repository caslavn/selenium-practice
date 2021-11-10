package com.example.seleniumpractice.queue;

import com.example.seleniumpractice.model.QueueingState;

import java.util.List;
import java.util.Optional;

public interface QueueConsumerModule<Integer> {

    List<Long> findItemIdsWhereStatusIsPending(int limit);

    Optional<QueueingState> getQueueingStateForItem(Integer itemId);

    Optional<QueueingState> processItem(Integer itemId);
}
