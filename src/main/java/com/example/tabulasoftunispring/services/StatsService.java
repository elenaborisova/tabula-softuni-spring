package com.example.tabulasoftunispring.services;

import java.time.Instant;

public interface StatsService {

    void incRequestCount();

    int getRequestCount();

    Instant getStartedOn();
}
