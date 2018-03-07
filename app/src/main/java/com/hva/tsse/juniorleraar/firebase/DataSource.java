package com.hva.tsse.juniorleraar.firebase;

import android.util.Log;

import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanie on 22-2-2018.
 */

public class DataSource {
    private final String TAG = "DATASOURCECLASS";
    private static List<DialogueCard> mDialogueCards;

    /**
     * Empty constructor because the list is static
     * It is the same so it can retrieved from everywhere
     */
    public DataSource(){

    }

    /**
     * Making sure the list when created is the same everywhere
     * @param mDialogueCards
     */
    public DataSource(List<DialogueCard> mDialogueCards){
        this.mDialogueCards = mDialogueCards;
    }

    /**
     * Create a method in which you can get every list by the variables
     * @param theme The theme of the card
     * @param competence The competence of the card
     * @param title The title of the card
     * @param level The level of the card
     * @return A list which you want
     */
    private List<DialogueCard> getList(String theme, String competence, String title, String level){
        List<DialogueCard> list = new ArrayList<>();
        for (DialogueCard card : mDialogueCards) {
            if (theme == null || card.getTheme().equals(theme)){
                if (competence == null || card.getCompetence().equals(competence)){
                    if (title == null || card.getTitle().equals(title)){
                        if (level == null || card.getLevel().equals(level)){
                            list.add(card);
                        }
                    }
                }
            }
        }
        logList(list);
        return list;
    }

    /**
     * Log a list to check if the return values are correct
     * @param list The list you want to log
     */
    private void logList(List<DialogueCard> list){
        for (DialogueCard card : list){
            Log.w(TAG, card.toString());
        }
    }

    /**
     * @return all the cards not sorted
     */
    public List<DialogueCard> getAllCards(){
        return mDialogueCards;
    }

    /**
     * @return all the titles from the theme "Didactisch bekwaam" and the level "Startbekwaam"
     */
    public List<DialogueCard> getCardsDidactischBekwaamStartbekwaam(){
        return getList("Didactisch Bekwaam",null,null, "Startbekwaam");
    }

    /**
     * @return all the titles from the theme "Didactisch bekwaam" and the level "Bekwaam"
     */
    public List<DialogueCard> getCardsDidactischBekwaamBekwaam(){
        return getList("Didactisch Bekwaam",null,null, "Bekwaam");
    }

    /**
     * @return all the titles from the theme "Collegiale samenwerking" and the level "Startbekwaam"
     */
    public List<DialogueCard> getCardsCollegialeSamenwerkingStartbekwaam(){
        return getList("Collegiale Samenwerking", null,null, "Startbekwaam");
    }

    /**
     * @return all the titles from the theme "Collegiale samenwerking" and the level "Bekwaam"
     */
    public List<DialogueCard> getCardsCollegialeSamenwerkingBekwaam(){
        return getList("Collegiale Samenwerking", null,null, "Bekwaam");
    }

    /**
     * @return all the titles from the theme "Pedagogisch Bekwaam" and the level "Startbekwaam"
     */
    public List<DialogueCard> getCardsPedagogischBekwaamStartbekwaam(){
        return getList("Pedagogisch Bekwaam", null,null, "Startbekwaam");
    }

    /**
     * @return all the titles from the theme "Pedagogisch Bekwaam" and the level "Bekwaam"
     */
    public List<DialogueCard> getCardsPedagogischBekwaamBekwaam(){
        return getList("Pedagogisch Bekwaam", null,null, "Bekwaam");
    }

    /**
     * @return all the titles with the theme "Didactisch Bekwaam"
     */
    public List<DialogueCard> getTitlesDidactischBekwaam(){
        return getList("Didactisch Bekwaam",null,null, "Startbekwaam");
    }

    /**
     * @return all the titles with the theme "Collegiale Samenewerking"
     */
    public List<DialogueCard> getTitlesCollegialeSamenwerking(){
        return getList("Collegiale Samenwerking", null,null, "Startbekwaam");
    }

    /**
     * @return all the titles with the theme "Pedagogisch Bekwaam"
     */
    public List<DialogueCard> getTitlesPedagogischBekwaam(){
        return getList("Pedagogisch Bekwaam", null,null, "Startbekwaam");
    }
}
