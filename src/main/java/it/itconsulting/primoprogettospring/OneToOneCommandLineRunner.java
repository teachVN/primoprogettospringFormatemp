package it.itconsulting.primoprogettospring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.itconsulting.primoprogettospring.bean.CartaDiIdentita;
import it.itconsulting.primoprogettospring.bean.Persona;
import it.itconsulting.primoprogettospring.service.CartaDiIdentitaService;
import it.itconsulting.primoprogettospring.service.PersonaService;

@Component
public class OneToOneCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private CartaDiIdentitaService cartaDiIdentitaService;

    @Autowired
    @Qualifier("Mario")
    private Persona p;

    @Override
    public void run(String... args) throws Exception {
        /* CartaDiIdentita cartaDiIdentita = new CartaDiIdentita();

        cartaDiIdentita.setComune("Roma");
        cartaDiIdentita.setDataRilascio(LocalDate.of(2000, 10, 10)); */

        //System.out.println(cartaDiIdentitaService.create(cartaDiIdentita));

        //estraggo la carta di identità con id 1
        CartaDiIdentita cartaDiIdentita = cartaDiIdentitaService.getById(1);

        //p = personaService.createPersona(p);

        //cartaDiIdentita.setPersona(p);

        //System.out.println(cartaDiIdentitaService.update(cartaDiIdentita, 1));

        //stampo la carta di identità collegata alla persona che è collegata alla carta di identità
        System.out.println(cartaDiIdentita.getPersona().getCartaDiIdentita());

        //creo una seconda carta di identità senza la persona associata
        CartaDiIdentita cartaDiIdentita2 = new CartaDiIdentita();
        cartaDiIdentita2.setComune("Napoli");
        cartaDiIdentita2.setDataRilascio(LocalDate.of(2010, 04, 04));

        cartaDiIdentita2=cartaDiIdentitaService.create(cartaDiIdentita2);

        //estraggo la persona della prima carta di identità e la salvo in una variabile
        Persona p = cartaDiIdentita.getPersona();

        //gli setto la carta di identità nuova
        p.setCartaDiIdentita(cartaDiIdentita2);

        //aggiorno la persona sul db
        p=personaService.updatePersona(p, p.getId());

        System.out.println(p.getCartaDiIdentita());
    }
    
}
