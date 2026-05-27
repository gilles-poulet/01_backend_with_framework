package ue1104.iramps.be.api_backend.Controller;

import ue1104.iramps.be.api_backend.View.DTO.StatusDTO;
import ue1104.iramps.be.api_backend.View.Services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
    origins = "http://localhost:8085",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
)
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;


    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAllStatuses() {
        List<StatusDTO> statuses = statusService.getAllStatuses();
        return ResponseEntity.ok(statuses);
    }


    @GetMapping("/{nom}")
    public ResponseEntity<StatusDTO> getStatusById(@PathVariable String nom) {
        StatusDTO status = statusService.getStatusByNom(nom);
        return status != null ?
                ResponseEntity.ok(status) :
                ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<List<StatusDTO>> createStatus(@RequestBody StatusDTO[] request) {
        List<StatusDTO> created = statusService.createStatus(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{nom}")
    public ResponseEntity<StatusDTO> updateStatus(@PathVariable String nom, @RequestBody StatusDTO request) {
        StatusDTO updated = statusService.updateStatus(nom, request);
        return updated != null ?
                ResponseEntity.ok(updated) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String name) {
        statusService.deleteStatus(name);
        return ResponseEntity.noContent().build();
    }
}