package com.hva.tsse.juniorleraar.data;

import android.content.Context;

import com.hva.tsse.juniorleraar.model.DialogueCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Json {
    private String TAG = "JSONCLASS";
    public static List<DialogueCard> mDialoguecards;
    private Context context;
    private static  boolean FIRSTRUN = true;

    /**
     * Constructor to load Json into the list in class datasource
     * @param context context to get json file from assetsfolder
     */
    public Json(Context context){
        this.context = context;
        mDialoguecards = new ArrayList<DialogueCard>();
        if (FIRSTRUN){
            getJSON();
            FIRSTRUN = false;
        }
    }

    /**
     * Get Json and put it in a list
     * This list is passed through datasource class
     */
    public void getJSON(){
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("Dialoguecard");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String theme = jo_inside.getString("theme").toString();
                String level = jo_inside.getString("level").toString();
                String title = jo_inside.getString("title").toString();
                String competence = jo_inside.getString("competence").toString();
                String resultText = jo_inside.getString("resultText").toString();
                String teacherText = jo_inside.getString("teacherText").toString();
                String questionText = jo_inside.getString("questionText").toString();

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("theme", theme);
                m_li.put("level", level);
                m_li.put("title", title);
                m_li.put("competence", competence);
                m_li.put("resultText", resultText);
                m_li.put("teacherText", teacherText);
                m_li.put("questionText", questionText);

                DialogueCard card = new DialogueCard(level, theme, title, competence, resultText, teacherText, questionText);
                mDialoguecards.add(card);
                formList.add(m_li);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new DataSource(mDialoguecards);
    }

    /**
     * Get Json from the assets folder
     * @return Json String
     */
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("junior-leraar-v2.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * Get list in case the list in datasource class wasn't correctly loaded
     * @return list
     */
    public List<DialogueCard> getmDialoguecards(){
        return mDialoguecards;
    }

}
