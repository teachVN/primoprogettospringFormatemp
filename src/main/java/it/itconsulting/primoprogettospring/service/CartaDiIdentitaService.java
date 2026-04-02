package it.itconsulting.primoprogettospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.itconsulting.primoprogettospring.bean.CartaDiIdentita;
import it.itconsulting.primoprogettospring.bean.Persona;
import it.itconsulting.primoprogettospring.repository.CartaDiIdentitaRepository;

@Service
public class CartaDiIdentitaService {
    @Autowired
    private CartaDiIdentitaRepository cartaDiIdentitaRepository;

    @Autowired
    private PersonaService personaService;

    public CartaDiIdentita create(CartaDiIdentita cartaDiIdentita){
        if (cartaDiIdentita!=null) {
            return cartaDiIdentitaRepository.save(cartaDiIdentita);
        }

        throw new IllegalArgumentException("La carta di identità " + cartaDiIdentita + " non valida");
    }

    public CartaDiIdentita getById(int id){
        return cartaDiIdentitaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Carta di identità con id " + id + " non trovata"));
    }

    public List<CartaDiIdentita> getAll(){
        return cartaDiIdentitaRepository.findAll();
    }

    public CartaDiIdentita update(CartaDiIdentita cartaDiIdentita, int id){
        CartaDiIdentita cartaDaAggiornare = getById(id);

        if(cartaDiIdentita!=null){
            if(cartaDiIdentita.getPersona()!=null && (cartaDaAggiornare.getPersona()==null || cartaDiIdentita.getPersona().getId()!=cartaDaAggiornare.getPersona().getId())){
                Persona p = personaService.getPersonaById(cartaDiIdentita.getPersona().getId());
                cartaDaAggiornare.setPersona(p);
            }

            if(cartaDiIdentita.getComune()!=null && !cartaDiIdentita.getComune().equals(cartaDaAggiornare.getComune())){
                cartaDaAggiornare.setComune(cartaDiIdentita.getComune());
            }
            if(cartaDiIdentita.getDataRilascio()!=null && !cartaDiIdentita.getDataRilascio().equals(cartaDaAggiornare.getDataRilascio())){
                cartaDaAggiornare.setDataRilascio(cartaDiIdentita.getDataRilascio());
            }
            

            return cartaDiIdentitaRepository.save(cartaDaAggiornare);
        }

        throw new IllegalArgumentException("Carta di identità " + cartaDiIdentita + " non valida");


    }

    public void remove(int id){
        cartaDiIdentitaRepository.deleteById(id);
    }
}
