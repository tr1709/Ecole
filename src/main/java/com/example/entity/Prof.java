/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author nhitr
 */
@Entity
@Table(name = "profs")
public class Prof implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom")
    @Pattern(regexp="^[A-Za-z]*$",message = "Nom invalide")
    private String nom;
    @Column(name = "prenom")
    @Pattern(regexp="^[A-Za-z]*$", message="Prenom invalide")
    private String prenom;
    @Column(name = "date_naissance")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past
    private LocalDate dateNaiss;
    @Column(name = "sexe")
    @Pattern(regexp="^[A-Za-z]*$", message="Uniquement des lettres")
    private String sexe;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "prof")   
    private List<SeanceCours> seancecours = new ArrayList<>();


    public Prof() {
        super();
    }

    public Prof(String nom, String prenom, LocalDate dateNaiss, String sexe) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public List<SeanceCours> getSeancecours() {
        return seancecours;
    }

    public void setSeancecours(List<SeanceCours> seancecours) {
        this.seancecours = seancecours;
    }
    
    
    
    
}