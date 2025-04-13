package org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.entities.dto.QuestionnaireDto;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.services.interfaces.IQuestionniareServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.enums.Difficulte;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.FichierCorompuException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr11.jeuQuizz.utils.exceptions.LiensNonValideException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     *
     */
    private IQuestionniareServices questionniareServices;
    private  ArrayList<QuestionnaireDto> listeQuestionnaireTest;

    @BeforeAll
    static void init(){
     //   IQuestionniareServices
    }

    @BeforeEach
    public void setUp() {
        ArrayList<QuestionDto> listeQuestion = new ArrayList<>();
        listeQuestionnaireTest = new ArrayList<>();
        QuestionDto questionDto1 = new QuestionDto(1,"De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee", Difficulte.FACILE);
        QuestionDto questionDto2 = new QuestionDto(2,"Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?","Badminton",Difficulte.FACILE);
        QuestionDto questionDto3 = new QuestionDto(3,"Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?","Onze",Difficulte.FACILE);
        listeQuestion.add(questionDto1);
        listeQuestion.add(questionDto2);
        listeQuestion.add(questionDto3);
        QuestionnaireDto questionnaireDto = new QuestionnaireDto(listeQuestion);
        listeQuestionnaireTest.add(questionnaireDto);
    }
    @Test
    public void testQuestionnaireServiceValide() throws FichierCorompuException, LiensNonValideException {
        questionniareServices = new ServiceQuestionnaireFournirQuesOkBouchon();

        //alimenter l objet attendu

        ArrayList<QuestionnaireDto> listResult = questionniareServices.fournirListeQuestionnaire("src/test/resources/fichierValide.csv");
        //assertEquals(listeQuestionnaireTest,listResult,"Les listes doivent etre similaire");
        assertEquals(listeQuestionnaireTest.get(0).getListeDeQuestions().get(1).getNumQuestion(),listResult.get(0).getListeDeQuestions().get(1).getNumQuestion(),"Verification du numero de question ");
        assertEquals(listeQuestionnaireTest.get(0).getListeDeQuestions().get(1).getLibelle(),listResult.get(0).getListeDeQuestions().get(1).getLibelle(),"Verification du libelle");
        assertEquals(listeQuestionnaireTest.get(0).getListeDeQuestions().get(1).getReponse(),listResult.get(0).getListeDeQuestions().get(1).getReponse(),"Verification de la reponse");
    }

    @Test
    public void testQuestionnaireServiceVide() throws FichierCorompuException, LiensNonValideException {
        questionniareServices = new ServiceQuestionnaireFournirQuestVide();

        ArrayList<QuestionnaireDto> listResult = questionniareServices.fournirListeQuestionnaire("src/test/resources/fichierVide.csv");
        assertTrue(listResult.isEmpty(),"La list doit etre vide");
    }
    @Test
    public void testQuestionServiceCoromp() throws FichierCorompuException, LiensNonValideException {
        questionniareServices = new ServiceQuestionnaireFournirQuesCoromp();

        assertThrows(FichierCorompuException.class, () -> {
            questionniareServices.fournirListeQuestionnaire("src/test/resources/fichierCorompu");
        });
    }
    @Test
    public  void testQuestionServiceLienInvalide() {
        questionniareServices = new ServiceQuestionnaireFournirQuesCheminInv();
        assertThrows(LiensNonValideException.class, () -> {
            questionniareServices.fournirListeQuestionnaire("src/test/resources/fichierLienInvalide.csv");
        });
    }

}
