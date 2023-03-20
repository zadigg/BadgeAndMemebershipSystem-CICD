package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Transaction;
import com.group2.badgeandmembershipsystem.dto.TransactionDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.TransactionRepository;
import com.group2.badgeandmembershipsystem.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = modelMapper.map(transactionDTO,Transaction.class);
        transaction.setDateTime(LocalDateTime.now());
        Transaction newTransaction = transactionRepository.save(transaction);
        return modelMapper.map(newTransaction, TransactionDTO.class);
    }

    @Override
    public TransactionDTO getTransaction(long id) {
        return transactionRepository.findById(id).map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).orElseThrow(() -> new ResourceException("Transaction Not found"));
    }

    @Override
    public void deleteTransaction(long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new ResourceException("Transaction Not found"));
        transactionRepository.delete(transaction);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TransactionDTO updateTransaction(long id, TransactionDTO transactionDTO) {
        Transaction oldTransaction = transactionRepository.findById(id).orElseThrow(()->new ResourceException("Transaction Not found"));
        Transaction transaction = modelMapper.map(transactionDTO,Transaction.class);
        transaction.setId(oldTransaction.getId());
        transaction.setDateTime(LocalDateTime.now());
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return modelMapper.map(updatedTransaction, TransactionDTO.class);
    }
}
