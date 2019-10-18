package com.mpayment.web.controller;

import com.mpayment.repositories.PaymentRepository;
import com.mpayment.model.Payment;
import com.mpayment.web.exceptions.PaymentAlreadyExistsException;
import com.mpayment.web.exceptions.ImpossibleToAddPaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public ResponseEntity<Payment> payCommand(@RequestBody Payment payment) {
        Optional<Payment> paymentOptional = this.paymentRepository.findByCommandId(payment.getCommandId());

        if (paymentOptional.isPresent())
            throw new PaymentAlreadyExistsException("This command is already payed !");

        Payment addedPayment = this.paymentRepository.save(payment);

        if (addedPayment == null)
            throw new ImpossibleToAddPaymentException("Error... unable to add the payment, please try later.");

        // call the other microservice in order to notify that the payment has been done !

        return new ResponseEntity<>(addedPayment, HttpStatus.CREATED);
    }
}
