package it.itconsulting.primoprogettospring.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Data;


@Component
@PropertySource("application.properties")
@Entity
public class Computer extends Dispositivi{

    /* private String marca;
    private String modello;
    private String colore;
    private String ram;
    private String cpu; */
    
    public Computer(@Value("${computer.marca}") String marca, 
                    @Value("${computer.modello}") String modello,
                    @Value("${computer.colore}") String colore,
                    @Value("${computer.ram}") String ram,
                    @Value("${computer.cpu}") String cpu){
                        super(marca, modello, colore, ram, cpu);
                        /* this.marca=marca;
                        this.modello=modello;
                        this.colore=colore;
                        this.ram=ram;
                        this.cpu=cpu; */
                    }
    
}
