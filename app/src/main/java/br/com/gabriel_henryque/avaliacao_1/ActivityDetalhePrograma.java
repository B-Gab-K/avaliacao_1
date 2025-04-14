package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDetalhePrograma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_programa);

        Intent intent = getIntent();

        TextView textTitulo = findViewById(R.id.textTituloPrograma);
        TextView textVagas = findViewById(R.id.textVagas);

        String nome = intent.getStringExtra("nomePrograma");
        String vagas = intent.getStringExtra("vagas");

        textTitulo.setText(nome);
        textVagas.setText("Vagas disponíveis: " + vagas);
    }
}