package com.example;

import com.example.entity.Prof;
import com.example.entity.SeanceCours;
import com.example.repository.ProfRepository;
import com.example.repository.SeanceCoursRepository;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcoleApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(EcoleApplication.class, args);

        /*ApplicationContext ctx = SpringApplication.run(EcoleApplication.class, args);
            ProfRepository profRepository = ctx.getBean(ProfRepository.class);
            
            profRepository.save (new Prof("Anne","Janssens",LocalDate.parse("1980-05-28"),"F"));
            profRepository.save (new Prof("Marc","Jacobs",LocalDate.parse("1978-10-12"),"H"));
            profRepository.save (new Prof("Betty","Anderson",LocalDate.parse("1987-12-02"),"F"));
            profRepository.save (new Prof("Alex","Andrew",LocalDate.parse("1982-07-15"),"H")); 
            
            List<Prof> myList= profRepository.findByPrenom("Anne");
            myList.forEach (e->System.out.println(e.getPrenom() + " " + e.getNom()));
                       
            myList= profRepository.findByNomContaining("A");
            myList.forEach (e->System.out.println(e.getId() + " " + e.getPrenom() + " " + e.getNom())); */

    }

}


