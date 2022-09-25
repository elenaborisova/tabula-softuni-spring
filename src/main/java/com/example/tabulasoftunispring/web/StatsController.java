package com.example.tabulasoftunispring.web;

import com.example.tabulasoftunispring.services.StatsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
@PreAuthorize("hasRole('ADMIN')")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("requestCount", statsService.getRequestCount());
        model.addAttribute("startedOn", statsService.getStartedOn());

        return "stats/stats";
    }
}
