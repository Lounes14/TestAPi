package com.example.testapi.repositories;

import com.example.testapi.pojos.Candidat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class LoadData {
    private final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(CandidatRepository repository) throws ParseException {
        log.info("Chargement des données");
        if (repository.count() == 0) {

            //crée un objet date à partir d'une string
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            Date dateNaissance = formater.parse("10/01/2002");

            Candidat candidat = new Candidat("Lounes", "Akli", dateNaissance, "Charpennes", "Villeurbanne", "69100");



            return args ->
            {
                //sauvgarder le condidat dans la BDD
                log.info("Chargement de" + repository.save(candidat));
            };
        }
        else
        {
            return args ->
                    log.info("Données deja chargées");

        }

    }
}
