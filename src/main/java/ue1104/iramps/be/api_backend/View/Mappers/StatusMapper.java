package ue1104.iramps.be.api_backend.View.Mappers;

import ue1104.iramps.be.api_backend.Model.BL.Status;
import ue1104.iramps.be.api_backend.View.DTO.StatusDTO;
// import ue1104.iramps.be.api_backend.View.DTO.StatusRequestDTO;

public class StatusMapper {

    public static StatusDTO toDTO(Status entity) {
        if (entity == null) return null;
        return new StatusDTO(entity.getNom());
    }

    public static Status toEntity(StatusDTO dto) {
        if (dto == null) return null;
        Status entity = new Status();
        entity.setNom(dto.getNom());
        return entity;
    }
}
