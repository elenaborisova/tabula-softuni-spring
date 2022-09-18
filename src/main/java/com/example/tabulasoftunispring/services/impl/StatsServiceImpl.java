package com.example.tabulasoftunispring.services.impl;

import com.example.tabulasoftunispring.services.StatsService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StatsServiceImpl implements StatsService {

    private AtomicInteger requestCount = new AtomicInteger(0);
    private Instant startedOn = Instant.now();

    public void incRequestCount() {
        requestCount.incrementAndGet();
    }

    public int getRequestCount() {
        return requestCount.get();
    }

    public Instant getStartedOn() {
        return startedOn;
    }
}
