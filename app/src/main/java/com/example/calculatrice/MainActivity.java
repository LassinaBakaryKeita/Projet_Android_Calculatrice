package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // Declaration des variables boutons
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    Button btnAddition,btnMoins,btnMultiplication,btnDivision,btnEgale;

    Button btnPourcentage,btnCE,btnC,btnEffacer,btnInverse,btnAuCarre,btnRacineCarre,btnPlusMoins,btnVirgule;

    // Declaration des variables textes
    TextView textViewResutat,textViewOperation;

    Snackbar  snackbar;

    LinearLayout linearLayout;

    public void ajouterChiffre(String chiffre){
        String tmp=textViewResutat.getText().toString();
        if(tmp.equals("0")){
            textViewResutat.setText(chiffre);
        }else{
            String concatenation=tmp+chiffre;
            textViewResutat.setText(concatenation);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.nomActiviteCalculatrice));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison entre les variables boutons numériques et les boutons XML

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

        // Liaison entre les variables boutons d'opérateurs et les boutons XML
        btnAddition=findViewById(R.id.btnAddition);
        btnMoins=findViewById(R.id.btnMoins);
        btnMultiplication=findViewById(R.id.btnMultiplication);
        btnDivision=findViewById(R.id.btnDivision);





        //Liaison entre les variables textes et les textes XML
        textViewResutat=findViewById(R.id.Resultat);
        textViewOperation=findViewById(R.id.Operations);


        //Liaison entre les variables symboliques ,les fonctions et les elements XML
        btnEgale=findViewById(R.id.btnEgale);
        btnVirgule=findViewById(R.id.btnVirgule);
        btnPourcentage=findViewById(R.id.btnPourcentage);
        btnCE=findViewById(R.id.btnCE);
        btnC=findViewById(R.id.btnC);
        btnEffacer=findViewById(R.id.btnEffacer);
        btnInverse=findViewById(R.id.btnInverse);
        btnAuCarre=findViewById(R.id.btnAuCarree);
        btnRacineCarre=findViewById(R.id.btnRacineCarree);
        btnPlusMoins=findViewById(R.id.btnPlusMoins);


        linearLayout=findViewById(R.id.main);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("7");
            }
        });


        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterChiffre("9");
            }
        });


        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Operation=textViewResutat.getText().toString()+ " +";
                textViewOperation.setText(Operation);
                textViewResutat.setText("0");
            }
        });

        btnMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Operation=textViewResutat.getText().toString()+ " -";
                textViewOperation.setText(Operation);
                textViewResutat.setText("0");
            }
        });


        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Operation=textViewResutat.getText().toString()+ " x";
                textViewOperation.setText(Operation);
                textViewResutat.setText("0");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Operation=textViewResutat.getText().toString()+ " /";
                textViewOperation.setText(Operation);
                textViewResutat.setText("0");
            }
        });


        btnEgale.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operationText = textViewOperation.getText().toString();
                String resultatText = textViewResutat.getText().toString();

                // Vérification avant toute manipulation
                if (operationText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Aucune opération à calculer", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Vérifier que la chaîne se termine bien par un opérateur
                if (operationText.length() < 3) {
                    Toast.makeText(MainActivity.this, "Format d’opération invalide", Toast.LENGTH_SHORT).show();
                    return;
                }

                int index = operationText.length() - 1;
                String Operateur = String.valueOf(operationText.charAt(index));
                int end = operationText.length() - 2;

                try {
                    // Prétraitement des valeurs avant conversion
                    String avant = operationText.substring(0, end).trim().replace(',', '.');
                    String apres = resultatText.trim().replace(',', '.');

                    // Conversion du symbole % en valeur numérique (divisé par 100)
                    if (avant.contains("%")) {
                        avant = avant.replace("%", "");
                        double val = Double.parseDouble(avant);
                        avant = String.valueOf(val / 100);
                    }
                    if (apres.contains("%")) {
                        apres = apres.replace("%", "");
                        double val = Double.parseDouble(apres);
                        apres = String.valueOf(val / 100);
                    }

                    double nombreAvant = Double.parseDouble(avant);
                    double nombreApres = Double.parseDouble(apres);
                    double resultat;

                    //Avant d'afficher le resultat on ajoute la valeur après dans textViewOperation
                    String contenation=operationText+ " " +resultatText+" =";
                    textViewOperation.setText(contenation);

                    switch (Operateur) {
                        case "+":
                            resultat = nombreAvant + nombreApres;

                            if(resultat-(int)resultat==0){
                                int resultatEntier=(int)resultat;
                                textViewResutat.setText(String.valueOf(resultatEntier));
                            }else{
                                textViewResutat.setText(String.valueOf(resultat));
                            }

                            break;
                        case "-":
                            resultat = nombreAvant - nombreApres;
                            if(resultat-(int)resultat==0){
                                int resultatEntier=(int)resultat;
                                textViewResutat.setText(String.valueOf(resultatEntier));
                            }else{
                                textViewResutat.setText(String.valueOf(resultat));
                            }
                            break;
                        case "x":
                            resultat = nombreAvant * nombreApres;
                            if(resultat-(int)resultat==0){
                                int resultatEntier=(int)resultat;
                                textViewResutat.setText(String.valueOf(resultatEntier));
                            }else{
                                textViewResutat.setText(String.valueOf(resultat));
                            }
                            break;
                        case "/":
                            if (nombreApres == 0) {
                                textViewResutat.setText("Math Error");
                            } else {
                                resultat = nombreAvant / nombreApres;
                                if(resultat-(int)resultat==0){
                                    int resultatEntier=(int)resultat;
                                    textViewResutat.setText(String.valueOf(resultatEntier));
                                }else{
                                    textViewResutat.setText(String.valueOf(resultat));
                                }
                            }
                            break;
                    }
                } catch (Exception e) {
                    textViewResutat.setText("Math Error");
                }
            }
        }));

        btnVirgule.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText=textViewResutat.getText().toString();
                if(!resultatText.contains(",")){
                    String contenation=resultatText+ ",";
                    textViewResutat.setText(contenation);
                }
            }
        }));

        btnEffacer.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = textViewResutat.getText().toString();

                if(!resultatText.isEmpty()){
                    // Supprimer le dernier caractère
                    resultatText = resultatText.substring(0, resultatText.length() - 1);

                    // Si après suppression il ne reste rien, on affiche 0
                    if (resultatText.isEmpty()) {
                        textViewResutat.setText("0");
                    } else {
                        textViewResutat.setText(resultatText);
                    }
                }else{
                    textViewResutat.setText("0");
                }
            }
        }));

        btnC.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResutat.setText("0");
                textViewOperation.setText("");
            }
        }));

        btnCE.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operationText = textViewOperation.getText().toString();
                if(!operationText.isEmpty()){
                    //Calcul du nombre d'occurrence
                    int nbrEspace=0;

                    for(int i=0;i<operationText.length();i++){
                        if(operationText.charAt(i)==' '){
                            nbrEspace++;
                        }
                    }

                    if(nbrEspace==3){
                        String[] tabOperation=operationText.split(" ");
                        int nbCaracteresARetirer=tabOperation[2].length()+3;//3=1(espace)+1(espace)+1(symbole =)
                        int end=operationText.length()-nbCaracteresARetirer;

                        operationText=operationText.substring(0,end);
                        textViewOperation.setText(operationText);
                        textViewResutat.setText("0");
                    }else{
                        Toast.makeText(MainActivity.this, "Rien à effacer, le dernier résultat est déjà affiché !", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Aucune saisie à effacer", Toast.LENGTH_SHORT).show();
                }

            }
        }));

        btnPourcentage.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = textViewResutat.getText().toString();
                String contenation=resultatText+ "%";
                textViewResutat.setText(contenation);
            }
        }));

        btnInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String resultatText = textViewResutat.getText().toString().trim();

                    // Conversion de la chaîne en nombre
                    double valeur = Double.parseDouble(resultatText.replace(',','.'));

                    // Vérification division par zéro
                    if (valeur == 0) {
                        textViewResutat.setText("Math Error");
                        textViewOperation.setText("1 / 0 =");
                        return;
                    }

                    // Calcul de l’inverse
                    double inverse = 1 / valeur;

                    // Affichage de l’opération
                    String concatenation = "1 / " + resultatText + " =";
                    textViewOperation.setText(concatenation);

                    // Affichage du résultat (format simplifié)
                    if (inverse - (int) inverse == 0) {
                        textViewResutat.setText(String.valueOf((int) inverse));
                    } else {
                        textViewResutat.setText(String.valueOf(inverse));
                    }

            }

        });

        btnAuCarre.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = textViewResutat.getText().toString().trim();

                // Conversion de la chaîne en nombre
                double valeur = Double.parseDouble(resultatText.replace(',','.'));

                //Calcul de la valeur au carré
                double valeurAuCarre=valeur*valeur;


                // Affichage du résultat (format simplifié)
                if (valeurAuCarre - (int) valeurAuCarre == 0) {
                    textViewResutat.setText(String.valueOf((int) valeurAuCarre));
                } else {
                    textViewResutat.setText(String.valueOf(valeurAuCarre));
                }

                String concatenation = "squarre( " + resultatText + " )=";
                textViewOperation.setText(concatenation);
            }
        }));

        btnRacineCarre.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = textViewResutat.getText().toString().trim();

                // Conversion de la chaîne en nombre
                double valeur = Double.parseDouble(resultatText.replace(',','.'));

                //Calcul de la racine
                double valeurRacine=Math.sqrt(valeur);

                // Affichage du résultat (format simplifié)
                if (valeurRacine - (int) valeurRacine == 0) {
                    textViewResutat.setText(String.valueOf((int) valeurRacine));
                } else {
                    textViewResutat.setText(String.valueOf(valeurRacine));
                }

                String concatenation = "sqrt( " + resultatText + " )=";
                textViewOperation.setText(concatenation);
            }
        }));

        btnPlusMoins.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultatText = textViewResutat.getText().toString().trim();

                // Conversion de la chaîne en nombre
                double valeur = Double.parseDouble(resultatText.replace(',','.'));

                if(valeur==0.0){
                    return;
                }

                // Multiplié la valeur par moins -1
                double valeurMultiplieParMoinsUn=valeur*(-1);


                // Affichage du résultat (format simplifié)
                if (valeurMultiplieParMoinsUn - (int) valeurMultiplieParMoinsUn== 0) {
                    textViewResutat.setText(String.valueOf((int) valeurMultiplieParMoinsUn));
                } else {
                    textViewResutat.setText(String.valueOf(valeurMultiplieParMoinsUn));
                }

                String concatenation = "negate( " + resultatText + " )=";
                textViewOperation.setText(concatenation);

            }
        }));


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

           /* Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);*/
            return  true;
        }else if(id== R.id.temperature){
            Intent intent=new Intent(this, Temperature.class);
            startActivity(intent);
            return true;
        }else{
            Intent intent=new Intent(this, Temps.class);
            startActivity(intent);
            return  true;
        }
    }
}


