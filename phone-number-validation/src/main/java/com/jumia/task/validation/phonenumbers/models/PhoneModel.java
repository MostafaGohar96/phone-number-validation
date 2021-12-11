package com.jumia.task.validation.phonenumbers.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jumia.task.validation.phonenumbers.entities.PhoneRegexEntity;
import com.jumia.task.validation.phonenumbers.types.NumberStatus;
import lombok.Data;

@Data
public class PhoneModel {

    private String name;
    private String countryName;
    private String number;
    private NumberStatus state;

}
