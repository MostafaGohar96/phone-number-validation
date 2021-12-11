package com.jumia.task.validation.phonenumbers.utilities.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<TData> {
    private Status status;
    private TData result;
    private Pagination paginationInfo;
}
