package com.jumia.task.validation.phonenumbers.contracts.models.common;

public interface IResult<T> {
    T getResult();

    void setResult(T result);
}
