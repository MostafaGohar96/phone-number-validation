package com.jumia.task.validation.phonenumbers.utilities.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Builder.Default
    private int code = 200;
    private String errorMsg;
}
