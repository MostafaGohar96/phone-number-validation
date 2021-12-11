package com.jumia.task.validation.phonenumbers.utilities.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
    @Builder.Default
    private long total = 0;
    @Builder.Default
    private int pageSize = 5;
    @Builder.Default
    private int pageNum = 0;
}
