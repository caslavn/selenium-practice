package com.example.seleniumpractice.queue;

import com.example.seleniumpractice.model.QueueingState;
import com.example.seleniumpractice.model.TenderQueue;
import com.example.seleniumpractice.repository.TenderQueueRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class QueueConsumerModuleService implements QueueConsumerModule<Integer>{


    private final TenderQueueRepository tenderQueueRepository;
    private final EntityManager entityManager;

    public QueueConsumerModuleService(TenderQueueRepository tenderQueueRepository, EntityManager entityManager) {
        this.tenderQueueRepository = tenderQueueRepository;
        this.entityManager = entityManager;
    }



    @Override
    public List<Long> findItemIdsWhereStatusIsPending(int limit) {

        return this.entityManager.createQuery(
                "SELECT tq.id from com.example.seleniumpractice.model.TenderQueue tq where tq.queueingState.status = 'PENDING'" +
                        " and tq.queueingState.deleted='false' order by tq.queueingState.created_at asc")
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public Optional<QueueingState> getQueueingStateForItem(Integer itemId) {
        return this.tenderQueueRepository.findById(itemId).map(TenderQueue::getQueueingState);
    }

    @Override
    public Optional<QueueingState> processItem(Integer itemId) {
        Optional<TenderQueue> tenderQueueOptional = this.tenderQueueRepository.findById(itemId);
        if (tenderQueueOptional.isPresent()){
            TenderQueue tenderQueue  = tenderQueueOptional.get();

            return Optional.of(tenderQueue.getQueueingState());
        }else {
            return Optional.empty();
        }
    }
}
