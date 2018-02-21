package com.hva.tsse.juniorleraar.adapter;

import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

/**
 * Created by Melanie on 21-2-2018.
 */

public class DialogueCardAdapter {
    private static List<DialogueCard> mDialogueCards;

    public DialogueCardAdapter(){

    }

    public DialogueCardAdapter(List<DialogueCard> mDialogueCards){
        this.mDialogueCards = mDialogueCards;
    }

    public List<DialogueCard> getAllCards(){
        return mDialogueCards;
    }
}
