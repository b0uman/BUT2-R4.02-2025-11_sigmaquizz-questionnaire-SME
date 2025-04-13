package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.enums.Difficulte;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.enums.Langues;

public class QuestionDto {
    private int numQuestion;
    private String libelle;
    private String reponse;
    private String source;
    private String informations;
    Langues langues;
    Difficulte difficulte;

    public QuestionDto(int numQuestion, String libelle, String reponse, Difficulte difficulte) {
        this.numQuestion = numQuestion;
        this.libelle = libelle;
        this.reponse = reponse;
        this.difficulte = difficulte;


    }

    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "numQuestion=" + numQuestion +
                ", libelle='" + libelle + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte=" + difficulte +
                '}';
    }
}
