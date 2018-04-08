package com.hva.tsse.juniorleraar.data;

import android.provider.BaseColumns;

/**
 * Created by Melanie on 21-3-2018.
 */

public class DialogueCardContract {

    private DialogueCardContract() {}

    /*
    * Inner class that defines the table contents
    */
    public static class DialogueCardEntry implements BaseColumns {
        public static final String TABLE_NAME = "DialogueCard";
        // Labels Table Columns names
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_LEVEL = "level";
        public static final String COLUMN_NAME_THEME = "theme";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_COMPETENCE = "competence";
        public static final String COLUMN_NAME_RESULTTEXT = "resultText";
        public static final String COLUMN_NAME_TEACHERTEXT = "teacherText";
        public static final String COLUMN_NAME_QUESTIONTEXT = "questionText";
    }
}
