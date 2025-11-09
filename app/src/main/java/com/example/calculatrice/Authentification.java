package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Authentification extends AppCompatActivity {
    // La declaration des variables
    EditText etLogin, etPassword;  // pour les editeurs de texte
    Button btnValidate;  // pour le bouton de validation
    String Login;   // pour le login
    String Password;  // pour le password

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authentification);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Les EditText
        etLogin=findViewById(R.id.editTextLogin);
        etPassword=findViewById(R.id.editTextPassword);

        // Button
        btnValidate=findViewById(R.id.btnValidation);

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login=etLogin.getText().toString().trim();
                Password=etPassword.getText().toString();

                if(Login.equalsIgnoreCase("Lassina") && Password.equals("123")){
                    intent=new Intent( Authentification.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    String message=getString(R.string.toastAuthentification);
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}