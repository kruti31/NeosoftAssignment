package com.neosoft.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.ms.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
