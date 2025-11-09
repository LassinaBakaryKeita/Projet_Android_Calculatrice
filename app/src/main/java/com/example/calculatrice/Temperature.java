package com.example.calculatrice;

import android.annotation.SuppressLint;
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

public class Temperature extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnVirgule,btnPlusMoins;
    Button btnC, btnEffacer;

    TextView ValeurEntree,ValeurConvertie;

    Spinner UniteDepart,UniteArrive;

    public void ajouterChiffre(String chiffre){
        String tmp=ValeurEntree.getText().toString();
        if(tmp.equals("0")){
            ValeurEntree.setText(chiffre);
        }else{
            String concatenation=tmp+chiffre;
            ValeurEntree.setText(concatenation);
        }
    }

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperature);

        setTitle(getString(R.string.nomActiviteTemperature));

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
        btnPlusMoins=findViewById(R.id.btnPlusMoins);

        btnC=findViewById(R.id.btnC);
        btnEffacer=findViewById(R.id.btnEffacer);

        ValeurEntree=findViewById(R.id.ValeurEntree);
        ValeurConvertie=findViewById(R.id.ValeurConvertie);

        UniteArrive=findViewById(R.id.UniteSortie);
        UniteDepart=findViewById(R.id.UniteEntree);


        UniteDepart.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                affichageValeurArrive(); // Actualiser l'affichage
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
                // Rien à faire ici
            }
        });

        UniteArrive.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
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


        btnPlusMoins.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = ValeurEntree.getText().toString().trim();

                // Conversion de la chaîne en nombre
                double valeur = Double.parseDouble(resultatText.replace(',','.'));

                if(valeur==0.0){
                    return;
                }

                // Multiplié la valeur par moins -1
                double valeurMultiplieParMoinsUn=valeur*(-1);


                // Affichage du résultat (format simplifié)
                if (valeurMultiplieParMoinsUn - (int) valeurMultiplieParMoinsUn== 0) {
                    ValeurEntree.setText(String.valueOf((int) valeurMultiplieParMoinsUn));
                } else {
                    ValeurEntree.setText(String.valueOf(valeurMultiplieParMoinsUn));
                }

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

    // Methode pour recuperer l'unité de depart choisi par l'utilisateur
    public String getUniteDepart(){
       return UniteDepart.getSelectedItem().toString();

    }

    // Methode pour recuperer l'unité d'arrivée choisi par l'utilisateur
    public String getUniteArrive(){
        return UniteArrive.getSelectedItem().toString();

    }

    // Methode pour convertir la valeur de depart à la valeur d'arrivée en fonction de l'unité de depart et d'arrivée
    public double ConversionTemperature(){
        String uniteDepart=getUniteDepart();
        String uniteArrivee=getUniteArrive();

        //2. Récupérer la valeur entrée
        double valeur = Double.parseDouble(ValeurEntree.getText().toString().replace(",", "."));

        double valeurEnCelsius;

        // Étape 1 : Convertir vers Celsius
        switch (uniteDepart) {
            case "Celsius":
                valeurEnCelsius = valeur;
                break;
            case "Fahrenheit":
                valeurEnCelsius = (valeur - 32) * 5 / 9;
                break;
            case "Kelvin":
                valeurEnCelsius = valeur - 273.15;
                break;
            default:
                valeurEnCelsius = valeur; // par précaution
                break;
        }

        double resultat;

        // Étape 2 : Convertir de Celsius vers l’unité d’arrivée
        switch (uniteArrivee) {
            case "Celsius":
                resultat = valeurEnCelsius;
                break;
            case "Fahrenheit":
                resultat = valeurEnCelsius * 9 / 5 + 32;
                break;
            case "Kelvin":
                resultat = valeurEnCelsius + 273.15;
                break;
            default:
                resultat = valeurEnCelsius;
                break;
        }

        return resultat;
    }


    public void affichageValeurArrive(){
        double resultat=ConversionTemperature();
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
           /* Intent intent=new Intent(this, Temperature.class);
            startActivity(intent);*/
            return true;
        }else{
            Intent intent=new Intent(this, Temps.class);
            startActivity(intent);
            return  true;
        }
    }
}