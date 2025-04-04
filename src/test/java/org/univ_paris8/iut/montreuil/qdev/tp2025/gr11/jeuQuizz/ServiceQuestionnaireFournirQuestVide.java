package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.FichierCorompuException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.LiensNonValideException;

import java.util.ArrayList;

public class ServiceQuestionnaireFournirQuestVide implements IQuestionniareServices {
    @Override
    public ArrayList<QuestionnaireDto> fournirListeQuestionnaire(String lien) throws LiensNonValideException, FichierCorompuException {
        ArrayList<QuestionnaireDto> questionnaireDtos = new ArrayList<>();
        return questionnaireDtos;
    }
}
