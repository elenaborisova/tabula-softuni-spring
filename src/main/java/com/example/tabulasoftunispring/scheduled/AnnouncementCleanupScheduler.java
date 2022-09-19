package com.example.tabulasoftunispring.scheduled;

import com.example.tabulasoftunispring.services.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AnnouncementCleanupScheduler {

    private final AnnouncementService announcementService;

    @Scheduled(cron = "0 0 2 ? * SUN")
    public void cleanUpAnnouncements() {
        announcementService.cleanUpOldAnnouncement();
    }

}
