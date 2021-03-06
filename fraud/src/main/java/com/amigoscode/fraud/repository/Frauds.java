package com.amigoscode.fraud.repository;

import com.amigoscode.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Frauds extends JpaRepository<FraudCheckHistory, Integer> {
}
