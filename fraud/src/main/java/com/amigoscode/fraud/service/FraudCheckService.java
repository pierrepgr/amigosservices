package com.amigoscode.fraud.service;

import com.amigoscode.fraud.model.FraudCheckHistory;
import com.amigoscode.fraud.repository.Frauds;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FraudCheckService {

    private final Frauds frauds;

    public boolean isFraudulentCustomer(Integer customerId) {
        this.frauds.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }
}
