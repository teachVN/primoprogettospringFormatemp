package it.itconsulting.primoprogettospring.bean;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.itconsulting.primoprogettospring.component.Computer;
import it.itconsulting.primoprogettospring.component.Dispositivi;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "cartaDiIdentita")
public class Persona {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonaSequence")
   @SequenceGenerator(name = "PersonaSequence", initialValue = 100, allocationSize = 10)
   //@GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String nome;
    private String cognome;
    private String indirizzo;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @OneToOne(mappedBy = "persona")
    private CartaDiIdentita cartaDiIdentita;

    //@Autowired
    //private Computer computer;

    //
    //private List<Dispositivi> dispositivi;
    
    public Persona(String nome, String cognome, String indirizzo, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
    }

    



    
    
}
