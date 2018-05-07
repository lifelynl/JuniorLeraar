package com.hva.tsse.juniorleraar.data;

import android.content.Context;
import android.util.Log;

import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Make sure you add a list with the constructor with list
 * Otherwise there are no lists to retrieve
 *
 * Created by Melanie on 22-2-2018.
 */

public class DataSource {
    private Context context;
    private static List<DialogueCard> mDialogueCards;
    private static final String TAG = "DATASOURCECLASS";

    /**
     * Empty constructor because the list is static
     * It is the same so it can be retrieved from everywhere
     */
    public DataSource(){
//        if (mDialogueCards==null){
//            Json json = new Json();
//            mDialogueCards = json.getmDialoguecards();
//        }
        logList(mDialogueCards);
    }

    /**
     * Making sure the list when created is the same everywhere
     * @param mDialogueCards
     */
    public DataSource(List<DialogueCard> mDialogueCards){
        this.mDialogueCards = mDialogueCards;
        logList(mDialogueCards);
        int count = mDialogueCards.size();
//        String hoi = count.toString();
//        Log.w(TAG, count.toString());
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
     * @return all the titles with the theme "Didactisch Bekwaam"
     */
    public List<DialogueCard> getTitlesDidactischBekwaam(){
        List<DialogueCard> listTitles = getList("Didactisch Bekwaam",null,null, "Startbekwaam");
        List<DialogueCard> listCompetence = new ArrayList<>();
        for (DialogueCard card : listTitles){
            if (card.getTitle().matches("\\d\\.(\\s|1).*")){
                listCompetence.add(card);
            }
            listCompetence.add(card);
        }
        return listCompetence;
    }

    /**
     * @return all the titles with the theme "Collegiale Samenewerking"
     */
    public List<DialogueCard> getTitlesCollegialeSamenwerking(){
        return getList("Collegiale Samenwerking", null,null,"Startbekwaam");
    }

    /**
     * @return all the titles with the theme "Pedagogisch Bekwaam"
     */
    public List<DialogueCard> getTitlesPedagogischBekwaam(){
        return getList("Pedagogisch Bekwaam", null,null, "Startbekwaam");
    }

    /**
     * @return the specific card depending on the title of the card and the level
     */
    public DialogueCard getCardFromTitleBekwaam(String title){
        DialogueCard mDialogueCard = new DialogueCard();
        for (DialogueCard card : mDialogueCards){
            if (card.getTitle().equals(title)){
                if (card.getLevel().equals("Bekwaam")){
                    return card;
                }
            }
        }
        return null;
    }

    /**
     * @return the specific card depending on the title of the card and the level
     */
    public DialogueCard getCardFromTitleStartbekwaam(String title){
        DialogueCard mDialogueCard = new DialogueCard();
        for (DialogueCard card : mDialogueCards){
            if (card.getTitle().equals(title)){
                if (card.getLevel().equals("Startbekwaam")){
                    return card;
                }
            }
        }
        return null;
    }
}
