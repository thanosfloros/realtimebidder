package com.thanosfloros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid country")
public class InvalidCountryException extends Exception {
    public InvalidCountryException() {
        super("Invalid country");
    }
}
