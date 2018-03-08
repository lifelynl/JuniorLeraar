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

    Boolean isTitle;

    String resultText;
    String teachterText;
    String questionText;

    public DialogueCard() {

    }

    public DialogueCard(String level, String theme, String title, String competence,
                        String resultText, String teachterText, String questionText){
        this.level = level;
        this.theme = theme;
        this.title = title;
        this.competence = competence;

        this.isTitle = false;

        this.resultText = resultText;
        this.teachterText = teachterText;
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

    public Boolean getIsTitle() {
        return isTitle;
    }

    public void setIsTitle(Boolean isTitle) {
        this.isTitle = isTitle;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getTeachterText() {
        return teachterText;
    }

    public void setTeachterText(String teachterText) {
        this.teachterText = teachterText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String toString(){
        return level + ":\t" + theme + ",\t" + competence + ",\t" + title + ",\t" + resultText;
    }
}

