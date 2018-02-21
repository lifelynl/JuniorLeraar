package com.hva.tsse.juniorleraar.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanie on 15-2-2018.
 */

public class Firebase implements Serializable {
    private static final String TAG = "FIREBASECLASS";
    private static final String mURL = "https://junior-leraar.firebaseio.com/Dialoguecard";
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;

    private List<DialogueCard> mDialogueCards;

    /**
     * Creates an instance Firebase and sets the data right
     */
    public Firebase() {
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReferenceFromUrl(mURL);
        mDialogueCards = new ArrayList<DialogueCard>();
    }

    /**
     *  This method gets all the data from the firebase
     *  and puts all the dialogue cards from the firebase in the list mDialogueCards
     */
    public void getData(){
        // Read from the firebase
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // In case the data is already catched
                // list is cleared and catched again
                clearDialogueCards();

                // For each dialoguecard in firebase
                // Get it and put it in the list mDialogueCards
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    DialogueCard dialogue = messageSnapshot.getValue(DialogueCard.class);
                    mDialogueCards.add(dialogue);
                }
                Log.w(TAG, "Trying to get text form firebase: " + mDialogueCards.get(0).getLevel());
                Log.w(TAG, "Number of object from Firebase: " + mDialogueCards.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Print error message
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void clearDialogueCards(){
        mDialogueCards.clear();
    }

    public List<DialogueCard> getmDialogueCards(){
        return mDialogueCards;
    }
}