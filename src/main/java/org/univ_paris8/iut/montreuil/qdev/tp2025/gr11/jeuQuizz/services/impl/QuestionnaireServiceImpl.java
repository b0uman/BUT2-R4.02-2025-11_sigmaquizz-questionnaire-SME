package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.enums.Difficulte;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.LiensNonValideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.QuestionnaireException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireServiceImpl implements IQuestionniareServices {

    private static List<QuestionnaireDto> bibliotheque = new ArrayList<>();

    // Méthode pour vérifier si la bibliothèque est déjà chargée
    private boolean isBibliothequeChargee() {
        return !bibliotheque.isEmpty();
    }

    // Méthode pour charger les questions depuis un fichier CSV
    private void chargerQuestionsDepuisCsv(String lien) throws LiensNonValideException, QuestionnaireException {
        // Vérification si le lien est valide
        if (lien == null || lien.trim().isEmpty()) {
            throw new LiensNonValideException();
        }

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(lien)) {
            if (inputStream == null) {
                throw new LiensNonValideException(); // Le fichier n'a pas été trouvé
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            ArrayList<QuestionDto> listeDeQuestions = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                // Séparer la ligne CSV par ";"
                String[] values = line.split(";");

                // Vérification du format des données
                if (values.length < 8) {
                    throw new QuestionnaireException("Erreur : format CSV invalide, certaines informations sont manquantes.");
                }

                try {
                    // Extraire les informations de chaque question
                    int numQuestion = Integer.parseInt(values[1]);
                    Langues langue = Langues.valueOf(values[2].toUpperCase());
                    String libelle = values[3];
                    String reponse = values[4];
                    int difficulteCsv = Integer.parseInt(values[5]);
                    Difficulte difficulte = Difficulte.values()[difficulteCsv - 1];
                    String informations = values[6];
                    String source = values[7];

                    // Créer un objet QuestionDto
                    QuestionDto question = new QuestionDto(numQuestion, langue, libelle, reponse, difficulte, informations, source);
                    listeDeQuestions.add(question);
                } catch (IllegalArgumentException e) {
                    throw new QuestionnaireException("Erreur : données de question mal formées dans le fichier CSV.");
                }
            }

            // Créer un QuestionnaireDto avec la liste de questions et l'ajouter à la bibliothèque
            QuestionnaireDto questionnaire = new QuestionnaireDto(listeDeQuestions);
            bibliotheque.add(questionnaire);

        } catch (IOException e) {
            throw new LiensNonValideException();  // Si le fichier est introuvable ou une erreur d'entrée-sortie survient
        }
    }
    // lien invalide bien relier le csv au projet pour pouvoir reeleement tester les changemments

    @Override
    public ArrayList<QuestionnaireDto> fournirListeQuestionnaire(String lien) throws QuestionnaireException {
        // Vérifier si la bibliothèque est déjà chargée
        if (!isBibliothequeChargee()) {
            // Si la bibliothèque est vide, charger les questions depuis le fichier CSV
            chargerQuestionsDepuisCsv(lien);
        }
        // Retourner la liste des questionnaires
        return new ArrayList<>(bibliotheque);
    }
}
