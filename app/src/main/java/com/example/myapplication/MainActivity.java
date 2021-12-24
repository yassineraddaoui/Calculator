package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String calculator(String string) throws ScriptException {
        double result = -1;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(string);
        } catch (ScriptException e) {
            e.printStackTrace();
            return "Error";
        }
        return String.valueOf(result);
    }

    public void clickEgal(View view) throws ScriptException {
        TextView tx =findViewById(R.id.formule);
        TextView rs =findViewById(R.id.resultat);
        rs.setText(calculator(String.valueOf(tx.getText())));
    }



    public void change(View view ,String x){
        TextView tx = findViewById(R.id.formule);
        TextView rs = findViewById(R.id.resultat);
        if(tx.getText().equals("Calculating"))
            tx.setText("");
        if(x.equals("")){
            rs.setText("");
            tx.setText("");
        }
        else if (x.equals("-1")) {
            if(tx.getText().length()<=0)
                tx.setText("Erreur .");
            tx.setText(tx.getText().toString().toCharArray(), 0, tx.getText().length() - 1);
        }
        else
            tx.setText(tx.getText()+x);
    }
    public void click1(View view){ change(view,"1"); }
    public void click2(View view){ change(view,"2"); }
    public void click3(View view){ change(view,"3"); }
    public void click4(View view){ change(view,"4"); }
    public void click5(View view){ change(view,"5"); }
    public void click6(View view){ change(view,"6"); }
    public void click7(View view){ change(view,"7"); }
    public void click8(View view){ change(view,"8"); }
    public void click9(View view){ change(view,"9"); }
    public void clickAc(View view) { change(view,"");  }
    public void clickAdd(View view) { change(view,"+"); }
    public void clickSw(View view) { }
    public void click0(View view) { change(view,"0"); }
    public void clickDot(View view) { change(view,"."); }
    public void clickDiv(View view) { change(view,"/"); }
    public void clickSous(View view) {change(view,"-"); }
    public void clickMod(View view) { change(view,"%"); }
    public void delete(View view) { change(view,"-1"); }
    public void clickMulti(View view) { change(view,"*"); }
}