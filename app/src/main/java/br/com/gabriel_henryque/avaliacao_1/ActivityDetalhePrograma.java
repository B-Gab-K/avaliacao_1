package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.HashSet;
import java.util.Set;

public class ActivityDetalhePrograma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_programa);

        Intent intent = getIntent();

        TextView textTitulo = findViewById(R.id.textTituloPrograma);
        TextView textVagas = findViewById(R.id.textVagas);
        TextView textData = findViewById(R.id.textData);
        Button btnInscrever = findViewById(R.id.btnInscrever);

        String nome = intent.getStringExtra("nomePrograma");
        String vagas = intent.getStringExtra("vagas");
        String data = intent.getStringExtra("data");

        textTitulo.setText(nome);
        textVagas.setText("Vagas disponíveis: " + vagas);
        textData.setText("Data: " + data);

        btnInscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnInscrever.setText("Inscrito");
                btnInscrever.setEnabled(false);
                btnInscrever.setBackgroundTintList(
                        ContextCompat.getColorStateList(ActivityDetalhePrograma.this, android.R.color.darker_gray)
                );

                SharedPreferences prefs = getSharedPreferences("inscricoes", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                String inscricao = nome + " - Vagas disponíveis: " + vagas + " - Data: " + data;

                Set<String> inscricoes = prefs.getStringSet("lista", new HashSet<>());
                inscricoes = new HashSet<>(inscricoes); // precisa ser mutável
                inscricoes.add(inscricao);

                editor.putStringSet("lista", inscricoes);
                editor.apply();

                Toast.makeText(ActivityDetalhePrograma.this, "Inscrição salva!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}