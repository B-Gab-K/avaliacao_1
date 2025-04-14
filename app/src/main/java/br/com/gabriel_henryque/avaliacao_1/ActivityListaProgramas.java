package br.com.gabriel_henryque.avaliacao_1;

import android.os.Bundle;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityListaProgramas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_programas);

        Intent intent = new Intent(ActivityListaProgramas.this, ActivityDetalhePrograma.class);
    }
}