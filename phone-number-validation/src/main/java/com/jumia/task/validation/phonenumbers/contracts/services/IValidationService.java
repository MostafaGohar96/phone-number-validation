package com.jumia.task.validation.phonenumbers.contracts.services;

import com.jumia.task.validation.phonenumbers.models.PhoneModel;

import java.util.List;

public interface IValidationService {

    List<PhoneModel> getNumbers();


}
