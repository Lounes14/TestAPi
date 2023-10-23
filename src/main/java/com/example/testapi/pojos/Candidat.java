package com.example.testapi.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    @NotNull(message="Le champ nom ne peut pas étre null")
    @NotBlank(message="Le champ nom ne peut pas étre vide")
    private String nom;


    @Column(name="prenom")
    @NotNull(message="Le champ prénom ne peut pas étre null")
    @NotBlank(message="Le champ prénom ne peut pas étre vide")
    private String prenom;

    @Column(name="dateNaissance")
    @NotNull(message="Le champ date ne peut pas étre null")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateNaissance;



    @Column(name="adresse")
    @NotNull(message="Le champ adresse ne peut pas étre null")
    @NotBlank(message="Le champ adresse ne peut pas étre vide")
    private String adresse;


    @Column(name="ville")
    @NotNull(message="Le champ ville ne peut pas étre null")
    @NotBlank(message="Le champ ville ne peut pas étre vide")
    private String ville;


    @Column(name="codePostal")
    @NotNull(message="Le champ codePostal ne peut pas étre null")
    @NotBlank(message="Le champ codePostal ne peut pas étre vide")
    private String codePostal;

    public Candidat() {
    }

    public Candidat(String nom, String prenom, Date dateNaissance, String adresse, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
