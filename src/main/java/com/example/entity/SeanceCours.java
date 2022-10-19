/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author nhitr
 */

@Entity
@Table(name = "seancescours")
public class SeanceCours implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom_cours")
    @Pattern(regexp="^[A-Za-z]*$",message = "Nom du cours invalide")
    private String nomCours;
    @Column(name = "jour")
    @Pattern(regexp="^[A-Za-z]*$",message = "Jour invalide")
    @NotNull
    private String jour;
    @Column(name = "heure_debut")
    @NotNull(message="Ne doit pas être vide")
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime heureDeb;
    @Column(name = "heure_fin")
    @NotNull(message="Ne doit pas être vide")
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime heureFin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prof_id", nullable=false)
    private Prof prof;


    public SeanceCours() {
        super();
    }

    public SeanceCours(String nomCours, String jour, LocalTime heureDeb, LocalTime heureFin) {
        super();
        this.nomCours = nomCours;
        this.jour = jour;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public LocalTime getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(LocalTime heureDeb) {
        this.heureDeb = heureDeb;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }
    
    
    
    
    }