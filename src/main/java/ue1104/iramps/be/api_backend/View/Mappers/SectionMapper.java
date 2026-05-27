package ue1104.iramps.be.api_backend.View.Mappers;

import ue1104.iramps.be.api_backend.Model.BL.Section;
import ue1104.iramps.be.api_backend.View.DTO.SectionDTO;

public class SectionMapper {
    public static SectionDTO toDTO(Section entity) {
        if (entity == null) return null;
        return new SectionDTO(entity.getNom());
    }

    public static Section toEntity(SectionDTO dto) {
        if (dto == null) return null;
        Section entity = new Section();
        entity.setNom(dto.getNom());
        return entity;
    }
}