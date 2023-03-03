package ru.itmo.task1.service;

import ru.itmo.task1.model.CustomerRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CustomerService {

    private final KieContainer kieContainer;

    public CustomerService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Integer getPoints(CustomerRequest customerRequest) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("customerRequest", customerRequest);
        kieSession.insert(customerRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return customerRequest.getPoints();
    }
}
