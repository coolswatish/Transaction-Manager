package org.pocketaces.entity;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author swatish.s
 */

@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionDetail {

    private final long   id;
    private final String type;
    private final double amount;
    private final Long   parentId;
}
