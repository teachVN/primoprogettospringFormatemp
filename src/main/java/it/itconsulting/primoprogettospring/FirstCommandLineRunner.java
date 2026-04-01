package it.itconsulting.primoprogettospring;

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
    private PersonaRepository personaRepository;

    @Autowired
    private DispositiviRepository dispositiviRepository;
    
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println(p);
        System.out.println(p2);
        System.out.println(computer);

        //salva una persona attraverso il corrispondete repository
        personaRepository.save(p);
        personaRepository.save(p2);

        dispositiviRepository.save(computer);

		
    }
}
