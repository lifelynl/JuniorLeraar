package com.hva.tsse.juniorleraar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hva.tsse.juniorleraar.data.DataSource;
import com.hva.tsse.juniorleraar.data.Firebase;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Home extends AppCompatActivity {

    // Vars
    private Button mDida;
    private Button mColle;
    private Button mPeda;

    private static boolean FIRSTRUN = true;
    private final String TAG = "HOMECLASS";
    private List<DialogueCard> mDialoguecards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (FIRSTRUN) {
            Firebase mFirebase = new Firebase();
            mFirebase.getData();
            Log.w("FIRSTRUN", "FIRSTRUN");
            FIRSTRUN = false;
        }

        //Get JSON values from JSON file
        if (FIRSTRUN) {
            mDialoguecards = new ArrayList<>();
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

                    mDialoguecards.add(new DialogueCard(theme, level, title, competence, resultText, teacherText, questionText));
                    formList.add(m_li);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            FIRSTRUN = false;
            new DataSource(mDialoguecards);
            Log.w(TAG, mDialoguecards.toString());
        }
        // findViews
        Button mDidaBtn = (Button) findViewById(R.id.btn_didactisch);
        Button mColleBtn = (Button) findViewById(R.id.btn_collegiaal);
        Button mPedaBtn = (Button) findViewById(R.id.btn_pedagogisch);


        // Nav
        mDidaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent didaIntent = new Intent(Home.this, Dida.class);
                Home.this.startActivity(didaIntent);
            }
        });

        mColleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colleIntent = new Intent(Home.this, Colle.class);
                Home.this.startActivity(colleIntent);
            }
        });

        mPedaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pedaIntent = new Intent(Home.this, Peda.class);
                Home.this.startActivity(pedaIntent);
            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("junior-leraar.json");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                item.setIcon(R.drawable.infoicon);
                Intent intent = new Intent(Home.this, Info.class);
                startActivity(intent);
                return true;
    }
}
