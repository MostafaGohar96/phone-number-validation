package com.jumia.task.validation.services;

import com.jumia.task.validation.phonenumbers.entities.Customer;
import com.jumia.task.validation.phonenumbers.entities.PhoneRegexEntity;
import com.jumia.task.validation.phonenumbers.models.PhoneModel;
import com.jumia.task.validation.phonenumbers.repositories.CustomerRepo;
import com.jumia.task.validation.phonenumbers.repositories.PhoneRegexRepo;
import com.jumia.task.validation.phonenumbers.services.ValidationService;
import com.jumia.task.validation.phonenumbers.types.NumberStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.util.ReflectionTestUtils;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ValidationServiceTest {

    private ValidationService service;

    @Mock
    private CustomerRepo customerRepo;
    @Mock
    private PhoneRegexRepo phoneRegexRepo;

    @BeforeEach
    public void setup() {
        initMocks(this);

        PhoneRegexEntity phoneRegex1 =
                new PhoneRegexEntity(1,"Cameroon", "237", "\\(237\\)\\ ?[2368]\\d{7,8}$", Instant.now());
        PhoneRegexEntity phoneRegex2 =
                new PhoneRegexEntity(1,"Ethiopia", "251", "\\(251\\)\\ ?[1-59]\\d{8}$", Instant.now());

        List<PhoneRegexEntity> phoneRegexEntityList = new ArrayList<>(Arrays.asList(phoneRegex1, phoneRegex2));
        when(phoneRegexRepo.findAll()).thenReturn(phoneRegexEntityList);

        service = new ValidationService(phoneRegexRepo, customerRepo);
    }


    @Test
    @DisplayName("Validate Two Valid Customer Numbers")
    public void validateValidNumbers() {

        Customer customer1 = new Customer(1, "EMILE CHRISTIAN", "(237) 697151594");
        Customer customer2 = new Customer(2, "ABRAHAM NEGASH","(251) 911203317");

        List<Customer> customers = new ArrayList<>(Arrays.asList(customer1, customer2));
        when(customerRepo.findAll()).thenReturn(customers);

        List<PhoneModel> phoneModels = service.getNumbers();

        assertEquals(phoneModels.get(0).getState(), NumberStatus.VALID);
        assertEquals(phoneModels.get(1).getState(), NumberStatus.VALID);
    }

    @Test
    @DisplayName("Validate Two non Valid Customer Numbers")
    public void validateNonValidNumbers() {

        Customer customer1 = new Customer(1, "SUGAR STARRK BARRAGAN", "(237) 6780009592");
        Customer customer2 = new Customer(2, "ZEKARIAS KEBEDE","(251) 9119454961");

        List<Customer> customers = new ArrayList<>(Arrays.asList(customer1, customer2));
        when(customerRepo.findAll()).thenReturn(customers);

        List<PhoneModel> phoneModels = service.getNumbers();

        assertEquals(phoneModels.get(0).getState(), NumberStatus.NON_VALID);
        assertEquals(phoneModels.get(1).getState(), NumberStatus.NON_VALID);
    }



}
