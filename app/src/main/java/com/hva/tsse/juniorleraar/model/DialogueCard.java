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

    String text;

    public DialogueCard() {

    }

    public DialogueCard(String level, String theme, String title, String competence, String text){
        this.level = level;
        this.theme = theme;
        this.title = title;
        this.competence = competence;

        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
