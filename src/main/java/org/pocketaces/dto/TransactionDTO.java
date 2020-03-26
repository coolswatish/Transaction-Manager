package org.pocketaces.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author swatish.s
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

    @NotBlank
    private String type;

    @NotNull
    private Double amount;

    private Long parentId;
}