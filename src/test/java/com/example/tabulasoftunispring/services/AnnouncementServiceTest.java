package com.example.tabulasoftunispring.services;

import com.example.tabulasoftunispring.models.dtos.AnnouncementDto;
import com.example.tabulasoftunispring.models.entities.AnnouncementEntity;
import com.example.tabulasoftunispring.repositories.AnnouncementRepository;
import com.example.tabulasoftunispring.services.impl.AnnouncementServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AnnouncementServiceTest {

    private AnnouncementService serviceToTest;
    @Mock
    AnnouncementRepository mockedAnnouncementRepository;

    @BeforeEach
    public void setUp() {
        serviceToTest = new AnnouncementServiceImpl(mockedAnnouncementRepository);
    }

    @Test
    public void testFindAll() {
        // Arrange
        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        announcementEntity.setTitle("Test title");
        announcementEntity.setDescription("Test description");
        announcementEntity.setUpdatedOn(Instant.now());
        announcementEntity.setCreatedOn(Instant.now());

        when(mockedAnnouncementRepository.findAll())
                .thenReturn(List.of(announcementEntity));

        // Act
        List<AnnouncementDto> announcementDtos = serviceToTest.findAll();

        // Assert
        Assertions.assertEquals(1, announcementDtos.size());

        AnnouncementDto actualDto = announcementDtos.get(0);
        Assertions.assertEquals(announcementEntity.getTitle(), actualDto.getTitle());
        Assertions.assertEquals(announcementEntity.getDescription(), actualDto.getDescription());
    }

}
