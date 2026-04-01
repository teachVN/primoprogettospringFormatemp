package it.itconsulting.primoprogettospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itconsulting.primoprogettospring.bean.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}
