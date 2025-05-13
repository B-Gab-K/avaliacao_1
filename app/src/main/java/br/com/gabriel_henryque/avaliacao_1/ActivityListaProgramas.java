package br.com.gabriel_henryque.avaliacao_1;

import android.os.Bundle;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaProgramas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_programas);

        RecyclerView recyclerView = findViewById(R.id.recycler_programa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Programa> programaList = new ArrayList<>();
        programaList.add(new Programa("Zumba na Praça", "20", "Quarta às 19:00"));
        programaList.add(new Programa("Yoga ao Ar Livre", "15", "Sábado às 08:00"));
        programaList.add(new Programa("Futebol Comunitário", "10", "Sábado às 18:00"));

        ProgramaAdapter adapter = new ProgramaAdapter(programaList);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setSelectedItemId(R.id.nav_programas);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_inicio) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_programas) {
                return true;
            } else if (id == R.id.nav_inscricoes) {
                startActivity(new Intent(this, ActivityInscricoes.class));
                return true;
            }
            return false;
        });
    }
}