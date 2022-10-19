/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.entity.Prof;
import com.example.entity.SeanceCours;
import com.example.repository.ProfRepository;
import com.example.repository.SeanceCoursRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfController {
    @Autowired
    private ProfRepository profRepository;
    @Autowired
    private SeanceCoursRepository seancecoursRepository;
    
    @GetMapping("/profs")
    public String listProfs(Model model)
    {
        model.addAttribute("listProfs", profRepository.findAll());
        return "profs";
    }
    
    @GetMapping("/profs/new")
    public String showNewProfForm(Model model)
    {
        //Créer un attribut de modèle pour lier les données du formulaire
        Prof prof = new Prof();
        model.addAttribute("prof", prof);
        return "nouveau_prof";
    }
    
    @PostMapping("/profs/saveNew")
    public String saveNewProf(@ModelAttribute("prof") @Valid Prof prof, Errors errors, Model model)
    {
        if (errors.hasErrors())
        {         
            return "nouveau_prof";
        }
        
         //Enregister prof dans la BD
        profRepository.save(prof);
          return "redirect:/profs";
    }
            
    @GetMapping("/profs/update")
    public String showUpdateProfForm(@RequestParam(name="id") int id, Model model)
    {
        Optional<Prof> optional = profRepository.findById(id);
        Prof prof = null;
        if (optional.isPresent())
            prof = optional.get();
        else
            throw new RuntimeException ("Prof not found for id:: " + id);
        
        //Définir prof comme attribut de modèle pour pré-remplir le formulaire
        model.addAttribute("prof", prof);
        model.addAttribute("listProfs", profRepository.findAll());
        return "modifier_prof";
    }
    
    @PostMapping("/profs/saveUpdate")
    public String saveUpdateProf(@ModelAttribute("prof") @Valid Prof prof, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "modifier_prof";
        }
        //Enregistrer prof dans la BD
        profRepository.save(prof);
        return "redirect:/profs";
    }

    
    @GetMapping("/profs/delete")
    public String deleteProf(@RequestParam(name="id") int id, Model model)
    {
        List<SeanceCours> myList = seancecoursRepository.chercherSeanceCoursParNumProf(id);
        if (!myList.isEmpty())
        {
            model.addAttribute("message", "Impossible de supprimer un prof qui n'est pas vide !");
            model.addAttribute("listProfs", profRepository.findAll());
            return "profs";
        }
        else
            profRepository.deleteById(id);
        return "redirect:/profs";
    }
}
