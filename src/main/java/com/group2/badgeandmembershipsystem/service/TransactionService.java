package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    TransactionDTO getTransaction(long id);
    void deleteTransaction(long id);
    List<TransactionDTO> getAllTransactions();
    TransactionDTO updateTransaction(long id, TransactionDTO transactionDTO);
}
