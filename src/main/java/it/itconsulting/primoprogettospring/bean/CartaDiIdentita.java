package it.itconsulting.primoprogettospring.bean;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CartaDiIdentita {

    @Id
    @GeneratedValue
    private int id;
    private String comune;
    private LocalDate dataRilascio;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
}
