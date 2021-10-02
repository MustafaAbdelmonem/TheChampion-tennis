package com.digital.factory.controllers.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private Integer statusCode;
    private String statusMessage;
    private Object data;
    @JsonFormat
    private Date timeStamp = new Date();

}
