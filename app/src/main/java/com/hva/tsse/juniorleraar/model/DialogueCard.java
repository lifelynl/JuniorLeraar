package com.hva.tsse.juniorleraar.model;

import java.io.Serializable;

/**
 * Created by Melanie on 15-2-2018.
 */

public class DialogueCard implements Serializable {
    String level;
    String theme;
    String title;
    String competence;

    String resultText;
    String teacherText;
    String questionText;

    public DialogueCard() {

    }

    /**
     * The model Dialoguecard
     *
     * @param level The level of the card this is "bekwaam" or "startbekwaam"
     * @param theme The theme of the card this is "didactisch bekwaam", "collegiale samenwerking" or "Pedagogisch bekwaam"
     * @param title The title of the card with a number
     * @param competence The competence of the card. This is the same as title with no number
     * @param resultText The result text of the card
     * @param teacherText The text of the things the teacher should be able to do
     * @param questionText Questions to reflect on his own doing
     */
    public DialogueCard(String level, String theme, String title, String competence,
                        String resultText, String teacherText, String questionText){
        this.level = level;
        this.theme = theme;
        this.title = title;
        this.competence = competence;

        this.resultText = resultText;
        this.teacherText = teacherText;
        this.questionText = questionText;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getTeacherText() {
        return teacherText;
    }

    public void setTeacherText(String teacherText) {
        this.teacherText = teacherText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String toString(){
        return level + ",\t" + theme + ",\t" + competence + ",\t" + title + ",\t" + resultText + ",\t" + teacherText + ",\t" + questionText;
    }
}

