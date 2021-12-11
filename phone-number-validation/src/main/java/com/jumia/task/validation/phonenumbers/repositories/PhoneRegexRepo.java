package com.jumia.task.validation.phonenumbers.repositories;


import com.jumia.task.validation.phonenumbers.entities.PhoneRegexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRegexRepo extends JpaRepository<PhoneRegexEntity, Long>, JpaSpecificationExecutor<PhoneRegexEntity> {
    PhoneRegexEntity findByCountryName(@Param("countryName") String countryName);
}