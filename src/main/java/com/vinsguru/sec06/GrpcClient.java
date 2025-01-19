package com.vinsguru.sec06;

import com.vinsguru.model.sec06.AccountBalance;
import com.vinsguru.model.sec06.BalanceCheckRequest;
import com.vinsguru.model.sec06.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class GrpcClient {
    private static final Logger logger = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext().build();

        //1. synchronous
        var stub = BankServiceGrpc.newBlockingStub(channel);
//        BankServiceGrpc.BankServiceBlockingStub stub = BankServiceGrpc.newBlockingStub(channel);

        var balance = stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build());

        logger.info("{}", balance);

        //2. asynchronous
        var stub2 = BankServiceGrpc.newStub(channel);

        stub2.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(3).build(), new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                logger.info("account bal {}", accountBalance);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                logger.info("completed");
            }
        });

        logger.info("done");
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}