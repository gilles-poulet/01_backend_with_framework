package ue1104.iramps.be.api_backend.View.Services;

import ue1104.iramps.be.api_backend.Model.BL.Status;
import ue1104.iramps.be.api_backend.View.DTO.StatusDTO;
import ue1104.iramps.be.api_backend.View.Mappers.StatusMapper;
import ue1104.iramps.be.api_backend.Model.Repositories.StatusRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<StatusDTO> getAllStatuses() {
        List<StatusDTO> dtos = new ArrayList<>();
        statusRepository.findAll().forEach(status -> {
            dtos.add(StatusMapper.toDTO(status));
        });
        System.out.println(dtos);
        return dtos;
    }

    public StatusDTO getStatusByNom(String nom) {
        Status status = statusRepository.findByNom(nom);
        if (status != null){
            StatusDTO dto = StatusMapper.toDTO(status);
            return dto;
        }
        return null;
    }

    @Transactional
    public List<StatusDTO> createStatus(StatusDTO[] request) {
        ArrayList<StatusDTO> list = new ArrayList<StatusDTO>();
        for (StatusDTO statusRequestDTO : request) {
            Status entity = StatusMapper.toEntity(statusRequestDTO);
            Status saved = statusRepository.save(entity);
            list.add(StatusMapper.toDTO(saved));
        }
        
        return list;
        
    }

    @Transactional
    public StatusDTO updateStatus(String ancienNom, StatusDTO request) {
        Status existing = statusRepository.findByNom(ancienNom);
        if (existing == null) return null;

        existing.setNom(request.getNom());
        Status saved = statusRepository.save(existing);
        return StatusMapper.toDTO(saved);
    }

    @Transactional
    public boolean deleteStatus(String name) {
        statusRepository.deleteStatus(name);
        return true;
    }
}

