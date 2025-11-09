package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Temps extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnVirgule;
    Button btnC, btnEffacer;

    TextView ValeurEntree,ValeurConvertie;

    Spinner TempsDepart, TempsArrive;

    public void ajouterChiffre(String chiffre){
        String tmp=ValeurEntree.getText().toString();
        if(tmp.equals("0")){
            ValeurEntree.setText(chiffre);
        }else{
            String concatenation=tmp+chiffre;
            ValeurEntree.setText(concatenation);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_temps);

        setTitle(getString(R.string.nomActiviteTemps));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison entre les variables Java et les boutons XML

        btn0= findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);


        btnVirgule=findViewById(R.id.btnVirgule);


        btnC=findViewById(R.id.btnC);
        btnEffacer=findViewById(R.id.btnEffacer);

        ValeurEntree=findViewById(R.id.ValeurEntree);
        ValeurConvertie=findViewById(R.id.ValeurConvertie);

        TempsArrive=findViewById(R.id.TempsSortie);
        TempsDepart=findViewById(R.id.TempsEntree);

        TempsDepart.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                affichageValeurArrive(); // Actualiser l'affichage
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
                // Rien à faire ici
            }
        });

        TempsArrive.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                affichageValeurArrive(); // Actualiser l'affichage
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
                // Rien à faire ici
            }
        });


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("0");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("1");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("2");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("3");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });



        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("4");
                affichageValeurArrive();  // Actualiser l'affichage
            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("5");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });



        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("6");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });


        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("7");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });


        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("8");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });



        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("9");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        });


        btnVirgule.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText=ValeurEntree.getText().toString();
                if(!resultatText.contains(",")){
                    String concatenation=resultatText+ ",";
                    ValeurEntree.setText(concatenation);
                }
            }
        }));


        btnC.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValeurEntree.setText("0");
                affichageValeurArrive(); // Actualiser l'affichage
            }
        }));





        btnEffacer.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = ValeurEntree.getText().toString();

                if(!resultatText.isEmpty()){
                    // Supprimer le dernier caractère
                    resultatText = resultatText.substring(0, resultatText.length() - 1);

                    // Si après suppression il ne reste rien, on affiche 0
                    if (resultatText.isEmpty()) {
                        ValeurEntree.setText("0");
                    } else {
                        ValeurEntree.setText(resultatText);
                    }
                }else{
                    ValeurEntree.setText("0");
                }

                affichageValeurArrive(); // Actualiser l'affichage
            }
        }));
    }


    // Methode pour recuperer le temps  de depart choisi par l'utilisateur
    public String getTempsDepart(){
        return TempsDepart.getSelectedItem().toString();

    }

    // Methode pour recuperer le temps d'arrivée choisi par l'utilisateur
    public String getTempsArrive(){
        return TempsArrive.getSelectedItem().toString();

    }


    public double ConversionTemps() {
        String uniteDepart = getTempsDepart();
        String uniteArrive = getTempsArrive();

        //  Récupérer la valeur entrée
        double valeur = Double.parseDouble(ValeurEntree.getText().toString().replace(",", "."));

        double valeurEnSemaine; // unité de référence : semaine

        // Étape 1 : Convertir de l’unité de départ → vers semaine
        switch (uniteDepart) {
            case "Semaine(s)":
                valeurEnSemaine = valeur;
                break;
            case "Jour(s)":
                valeurEnSemaine = valeur / 7;
                break;
            case "Heure(s)":
                valeurEnSemaine = valeur / (7 * 24);
                break;
            case "Minute(s)":
                valeurEnSemaine = valeur / (7 * 24 * 60);
                break;
            case "Seconde(s)":
                valeurEnSemaine = valeur / (7 * 24 * 60 * 60);
                break;
            default:
                valeurEnSemaine = valeur;
                break;
        }

        double resultat;

        //  Étape 2 : Convertir de semaine → vers l’unité d’arrivée
        switch (uniteArrive) {
            case "Semaine(s)":
                resultat = valeurEnSemaine;
                break;
            case "Jour(s)":
                resultat = valeurEnSemaine * 7;
                break;
            case "Heure(s)":
                resultat = valeurEnSemaine * 7 * 24;
                break;
            case "Minute(s)":
                resultat = valeurEnSemaine * 7 * 24 * 60;
                break;
            case "Seconde(s)":
                resultat = valeurEnSemaine * 7 * 24 * 60 * 60;
                break;
            default:
                resultat = valeurEnSemaine;
                break;
        }

        return resultat;
    }


    public void affichageValeurArrive(){
        double resultat= ConversionTemps();
        if(resultat-(int)resultat==0){
            int resultatEntier=(int)resultat;
            ValeurConvertie.setText(String.valueOf(resultatEntier));
        }else{
            ValeurConvertie.setText(String.valueOf(resultat));
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id== R.id.standard){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            return  true;
        }else if(id== R.id.temperature){
            Intent intent=new Intent(this, Temperature.class);
            startActivity(intent);
            return true;
        }else{
            /*Intent intent=new Intent(this, Temps.class);
            startActivity(intent);*/
            return  true;
        }
    }

}