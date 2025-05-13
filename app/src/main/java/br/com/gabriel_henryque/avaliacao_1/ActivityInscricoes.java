package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActivityInscricoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricoes);

        RecyclerView recyclerView = findViewById(R.id.recycler_inscricoes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences prefs = getSharedPreferences("inscricoes", MODE_PRIVATE);
        Set<String> inscricoesSet = prefs.getStringSet("lista", new HashSet<>());
        List<String> inscricoes = new ArrayList<>(inscricoesSet);

        InscricaoAdapter adapter = new InscricaoAdapter(inscricoes);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setSelectedItemId(R.id.nav_inscricoes);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_inicio) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_programas) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_inscricoes) {
                startActivity(new Intent(this, ActivityInscricoes.class));
                return true;
            }
            return false;
        });
    }
}