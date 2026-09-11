package com.baraka.mic_banking.service;

import com.baraka.mic_banking.dto.*;

public interface UserService {

    BankResponse createAccount(UserRequest UserRequest);

    BankResponse balanceEnquiry(EnquiryRequest request);

    String nameEnquiry(EnquiryRequest request);

    BankResponse creditAccount(CreditDebitRequest request);

    BankResponse debitAccount(CreditDebitRequest request);
    BankResponse transfer(TransferRequest request);

    BankResponse login(LoginDto loginDto);


}
