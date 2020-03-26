package org.pocketaces.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.pocketaces.dto.Response;
import org.pocketaces.dto.TransactionDTO;
import org.pocketaces.exception.CustomException;
import org.pocketaces.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author swatish.s
 */

@RestController("transactionController")
@RequestMapping("/transactionservice")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionController {

    private final TransactionService transactionService;

    @PutMapping(value = "/transaction/{transactionId}")
    public Response addTransaction(@PathVariable("transactionId") @NonNull final Long transactionId,
            @RequestBody @Valid final TransactionDTO request) {
        try {
            transactionService.addTransaction(transactionId, request);
            return new Response(HttpStatus.OK);
        } catch (CustomException ex) {
            return new Response(ex);
        }
    }

    @GetMapping(value = "/transaction/{transactionId}")
    public Response getTransactionById(@PathVariable("transactionId") @NonNull final Long transactionId) {
        try {
            return new Response(transactionService.getTransactionById(transactionId));
        } catch (CustomException ex) {
            return new Response(ex);
        }
    }

    @GetMapping(value = "/types/{type}")
    public Response getTransactionByType(@PathVariable("type") @NotBlank final String type) {
        try {
            return new Response(transactionService.getTransactionByType(type));
        } catch (CustomException ex) {
            return new Response(ex);
        }
    }

    @GetMapping(value = "/sum/{transactionId}")
    public Response getSumAmount(@PathVariable("transactionId") @NotNull final Long transactionId) {
        try {
            return new Response(transactionService.getSumAmount(transactionId));
        } catch (CustomException ex) {
            return new Response(ex);
        }
    }
}
