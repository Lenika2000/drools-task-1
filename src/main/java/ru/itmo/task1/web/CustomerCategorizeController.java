package ru.itmo.task1.web;

import ru.itmo.task1.model.CustomerRequest;
import ru.itmo.task1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/points")
public class CustomerCategorizeController {

    private final CustomerService customerService;

    public CustomerCategorizeController(
            CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> getPoints(@RequestBody CustomerRequest customerRequest) {
        Integer points = customerService.getPoints(customerRequest);
        return new ResponseEntity<>(String.format("plus %d points" , points), HttpStatus.OK);
    }

}
