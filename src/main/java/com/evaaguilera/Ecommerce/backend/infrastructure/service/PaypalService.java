package com.evaaguilera.Ecommerce.backend.infrastructure.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Service
public class PaypalService {
    private final APIContext apiContext;

    public PaypalService(APIContext apiContext) {
        this.apiContext = apiContext;
    }
public Payment createPayment(
        Double total,
        String currency,
        String method,
        String intent,
        String description,
        String cancelUrl,
        String successUrl
) throws PayPalRESTException {
    Amount amount=new Amount();
    amount.setCurrency(currency);
    amount.setTotal(String.format(Locale.forLanguageTag(currency), "%.2f", total));

    Transaction transaction=new Transaction();
    transaction.setDescription(description);
    transaction.setAmount(amount);

    List<Transaction> transactions =new ArrayList<>();
    transactions.add(transaction);

    Payer payer=new Payer();
    payer.setPaymentMethod(method);

    Payment payment = new Payment();
    payment.setIntent(intent); // Assuming intent is a String ("sale" or "capture")
    payment.setPayer(payer); // Assuming method is a String ("paypal" or "credit_card")
    payment.setTransactions(transactions);

    RedirectUrls redirectUrls = new RedirectUrls();
    redirectUrls.setReturnUrl(successUrl);
    redirectUrls.setCancelUrl(cancelUrl);
    payment.setRedirectUrls(redirectUrls);

    return payment.create  (apiContext);
}
    public  Payment executePayment(
            String paymentId,
            String payerId
    ) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        return  payment.execute(apiContext,paymentExecution);

    }
}
