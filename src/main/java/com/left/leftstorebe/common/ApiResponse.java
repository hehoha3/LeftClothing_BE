package com.left.leftstorebe.common;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ApiResponse {
    private final boolean success;
    private final String message;

    public String getTimestamp() {
        return LocalDate.now().toString();
    }
}
