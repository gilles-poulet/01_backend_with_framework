package ue1104.iramps.be.api_backend.Controller;

import ue1104.iramps.be.api_backend.View.DTO.SectionDTO;
// import ue1104.iramps.be.api_backend.View.DTO.SectionRequestDTO;
import ue1104.iramps.be.api_backend.View.Services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8085")
@RequestMapping("/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    // GET /api/section
    @GetMapping
    public ResponseEntity<List<SectionDTO>> getAllSections() {
        List<SectionDTO> sections = sectionService.getAllSections();
        return ResponseEntity.ok(sections);
    }

    // GET /api/section/{id}
    @GetMapping("/{id}")
    public ResponseEntity<SectionDTO> getSectionById(@PathVariable int id) {
        SectionDTO section = sectionService.getSectionById(id);
        return section != null ?
                ResponseEntity.ok(section) :
                ResponseEntity.notFound().build();
    }

    // POST /api/section (commented out for now)
    // @PostMapping
    // public ResponseEntity<SectionDTO> createSection(@RequestBody SectionRequestDTO request) {
    //     SectionDTO created = sectionService.createSection(request);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(created);
    // }

    // PUT /api/section/{id} (commented out for now)
    // @PutMapping("/{id}")
    // public ResponseEntity<SectionDTO> updateSection(
    //         @PathVariable int id,
    //         @RequestBody SectionRequestDTO request) {
    //     SectionDTO updated = sectionService.updateSection(id, request);
    //     return updated != null ?
    //             ResponseEntity.ok(updated) :
    //             ResponseEntity.notFound().build();
    // }

    // DELETE /api/section/{id} (commented out for now)
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteSection(@PathVariable int id) {
    //     sectionService.deleteSection(id);
    //     return ResponseEntity.noContent().build();
    // }
}