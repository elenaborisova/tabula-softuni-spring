package com.example.tabulasoftunispring.web;

import com.example.tabulasoftunispring.models.dtos.AnnouncementDto;
import com.example.tabulasoftunispring.services.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    public String announcement(Model model) {
        model.addAttribute("announcements", announcementService.findAll());
        return "announcement/announcements";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String newAnnouncement(Model model) {
        model.addAttribute("formData", new AnnouncementDto());
        return "announcement/new";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("formData") AnnouncementDto announcementDto,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            //TODO: redirect
            return "announcement/new";
        }

        announcementService.createOrUpdateAnnouncement(announcementDto);

        return "redirect:/announcements";

    }


}
