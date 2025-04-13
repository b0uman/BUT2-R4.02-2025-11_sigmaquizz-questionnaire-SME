package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.enums.Difficulte;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.FichierCorompuException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.LiensNonValideException;

import java.util.ArrayList;

public class ServiceQuestionnaireFournirQuesOkBouchon implements IQuestionniareServices {
    public  ArrayList<QuestionnaireDto> fournirListeQuestionnaire(String url)throws LiensNonValideException, FichierCorompuException {
        ArrayList<QuestionDto> listeQuestion = new ArrayList<>();
        ArrayList<QuestionnaireDto> listeQuestionnaire = new ArrayList<>();
        QuestionDto questionDto1 = new QuestionDto(1,"De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee", Difficulte.FACILE);
        QuestionDto questionDto2 = new QuestionDto(2,"Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?","Badminton",Difficulte.FACILE);
        QuestionDto questionDto3 = new QuestionDto(3,"Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?","Onze",Difficulte.FACILE);
        listeQuestion.add(questionDto1);
        listeQuestion.add(questionDto2);
        listeQuestion.add(questionDto3);
        QuestionnaireDto questionnaireDto = new QuestionnaireDto(listeQuestion);
        listeQuestionnaire.add(questionnaireDto);
        return listeQuestionnaire;
    };

}
