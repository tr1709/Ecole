/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.entity.SeanceCours;
import com.example.repository.ProfRepository;
import com.example.repository.SeanceCoursRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nhitr
 */
@Controller
public class SeanceCoursController {
    // injection des dépendances par Spring: une instance de la classe SimpleJpaRepository sera injectée ici, car c'est la classe par défaut qui implémente l'interface JpaRepository (dont seancecoursRepository hérite)
    @Autowired 
    private SeanceCoursRepository seancecoursRepository;
    @Autowired 
    private ProfRepository profRepository;
    
   
    // afficher la liste des cours
    @GetMapping("/seancescours")
    public String listSeancesCours(Model model)
    {
        model.addAttribute("listSeancesCours", seancecoursRepository.findAll());
        model.addAttribute("listProfs", profRepository.findAll());
        
        return "seancescours"; // returns the view name, ie the Thymele"af template "seancescours"
    }
    
    // afficher la liste des cours avec filtre 1 
    @GetMapping("/seancescours/filter1")
    public String viewHomePageFilter1(Model model, @RequestParam(name="motCle", defaultValue="") String mc)
    {
        model.addAttribute("listSeancesCours", seancecoursRepository.findByNomCoursContaining(mc));
        model.addAttribute("filter1", mc);
        model.addAttribute("listProfs", profRepository.findAll());
        
        return "seancescours"; 
    }
    
    // afficher la liste des cours avec filtre 2
    @GetMapping("/seancescours/filter2")
    public String viewHomePageFilter2(Model model, @RequestParam(name="jour", defaultValue="") String jr) 
    {
         
    
        
        if (!jr.equals(""))
        {
            model.addAttribute("listSeancesCours", seancecoursRepository.findByJour(jr));
        }
        else
        {
            model.addAttribute("listSeancesCours", seancecoursRepository.findAll());
        }
        
        model.addAttribute("filter2", jr);
        model.addAttribute("listProfs", profRepository.findAll());
        return "seancescours"; 
        
       
    }
        

    
    // afficher la liste des cours avec filtre 3
       @GetMapping("/seancescours/filter3")
    public String viewHomePageFilter3(Model model, @RequestParam(name="prof", defaultValue="") String p) 
    {   
        
        
        int num = Integer.parseInt(p);
        
        if (num == 0)
        {
            model.addAttribute("listSeancesCours", seancecoursRepository.findAll());
        }
        else
        {
            model.addAttribute("listSeancesCours", seancecoursRepository.chercherSeanceCoursParNumProf(num));
        }
        
        model.addAttribute("filter3", p);
        model.addAttribute("listProfs", profRepository.findAll());
        return "seancescours"; 
    }
    
    @GetMapping("/seancescours/new")
    public String showNewSeanceCoursForm(Model model)
    {
        //Créer un attribut de modèle pour lier les données du formulaire
        SeanceCours seancecours = new SeanceCours();
       
        model.addAttribute("seancecours", seancecours);
        model.addAttribute("listProfs", profRepository.findAll());
        return "nouvelle_seancecours";
    }
    
    @PostMapping("/seancescours/saveNew")
    public String saveNewSeanceCours(@ModelAttribute("seancecours") @Valid SeanceCours seancecours, Errors errors, Model model)
    {
        if (errors.hasErrors())
        {         
            model.addAttribute("listProfs", profRepository.findAll());
            return "nouvelle_seancecours";
        }
       
            seancecoursRepository.save(seancecours); //enregistrer cours dans DB

        return "redirect:/seancescours";
    }
               
    @GetMapping("/seancescours/update")
    public String showUpdateSeanceCoursForm(@RequestParam(name="id") int id, Model model)
    {
        //obtenir le cours du prof
        Optional<SeanceCours> optional = seancecoursRepository.findById(id);
        SeanceCours seancecours = null;
        if (optional.isPresent())
            seancecours = optional.get();
        else
            throw new RuntimeException ("Cours introuvable pour id : " + id);
        
        //Définir seancecours comme attribut de modèle pour pré-remplir le formulaire
        model.addAttribute("seancecours", seancecours);
        model.addAttribute("listProfs", profRepository.findAll());
        return "modifier_seancecours";
    }
        
    @PostMapping("/seancescours/saveUpdate")
    public String saveUpdateSeanceCours(@ModelAttribute("seancecours") @Valid SeanceCours seancecours, Errors errors, Model model)
    {
        if (errors.hasErrors())
        {
            model.addAttribute("listProfs", profRepository.findAll());
            return "modifier_seancecours";
        }
        seancecoursRepository.save(seancecours); //enregistrer cours dans la BD
        return "redirect:/seancescours";
    }

    
    @GetMapping("/seancescours/delete")
    public String deleteSeanceCours(@RequestParam(name="id") int id)
    {
        //call delete cours method
        seancecoursRepository.deleteById(id);
        return "redirect:/seancescours";
    }
}




