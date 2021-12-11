package com.jumia.task.validation.phonenumbers.repositories;


import com.jumia.task.validation.phonenumbers.entities.Customer;
import com.jumia.task.validation.phonenumbers.entities.PhoneRegexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

}