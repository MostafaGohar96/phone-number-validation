package com.jumia.task.validation.phonenumbers.contracts.models.common;


import com.jumia.task.validation.phonenumbers.utilities.response.Pagination;

public interface IPaginatedResult<T> extends IResult<T> {

    Pagination getPaginationInfo();

    void setPaginationInfo(Pagination paginationInfo);
}
