package com.jumia.task.validation.phonenumbers.models.common;

import com.jumia.task.validation.phonenumbers.contracts.models.common.IPaginatedResult;
import com.jumia.task.validation.phonenumbers.utilities.response.Pagination;
import lombok.Data;

@Data
public class PaginatedResult extends Result implements IPaginatedResult {
    private Pagination paginationInfo;
}
