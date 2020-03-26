package org.pocketaces.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.pocketaces.entity.TransactionDetail;
import org.pocketaces.exception.CustomException;
import org.pocketaces.exception.Error;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 * @author swatish.s
 */

@Repository("transactionRepository")
public class TransactionRepository {

    private Map<Long, TransactionDetail> transactionDetailMap;
    private Map<String, Set<Long>>       transactionTypeMap;
    private Map<Long, Set<Long>>         parentChildMap;


    public TransactionRepository() {
        transactionDetailMap = new HashMap<>();
        transactionTypeMap = new HashMap<>();
        parentChildMap = new HashMap<>();
    }

    public void addTransaction(final TransactionDetail transactionDetail) throws CustomException {

        if (transactionDetailMap.containsKey(transactionDetail.getId())) {
            throw new CustomException(Error.TRANSACTION_ALREADY_EXISTS);
        }

        transactionDetailMap.put(transactionDetail.getId(), transactionDetail);
        if (transactionTypeMap.containsKey(transactionDetail.getType())) {
            transactionTypeMap.get(transactionDetail.getType()).add(transactionDetail.getId());
        } else {
            final Set<Long> typeSet = new HashSet<>();
            typeSet.add(transactionDetail.getId());
            transactionTypeMap.put(transactionDetail.getType(), typeSet);
        }

        if (Objects.nonNull(transactionDetail.getParentId())) {
            if (parentChildMap.containsKey(transactionDetail.getParentId())) {
                parentChildMap.get(transactionDetail.getParentId()).add(transactionDetail.getId());
            } else {
                final Set<Long> childSet = new HashSet<>();
                childSet.add(transactionDetail.getId());
                parentChildMap.put(transactionDetail.getParentId(), childSet);
            }
        }
    }

    public TransactionDetail getTransactionDetail(final long transactionId) throws CustomException {
        final TransactionDetail response = transactionDetailMap.get(transactionId);
        if (Objects.isNull(response)) {
            throw new CustomException(Error.TRANSACTION_NOT_EXIST);
        }
        return response;
    }

    public Set<Long> getTransactionsWithType(final String type) throws CustomException {
        final Set<Long> response = transactionTypeMap.get(type);
        if (CollectionUtils.isEmpty(response)) {
            throw new CustomException(Error.TRANSACTION_TYPE_NOT_EXIST);
        }
        return response;
    }

    public Double getSumAmount(final long transactionId) throws CustomException {
        if (!transactionDetailMap.containsKey(transactionId)) {
            throw new CustomException(Error.TRANSACTION_NOT_EXIST);
        }

        double sum = 0;

        final Queue<Long> queue = new ConcurrentLinkedQueue<>();
        queue.add(transactionId);
        while (!queue.isEmpty()) {
            final long currTransId = queue.poll();
            sum += transactionDetailMap.get(currTransId).getAmount();
            if (parentChildMap.containsKey(currTransId)) {
                queue.addAll(parentChildMap.get(currTransId));
            }
        }
        return sum;
    }

}
