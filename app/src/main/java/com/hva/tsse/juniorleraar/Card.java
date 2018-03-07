package com.hva.tsse.juniorleraar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Card extends AppCompatActivity {
    public boolean bekwaam = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selectCard();
    }
    public void displayCard(String result, String indicators, String reflection){
        setResult(result);
        setIndicators(indicators);
        setReflection(reflection);
    }

    public void setResult(String result){
        TextView textview = (TextView) findViewById(R.id.result);
        textview.setText(result);
    }
    public void setIndicators(String indicators){
        TextView textview = (TextView) findViewById(R.id.indicators);
        textview.setText(indicators);
    }
    public void setReflection(String reflection){
        TextView textview = (TextView) findViewById(R.id.reflection);
        textview.setText(reflection);
    }
    public void setBekwaam(){
        bekwaam = true;
        selectCard();
    }
    public void setStartBekwaam(){
        bekwaam = false;
        selectCard();
    }
    public void selectCard(){
        if (bekwaam){
            //example strings. Here you select bekwame kaart and it's Strings
            String cardNumber = "C2";
            String cardTitle = "Delen en Deelnemen";
            String result= "De leraar levert een oplossingsgericht bijdrage aan algemene taken in het team en aan de onderwijskundige en pedagogische ontwikkeling van de school.";
            String indicators = "• Is op de hoogte van relevante kenmerken van de school en de leerlingen\n" +
                    "                \n• Wisselt met collega’s (innovatieve) kennis en informatie uit\n" +
                    "                \n• Wisselt met collega’s kennis en informatie uit over leerlingen\n" +
                    "                \n• Vervult een actieve rol in teamoverleg en brengt op eigen initiatief onderwerpen in\n" +
                    "                \n• Zoekt stelselmatig naar uitwisseling met collega’s om in samenwerking lessen te optimaliseren\n" +
                    "                \n• Treedt collega’s respectvol tegemoet en houdt rekening met verschillende achtergronden en talenten\n" +
                    "                \n• Stelt teambelang boven eigen belang";
            String reflection = "• Hoe ziet werken in teamverband er voor jou uit?\n" +
                    "\n• Welke meerwaarde ervaar je bij het werken in teamverband in jouw school?\n" +
                    "\n• Ben je tevreden over jouw inbreng in het team?\n" +
                    "\n• Heb je feedback van je collega’s gekregen op je handelen in de klas? Waaruit bestond\n" +
                    "die feedback en wat heb je daarmee gedaan?\n" +
                    "\n• Wat heb jij van je teamgenoten nodig om goed in een team te kunnen werken? Krijg\n" +
                    "je dat, en zo niet, hoe maak je dat bespreekbaar?\n" +
                    "\n• Op welke manier lever je vanuit eerder verworven competenties een bijdrage aan de\n" +
                    "ontwikkeling van de school?";
            displayCard(result, indicators, reflection);
            this.setTitle(cardNumber + "  " +cardTitle);
        }
        if(!bekwaam){
            //example strings here you select startbekwame kaart and it's Strings
            String result= "result 2";
            String indicators = "indicator 2";
            String reflection = "reflection 2";
            displayCard(result, indicators, reflection);
        }
    }
}

