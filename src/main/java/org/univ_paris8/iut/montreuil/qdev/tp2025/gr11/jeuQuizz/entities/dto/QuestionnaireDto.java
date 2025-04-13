package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto;

import java.util.ArrayList;

public class QuestionnaireDto {
    private ArrayList<QuestionDto> listeDeQuestions;
    private static int compteur =0;
    private int id;

    public QuestionnaireDto(ArrayList<QuestionDto> listeDeQuestions) {
        this.listeDeQuestions = listeDeQuestions;
        this.id = compteur++;
    }

    public ArrayList<QuestionDto> getListeDeQuestions() {
        return listeDeQuestions;
    }

    public void setListeDeQuestions(ArrayList<QuestionDto> listeDeQuestions) {
        this.listeDeQuestions = listeDeQuestions;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "QuestionnaireDto{" +
                "listeDeQuestions=" + listeDeQuestions +
                ", id=" + id +
                '}';
    }
}
