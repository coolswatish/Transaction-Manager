package org.pocketaces.service;

import java.util.Set;

import org.pocketaces.dto.TransactionDTO;
import org.pocketaces.exception.CustomException;

/**
 * @author swatish.s
 */

public interface TransactionService {

    /**
     * This method adds transaction to the data store.
     * 
     * @param transactionId
     * @param transactionDTO
     * @throws CustomException
     */
    void addTransaction(final long transactionId, final TransactionDTO transactionDTO) throws CustomException;

    /**
     * This method returns a transaction by its id.
     * 
     * @param transactionId
     * @return TransactionDTO
     * @throws CustomException
     */
    TransactionDTO getTransactionById(final long transactionId) throws CustomException;

    /**
     * This method fetches all transaction Ids with specified type.
     * 
     * @param type
     * @return Set<Long>
     * @throws CustomException
     */
    Set<Long> getTransactionByType(final String type) throws CustomException;

    /**
     * This method returns the aggregate sum of that transaction along with its children.
     * 
     * @param transactionId
     * @return Double
     * @throws CustomException
     */
    Double getSumAmount(final long transactionId) throws CustomException;

}
