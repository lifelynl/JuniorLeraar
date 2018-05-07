package com.hva.tsse.juniorleraar.data;

import android.content.Context;
import android.util.Log;

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

    public Json(Context context){
        this.context = context;
        if (FIRSTRUN){
            getJSON();
            FIRSTRUN = false;
        }
    }

    public Json(){

    }

    public void getJSON(){
        try {
            Log.w(TAG, "BEGIN JSON");
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("Dialoguecard");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;
            Log.w(TAG, obj.toString());

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.w(TAG, jo_inside.getString("title"));

                String theme = jo_inside.getString("theme");
                String level = jo_inside.getString("level");
                String title = jo_inside.getString("title");
                String competence = jo_inside.getString("competence");
                String resultText = jo_inside.getString("resultText");
                String teacherText = jo_inside.getString("teacherText");
                String questionText = jo_inside.getString("questionText");

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("theme", theme);
                m_li.put("level", level);
                m_li.put("title", title);
                m_li.put("competence", competence);
                m_li.put("resultText", resultText);
                m_li.put("teacherText", teacherText);
                m_li.put("questionText", questionText);

                DialogueCard card = new DialogueCard(theme, level, title, competence, resultText, teacherText, questionText)
                mDialoguecards.add(card);
                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new DataSource(mDialoguecards);
        Log.w(TAG, mDialoguecards.toString());
        Log.w(TAG + "LENGTE", String.valueOf(mDialoguecards.size()));
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("junior-leraar.json");
            Log.w(TAG, is.toString());
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

    public List<DialogueCard> getmDialoguecards(){
        return mDialoguecards;
    }

}
