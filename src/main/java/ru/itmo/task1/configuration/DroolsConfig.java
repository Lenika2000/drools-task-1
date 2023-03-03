package ru.itmo.task1.configuration;

import ru.itmo.task1.service.CustomerService;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    private static final String RULES_CUSTOMER_RULES_DRL = "rules/customer-points.drl";

    @Bean
    public KieContainer kieContainer() {
        // Основной интерфейс, который приложения используют для взаимодействия с механизмом Drools.
        final KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        // запускаем проверку всех правил
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    @Bean
    public CustomerService customerCategorizeService(KieContainer kieContainer) {
        return new CustomerService(kieContainer);
    }
}
