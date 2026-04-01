package it.itconsulting.primoprogettospring.component;

import org.hibernate.annotations.DialectOverride.GeneratedColumns;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import lombok.Data;

@Data

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Dispositivi {
    @Id
    @GeneratedValue
    private int id;

    private String marca;
    private String modello;
    private String colore;
    private String ram;
    private String cpu;

    public Dispositivi(String marca, String modello, String colore, String ram, String cpu) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.ram = ram;
        this.cpu = cpu;
    }

    
    
}
