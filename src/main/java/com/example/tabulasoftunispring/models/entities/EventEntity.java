package com.example.tabulasoftunispring.models.entities;

import com.example.tabulasoftunispring.models.enums.EventType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "events")
@Entity
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "event_type")
    private EventType eventType;

    @NotNull
    @Column(name = "occurrence")
    private Instant occurrence;
}
