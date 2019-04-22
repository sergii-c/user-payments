package com.wc1.poc.userpayments.controller;

import com.wc1.poc.userdata.UserDataClient;
import com.wc1.poc.userpayments.domain.UserPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserPaymentsController {

    @Autowired
    UserDataClient userDataClient;

    private Map<Integer, UserPayment> payments = new HashMap<Integer, UserPayment>() {{
        put(1, new UserPayment(1, 1, new BigDecimal(100)));
        put(2, new UserPayment(2, 2, new BigDecimal(200)));
        put(3, new UserPayment(3, 2, new BigDecimal(10)));
        put(4, new UserPayment(4, 1, new BigDecimal(1000)));
    }};

    @GetMapping("/user-payment/{id}")
    @ResponseBody
    public ResponseEntity<String> getPayment(@PathVariable(name="id") int id) {
        return Optional.ofNullable(payments.get(id)).flatMap(userPayment -> Optional.ofNullable(userDataClient.getUser(userPayment.getUserId()))
                .map(user -> {
                    String output = String.format("%s %s %s %s", userPayment.getPaymentId(), user.getName(), user.getLastName(), userPayment.getAmount());
                    return new ResponseEntity<>(output, HttpStatus.OK);
                })).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}