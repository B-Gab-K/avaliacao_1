package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityAdminInicio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_inicio);

        BottomNavigationView adminNav = findViewById(R.id.adminBottomNavigation);
        adminNav.post(() -> adminNav.setSelectedItemId(R.id.nav_admin_painel));

        adminNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_admin_painel) {
                return true;
            } else if (id == R.id.nav_admin_gerenciar) {
                startActivity(new Intent(this, ActivityGerenciarProgramas.class));
                return true;
            } else if (id == R.id.nav_admin_novo) {
                startActivity(new Intent(this, ActivityCadastrarPrograma.class));
                return true;
            }

            return false;
        });
    }
}