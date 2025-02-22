package com.yusufsahin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoHome {

    private Integer id;

    private BigDecimal price;

    private List<DtoRoom> dtoRoom = new ArrayList<>();
}
