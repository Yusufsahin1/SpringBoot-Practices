package com.yusufsahin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {

    private Integer Id;

    private String name;

    private DtoAddress dtoAddress;
}
