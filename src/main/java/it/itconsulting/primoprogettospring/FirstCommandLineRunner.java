package it.itconsulting.primoprogettospring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import it.itconsulting.primoprogettospring.bean.Persona;
import it.itconsulting.primoprogettospring.component.Computer;
import it.itconsulting.primoprogettospring.repository.DispositiviRepository;
import it.itconsulting.primoprogettospring.repository.PersonaRepository;
import it.itconsulting.primoprogettospring.service.PersonaService;

@Component
public class FirstCommandLineRunner implements CommandLineRunner{

    @Autowired
    @Qualifier("Francesca")
    private Persona p;

   
    @Autowired(required = false)
    @Qualifier("Mario")
    private Persona p2;

    @Autowired
    private Computer computer;

    @Autowired
    private PersonaService personaService;

    //@Autowired
    //private DispositiviRepository dispositiviRepository;
    
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println(p);
        System.out.println(p2);
        System.out.println(computer);

        Persona personaSalvata=null;

        try{
            personaSalvata = personaService.createPersona(p);

            System.out.println(personaService.getPersonaById(personaSalvata.getId()));
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("stampa tutte le persone dopo la create");

        System.out.println(personaService.getAll());

        try{
            personaSalvata.setCognome("Neri");
            personaSalvata.setDataNascita(LocalDate.of(2010, 7, 8));

            personaSalvata = personaService.updatePersona(personaSalvata, personaSalvata.getId());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("stampa tutte le persone dopo l'update");

        System.out.println(personaService.getAll());

        personaService.removePersona(personaSalvata.getId());

        System.out.println("stampa tutte le persone dopo la remove");

        System.out.println(personaService.getAll());

		
    }
}
