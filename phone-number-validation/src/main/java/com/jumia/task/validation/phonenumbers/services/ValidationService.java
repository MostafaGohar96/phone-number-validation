package com.jumia.task.validation.phonenumbers.services;

import com.jumia.task.validation.phonenumbers.contracts.services.IValidationService;
import com.jumia.task.validation.phonenumbers.entities.Customer;
import com.jumia.task.validation.phonenumbers.entities.PhoneRegexEntity;
import com.jumia.task.validation.phonenumbers.models.PhoneModel;
import com.jumia.task.validation.phonenumbers.repositories.CustomerRepo;
import com.jumia.task.validation.phonenumbers.repositories.PhoneRegexRepo;
import com.jumia.task.validation.phonenumbers.types.NumberStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
@Qualifier("ValidationService")
@Log4j2
public class ValidationService implements IValidationService {

    private PhoneRegexRepo phoneRegexRepo;

    private CustomerRepo customerRepo;

    private static Pattern phonePattern = null;

    private Map<String, String> codeCountryNameMap;

    private Map<String, String> codeRegexMap;

    @Autowired
    public ValidationService(PhoneRegexRepo phoneRegexRepo,
                             CustomerRepo customerRepo){
        this.phoneRegexRepo = phoneRegexRepo;
        this.customerRepo = customerRepo;
        init();
    }

    private void init() {
        List<PhoneRegexEntity> phoneRegexEntities = phoneRegexRepo.findAll();

        Map<String, String> countryNameMap = new HashMap<String, String>();

        for(PhoneRegexEntity phoneRegex : phoneRegexEntities)
            countryNameMap.put(phoneRegex.getCountryCode(), phoneRegex.getCountryName());

        this.codeCountryNameMap = countryNameMap;

        Map<String, String> countryRegexmap = new HashMap<String, String>();

        for(PhoneRegexEntity phoneRegex : phoneRegexEntities)
            countryRegexmap.put(phoneRegex.getCountryCode(), phoneRegex.getRegex());

        this.codeRegexMap = countryRegexmap;
    }


    @Override
    public List<PhoneModel> getNumbers(){

        List<Customer> customers = customerRepo.findAll();

        List<PhoneModel> phoneModels = new ArrayList<PhoneModel>();

        for(Customer customer: customers){

            String code = getCountryCode(customer.getNumber());
            String countryName = codeCountryNameMap.get(code);
            String regex = codeRegexMap.get(code);
            phonePattern = Pattern.compile(regex);
            NumberStatus status = NumberStatus.VALID;
            if(!phonePattern.matcher(customer.getNumber()).matches())
                status = NumberStatus.NON_VALID;

            PhoneModel phoneModel = new PhoneModel();
            phoneModel.setName(customer.getName());
            phoneModel.setNumber(customer.getNumber());
            phoneModel.setCountryName(countryName);
            phoneModel.setState(status);

            phoneModels.add(phoneModel);
        }

        return phoneModels;
    }

    private String getCountryCode(String number){
        String code = number.substring(number.indexOf("(")+1, number.indexOf(")"));
        return code;
    }
}
