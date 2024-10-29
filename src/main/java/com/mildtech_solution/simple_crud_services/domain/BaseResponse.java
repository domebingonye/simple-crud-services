package com.mildtech_solution.simple_crud_services.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse {
    private String status;
    private String message;

    public BaseResponse(String status, String message){
        this.status = status;
        this.message = message;
    }
}
