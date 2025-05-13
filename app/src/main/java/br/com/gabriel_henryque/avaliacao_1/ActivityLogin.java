package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {

    EditText edtEmail, edtSenha;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtEmail.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();

                if (usuario.equalsIgnoreCase("gabriel@email.com") && senha.equals("123")) {
                    // Logar como ADMIN
                    startActivity(new Intent(ActivityLogin.this, ActivityEstatisticasAdmin.class));
                } else {
                    // Logar como CIDADÃO
                    startActivity(new Intent(ActivityLogin.this, MainActivity.class));
                }

                finish();
            }
        });
    }
}