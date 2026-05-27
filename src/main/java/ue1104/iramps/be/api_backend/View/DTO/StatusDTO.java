package ue1104.iramps.be.api_backend.View.DTO;

public class StatusDTO {

    private String nom;

    public StatusDTO() {}

    public StatusDTO(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString() {
        return "StatusDTO{" +
                ", nom='" + nom + "'" +
                "}";
    }
}