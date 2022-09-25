package com.example.tabulasoftunispring.services.impl;

import com.example.tabulasoftunispring.models.dtos.AnnouncementDto;
import com.example.tabulasoftunispring.models.entities.AnnouncementEntity;
import com.example.tabulasoftunispring.models.mappers.AnnouncementMapper;
import com.example.tabulasoftunispring.repositories.AnnouncementRepository;
import com.example.tabulasoftunispring.services.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Override
    public List<AnnouncementDto> findAll() {
        return announcementRepository
                .findAll()
                .stream()
                .map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void cleanUpOldAnnouncement() {
        Instant endTime = Instant.now().minus(7, ChronoUnit.DAYS);
        announcementRepository.deleteByUpdatedOnBefore(endTime);
    }

    @Override
    public void createOrUpdateAnnouncement(AnnouncementDto announcementDto) {
        AnnouncementEntity announcementEntity = AnnouncementMapper.INSTANCE
                .mapAnnouncementDtoToEntity(announcementDto);

        if (announcementEntity.getCreatedOn() == null) {
            announcementEntity.setCreatedOn(Instant.now());
        }
        announcementEntity.setUpdatedOn(Instant.now());

        announcementRepository.save(announcementEntity);
    }

    @Override
    public void delete(Long announcementId) {
        announcementRepository.deleteById(announcementId);
    }

}
