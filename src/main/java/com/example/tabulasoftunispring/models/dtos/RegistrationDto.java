package com.example.tabulasoftunispring.models.dtos;

import com.example.tabulasoftunispring.models.annotations.FieldMatch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords do not match.")
public class RegistrationDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;

    public RegistrationDto() {
    }
}
