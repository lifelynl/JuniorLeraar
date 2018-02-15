package com.hva.tsse.juniorleraar.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanie on 15-2-2018.
 */

public class Firebase {
    private static final String TAG = "FIREBASECLASS";
    private static final String mURL = "https://junior-leraar.firebaseio.com/Dialoguecard";
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;

    private final List<DialogueCard> mDialogueCards;

    public Firebase() {
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReferenceFromUrl(mURL);
        mDialogueCards = new ArrayList<DialogueCard>();
    }

    public void getData(){
        // Read from the database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DialogueCard dialogue = new DialogueCard();

                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    dialogue = messageSnapshot.getValue(DialogueCard.class);
                    mDialogueCards.add(dialogue);
                }

                Log.w(TAG, "Value1: " + mDialogueCards.get(0).getLevel());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

//    public List<DialogueCard> getDialogueCards(){
        public void getDialogueCards(){
//        try{
//            getData();
//            Log.w(TAG, "Value2: " + mDialogueCards.get(0).getLevel());
//            return mDialogueCards;
//        } catch (Exception e){
//            Log.w(TAG, e.toString());
//        }
//        return null;
    }
}
