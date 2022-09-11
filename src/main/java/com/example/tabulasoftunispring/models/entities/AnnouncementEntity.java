package com.example.tabulasoftunispring.models.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@Table(name = "announcements")
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "created_on")
    private Instant createdOn;

    @NotNull
    @Column(name = "updated_on")
    private Instant updatedOn;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "description")
    private String description;

    public AnnouncementEntity() {
    }
}
