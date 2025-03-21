package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.impl.QuestionnaireServiceImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.LiensNonValideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.QuestionnaireException;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        // Accéder au fichier CSV dans le dossier 'ressources'
        String lien = "ressources/questionsQuizz_V1.1.csv";

        // Créer une instance du service QuestionnaireServiceImpl
        QuestionnaireServiceImpl service = new QuestionnaireServiceImpl();

        try {
            // Appeler la méthode fournirListeQuestionnaire pour récupérer les questionnaires
            ArrayList<QuestionnaireDto> questionnaires = service.fournirListeQuestionnaire(lien);

            // Afficher le contenu des questionnaires
            for (QuestionnaireDto questionnaire : questionnaires) {
                System.out.println(questionnaire);
            }

        } catch (LiensNonValideException e) {
            System.err.println("Erreur: Le fichier CSV spécifié est invalide ou introuvable.");
        } catch (QuestionnaireException e) {
            System.err.println("Erreur: Un problème est survenu lors du traitement du fichier CSV.");
        }
    }
}
