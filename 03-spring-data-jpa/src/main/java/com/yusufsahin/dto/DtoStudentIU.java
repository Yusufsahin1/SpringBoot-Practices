package com.yusufsahin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @Size(min = 2)
    @NotEmpty(message = "Firstname field cannot be empty!") // Null OR Empty
    private String firstName;

    @Size(min = 2, max = 35)
    @NotEmpty(message = "Lastname field cannot be empty!")
    private String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthOfDate;
}
