package com.hva.tsse.juniorleraar.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Melanie on 21-3-2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "juniorleraar.db";
    private static final int DATABASE_VERSION = 1;

    // Creating the table
    private static final String DATABASE_CREATE_TABLE_DIALOGUECARD =
            "CREATE TABLE " + DialogueCardContract.DialogueCardEntry.TABLE_NAME +
                    "(" +
                    DialogueCardContract.DialogueCardEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_LEVEL + " TEXT, "
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_THEME + " TEXT )"
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TITLE + " TEXT )"
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_COMPETENCE + " TEXT )"
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_RESULTTEXT + " TEXT )"
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_TEACHERTEXT + " TEXT )"
                    + DialogueCardContract.DialogueCardEntry.COLUMN_NAME_QUESTIONTEXT + " TEXT )";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE_DIALOGUECARD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DialogueCardContract.DialogueCardEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
