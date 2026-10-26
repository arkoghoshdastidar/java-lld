package com.parkinglot.payment;

import com.parkinglot.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {
    Double amount;
    PaymentStatus status;
    LocalDateTime paymentDate;

    boolean initiateTransaction() {
        //business logic
        return true;
    }

    void updatePaymentStatus(PaymentStatus status) {
        this.status = status;
    }

    void setAmount(Double amount) {
        this.amount = amount;
    }
}