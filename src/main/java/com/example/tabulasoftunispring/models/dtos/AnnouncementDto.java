package com.example.tabulasoftunispring.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnouncementDto {

    private Long id;

    private Instant createdOn;

    private Instant updatedOn;

    @NotBlank
    private String title;

    @NotBlank
    @Size(min = 10, message = "The description should be more than 10 characters.")
    private String description;

    public AnnouncementDto() {
    }
}
