package it.itconsulting.primoprogettospring.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Component
@PropertySource("application.properties")
@Entity
public class Smartphone extends Dispositivi{

    public Smartphone(@Value("${smartphone.marca}") String marca, 
                    @Value("${smartphone.modello}") String modello,
                    @Value("${smartphone.colore}") String colore,
                    @Value("${smartphone.ram}") String ram,
                    @Value("${smartphone.cpu}") String cpu){
                        super(marca, modello, colore, ram, cpu);
                    }
    
}
