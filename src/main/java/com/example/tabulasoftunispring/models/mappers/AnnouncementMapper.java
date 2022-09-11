package com.example.tabulasoftunispring.models.mappers;

import com.example.tabulasoftunispring.models.dtos.AnnouncementDto;
import com.example.tabulasoftunispring.models.entities.AnnouncementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnnouncementMapper {

    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    AnnouncementEntity mapAnnouncementDtoToEntity(AnnouncementDto announcementDto);

    AnnouncementDto mapAnnouncementEntityToDto(AnnouncementEntity announcementEntity);

}
