package com.hva.tsse.juniorleraar.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Melanie on 21-3-2018.
 */

public class Database {

    //Local variables and constants
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private DBHelper mDBHelper;
    private String[] TOERNOOI_ALL_COLUMNS = {
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_ID,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_LEVEL,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_THEME,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TITLE,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_COMPETENCE,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_RESULTTEXT,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TEACHERTEXT,
            DialogueCardContract.DialogueCardEntry.COLUMN_NAME_QUESTIONTEXT};

    // constructor
    public Database(Context context) {
        mDBHelper = new DBHelper(context);
    }
    // Opens the database to use it
    public void open()  {
        mDatabase = mDBHelper.getWritableDatabase();
    }
    // Closes the database when you no longer need it
    public void close() {
        mDBHelper.close();
    }

    /**
     * Haalt alle toernooien op uit de database
     * @return alle toernooien die bestaan in de datbase
     */
    public List<DialogueCard> get()
    {
        mDatabase = mDBHelper.getReadableDatabase();

        String selectQuery = "SELECT  " +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_ID + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_LEVEL + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_THEME + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TITLE + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_COMPETENCE + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_RESULTTEXT + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TEACHERTEXT + ',' +
                DialogueCardContract.DialogueCardEntry.COLUMN_NAME_QUESTIONTEXT +
                " FROM " + DialogueCardContract.DialogueCardEntry.TABLE_NAME;

        List<DialogueCard> list = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DialogueCard card = new DialogueCard();
//                card.setId(cursor.getInt(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_ID)));
                card.setLevel(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_LEVEL)));
                card.setTheme(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_THEME)));
                card.setTitle(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TITLE)));
                card.setCompetence(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_COMPETENCE)));
                card.setResultText(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_RESULTTEXT)));
                card.setTeacherText(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TEACHERTEXT)));
                card.setQuestionText(cursor.getString(cursor.getColumnIndex(DialogueCardContract.DialogueCardEntry.COLUMN_NAME_QUESTIONTEXT)));
                list.add(card);
            } while (cursor.moveToNext());
        }
        cursor.close();
        close();
        return list;
    }
}
