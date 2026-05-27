package ue1104.iramps.be.api_backend.View.DTO;

public class SectionDTO {
    private String nom;

    public SectionDTO() {}

    public SectionDTO(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
