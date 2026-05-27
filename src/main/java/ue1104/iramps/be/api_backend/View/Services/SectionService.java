package ue1104.iramps.be.api_backend.View.Services;

import ue1104.iramps.be.api_backend.Model.BL.Section;
import ue1104.iramps.be.api_backend.View.DTO.SectionDTO;
import ue1104.iramps.be.api_backend.View.Mappers.SectionMapper;
import ue1104.iramps.be.api_backend.Model.Repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    // Get all
    public List<SectionDTO> getAllSections() {
        List<SectionDTO> dtos = new ArrayList<>();
        sectionRepository.findAll().forEach(section -> {
            dtos.add(SectionMapper.toDTO(section));
        });
        System.out.println(dtos);
        return dtos;
    }

    // Get by ID
    public SectionDTO getSectionById(int id) {
        SectionDTO dto = new SectionDTO(sectionRepository.findById(id).getNom());
        return dto;
    }

    // Create (commented out for now)
    // public SectionDTO createSection(SectionRequestDTO request) {
    //     Section entity = SectionMapper.toEntityFromRequest(request);
    //     Section saved = sectionRepository.save(entity);
    //     return SectionMapper.toDTO(saved);
    // }

    // Update (commented out for now)
    // public SectionDTO updateSection(int id, SectionRequestDTO request) {
    //     Section existing = sectionRepository.findById(id)
    //             .orElse(null);
    //     if (existing == null) return null;
    //     existing.setNom(request.getNom());
    //     Section saved = sectionRepository.save(existing);
    //     return SectionMapper.toDTO(saved);
    // }

    // Delete (commented out for now)
    // public boolean deleteSection(int id) {
    //     sectionRepository.deleteById(id);
    //     return true;
    // }
}
