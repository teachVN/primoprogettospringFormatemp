package it.itconsulting.primoprogettospring;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import it.itconsulting.primoprogettospring.bean.Persona;

@Configuration
public class AppConfig {

    
    @Bean(name = "Mario")
    public Persona getPersona1(){
        Persona p = new Persona("Mario", "Rossi", "Via Roma", LocalDate.of(2000, 5, 5));
        return p;
    }

    
    @Bean(name = "Francesca")
    @Primary
    public Persona getPersona2(){
        Persona p = new Persona("Francesca", "Verdi", "Via Roma", LocalDate.of(2002, 5, 5));
        return p;
    }
    
}
