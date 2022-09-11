package com.example.tabulasoftunispring.web;

import com.example.tabulasoftunispring.services.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/")
    public String announcement(Model model) {
        return null;
    }


}
