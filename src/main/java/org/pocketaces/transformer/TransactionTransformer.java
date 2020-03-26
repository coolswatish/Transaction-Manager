package org.pocketaces.transformer;

import org.pocketaces.dto.TransactionDTO;
import org.pocketaces.entity.TransactionDetail;
import org.springframework.stereotype.Component;

/**
 * @author swatish.s
 */

@Component
public class TransactionTransformer {

    public TransactionDetail getTransactionDetail(final long transactionId, final TransactionDTO request) {
        final TransactionDetail transactionDetail =
                new TransactionDetail(transactionId, request.getType(), request.getAmount(), request.getParentId());
        return transactionDetail;
    }

    public TransactionDTO getTransactionDTO(final TransactionDetail transactionDetail) {
        final TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setType(transactionDetail.getType());
        transactionDTO.setAmount(transactionDetail.getAmount());
        transactionDTO.setParentId(transactionDetail.getParentId());
        return transactionDTO;
    }


}
