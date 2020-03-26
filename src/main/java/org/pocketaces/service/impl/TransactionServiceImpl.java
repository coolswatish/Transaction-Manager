package org.pocketaces.service.impl;

import java.util.Set;

import org.pocketaces.dto.TransactionDTO;
import org.pocketaces.entity.TransactionDetail;
import org.pocketaces.exception.CustomException;
import org.pocketaces.repository.TransactionRepository;
import org.pocketaces.service.TransactionService;
import org.pocketaces.transformer.TransactionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * @author swatish.s
 */

@Service("transactionService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository  transactionRepository;
    private final TransactionTransformer transactionTransformer;

    @Override
    public void addTransaction(final long transactionId, final TransactionDTO transactionDTO) throws CustomException {
        transactionRepository
                .addTransaction(transactionTransformer.getTransactionDetail(transactionId, transactionDTO));
    }

    @Override
    public TransactionDTO getTransactionById(final long transactionId) throws CustomException {
        final TransactionDetail transactionDetail = transactionRepository.getTransactionDetail(transactionId);
        return transactionTransformer.getTransactionDTO(transactionDetail);
    }

    @Override
    public Set<Long> getTransactionByType(final String type) throws CustomException {
        return transactionRepository.getTransactionsWithType(type);
    }

    @Override
    public Double getSumAmount(final long transactionId) throws CustomException {
        return transactionRepository.getSumAmount(transactionId);
    }

}
