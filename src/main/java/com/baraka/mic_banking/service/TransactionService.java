package com.baraka.mic_banking.service;

import com.baraka.mic_banking.dto.TransactionDto;
import com.baraka.mic_banking.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
