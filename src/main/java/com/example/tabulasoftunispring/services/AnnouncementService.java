package com.example.tabulasoftunispring.services;

import com.example.tabulasoftunispring.models.dtos.AnnouncementDto;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDto> findAll();
    void cleanUpOldAnnouncement();
    void createOrUpdateAnnouncement(AnnouncementDto announcementDto);
    void delete(Long announcementId);
}
