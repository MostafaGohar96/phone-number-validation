package com.jumia.task.validation.phonenumbers.models.common;

import com.jumia.task.validation.phonenumbers.contracts.models.common.IResult;
import lombok.Data;

@Data
public class Result<T> implements IResult<T> {
    private T result;
}
