package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;

import java.util.ArrayList;
import java.util.List;

public interface IQuestionniareServices {
    public ArrayList<QuestionnaireDto> fournirListeQuestionnaire(String lien);
}
