package com.vinsguru.sec06;

import com.vinsguru.model.sec06.AccountBalance;
import com.vinsguru.model.sec06.BalanceCheckRequest;
import com.vinsguru.model.sec06.BankServiceGrpc;
import com.vinsguru.sec06.repository.AccountRepository;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
//        super.getAccountBalance(request, responseObserver);
        var accNum = request.getAccountNumber();
//        var bal = accNum * 10;
        var bal = AccountRepository.getBalance(accNum);
        var accBal = AccountBalance.newBuilder()
                .setAccountNumber(accNum)
                .setBalance(bal)
                .build();

        responseObserver.onNext(accBal);
        responseObserver.onCompleted();
    }
}