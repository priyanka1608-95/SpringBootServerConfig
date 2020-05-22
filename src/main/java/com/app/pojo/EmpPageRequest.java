package com.app.pojo;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class EmpPageRequest
{
    @PositiveOrZero(message = "Please enter positive page number")
    int pageNo;

    @PositiveOrZero(message = "Please enter positive page size")
    int pageSize;

    String name;
}
