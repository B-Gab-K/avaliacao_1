package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityGerenciarProgramas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_programas);

        RecyclerView recyclerView = findViewById(R.id.recycler_admin_programas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Programa> programaList = new ArrayList<>();
        programaList.add(new Programa("Zumba na Praça", "20", "Quarta às 19:00"));
        programaList.add(new Programa("Yoga ao Ar Livre", "15", "Sábado às 08:00"));
        programaList.add(new Programa("Futebol Comunitário", "10", "Sábado às 18:00"));

        ProgramaAdminAdapter adapter = new ProgramaAdminAdapter(programaList);
        recyclerView.setAdapter(adapter);

        BottomNavigationView adminNav = findViewById(R.id.adminBottomNavigation);
        adminNav.post(() -> adminNav.setSelectedItemId(R.id.nav_admin_gerenciar));

        adminNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_admin_painel) {
                startActivity(new Intent(this, ActivityEstatisticasAdmin.class));
                return true;
            } else if (id == R.id.nav_admin_gerenciar) {
                return true;
            } else if (id == R.id.nav_admin_novo) {
                startActivity(new Intent(this, ActivityCadastrarPrograma.class));
                return true;
            }
            return false;
        });
    }
}