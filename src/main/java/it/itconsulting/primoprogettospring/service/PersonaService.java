package it.itconsulting.primoprogettospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.itconsulting.primoprogettospring.bean.Persona;
import it.itconsulting.primoprogettospring.repository.PersonaRepository;

@Service //discende da component
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona createPersona(Persona persona){
        if(persona!=null){
            return personaRepository.save(persona);
        }
        throw new IllegalArgumentException("Persona " + persona + " non valida");
    }

    public Persona getPersonaById(int id){
        return personaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Persona con id " + id + " non trovata"));
    }

    public List<Persona> getAll(){
        return personaRepository.findAll();
    }

    public Persona updatePersona(Persona persona, int id){
        Persona personaDaAggiornare = getPersonaById(id);

        if(persona!=null){
            if(persona.getNome()!=null && !persona.getNome().equals(personaDaAggiornare.getNome())){
                personaDaAggiornare.setNome(persona.getNome());
            }
            if(persona.getCognome()!=null && !persona.getCognome().equals(personaDaAggiornare.getCognome())){
                personaDaAggiornare.setCognome(persona.getCognome());
            }
            if(persona.getIndirizzo()!=null && !persona.getIndirizzo().equals(personaDaAggiornare.getIndirizzo())){
                personaDaAggiornare.setIndirizzo(persona.getIndirizzo());
            }
            if(persona.getDataNascita()!=null && !persona.getDataNascita().equals(personaDaAggiornare.getDataNascita())){
                personaDaAggiornare.setDataNascita(persona.getDataNascita());
            }

            return personaRepository.save(personaDaAggiornare);
        }

        throw new IllegalArgumentException("Persona " + persona + " non valida");


    }

    public void removePersona(int id){
        personaRepository.deleteById(id);
    }


    
}
