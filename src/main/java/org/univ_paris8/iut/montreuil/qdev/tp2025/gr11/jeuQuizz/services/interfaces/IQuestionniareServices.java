package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.QuestionnaireException;

import java.util.ArrayList;
import java.util.List;

public interface IQuestionniareServices {
    public ArrayList<QuestionnaireDto> fournirListeQuestionnaire(String lien) throws QuestionnaireException;
}
