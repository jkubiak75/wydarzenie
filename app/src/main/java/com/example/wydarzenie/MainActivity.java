package com.example.wydarzenie;

import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.text.InputType;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText haslo;
    private Button ButtonPolubienia;
    private Button Buttonusun;
    private Button zapisz;
    private Button zobacz;
    private int polubieniailosc = 0;
    private TextView polubienia;
    private EditText haslo2;
    private TextView tekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        haslo = findViewById(R.id.haslo);
        haslo2 = findViewById(R.id.haslo2);
        ButtonPolubienia = findViewById(R.id.ButtonPolubienia);
        Buttonusun = findViewById(R.id.Buttonusun);
        zapisz = findViewById(R.id.zapisz);
        zobacz = findViewById(R.id.zobacz);
        polubienia = findViewById(R.id.polubienia);
        tekst = findViewById(R.id.tekst);

        ButtonPolubienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polubieniailosc++;
               polubienia.setText(polubieniailosc + " polubień");
            }
        });

        Buttonusun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (polubieniailosc > 0) {
                    polubieniailosc--;
                    polubienia.setText(polubieniailosc + " polubień");
                }
            }
        });

        haslo.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        haslo2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emaill = email.getText().toString().trim();
                String hasloo = haslo.getText().toString().trim();
                String hasloo2 = haslo2.getText().toString().trim();

                if (!emaill.contains("@")) {
                    tekst.setText("Nieprawidłowy email");
                }
                else if (!hasloo.equals(hasloo2)) {
                    tekst.setText("Hasła się różnią");
                }
                else {
                    tekst.setText("Zarejestrowano " +emaill);
                }
            }

        });

        zobacz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String emaill = email.getText().toString().trim();

                if (!emaill.contains("@")) {
                    tekst.setText("Nie podano zadnego uzytkownika");
                }
              else {
                    tekst.setText(emaill);
                }
            }
        });

    }
}