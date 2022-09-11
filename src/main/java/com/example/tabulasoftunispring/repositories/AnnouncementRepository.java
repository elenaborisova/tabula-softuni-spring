package com.example.tabulasoftunispring.repositories;

import com.example.tabulasoftunispring.models.entities.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Long> {
}
