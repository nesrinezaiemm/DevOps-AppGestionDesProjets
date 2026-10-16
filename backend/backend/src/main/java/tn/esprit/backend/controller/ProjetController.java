package tn.esprit.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.dto.ProjetDTO;
import tn.esprit.backend.entity.Projet;
import tn.esprit.backend.service.IProjetService;

import java.util.List;

@RestController
@RequestMapping("/projet")
@AllArgsConstructor
@CrossOrigin("*")
public class ProjetController {

    IProjetService projetService;

    @PostMapping("/add")
    public Projet addProjet(@RequestBody ProjetDTO dto) {
        Projet projet = new Projet();
        projet.setSujet(dto.getSujet());
        return projetService.addProjet(projet);
    }

    @PutMapping("/update")
    public Projet updateProjet(@RequestBody ProjetDTO dto) {
        Projet projet = projetService.getProjetById(dto.getId());
        if (projet == null) {
            projet = new Projet();
        }
        projet.setSujet(dto.getSujet());
        return projetService.updateProjet(projet);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
    }

    @GetMapping("/get/{id}")
    public Projet getProjetById(@PathVariable Long id) {
        return projetService.getProjetById(id);
    }

    @GetMapping("/all")
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }
}
