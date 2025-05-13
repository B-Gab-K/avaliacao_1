package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityCadastrarPrograma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_programa);

        BottomNavigationView adminNav = findViewById(R.id.adminBottomNavigation);
        adminNav.setSelectedItemId(R.id.nav_admin_novo);

        adminNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_admin_painel) {
                startActivity(new Intent(this, ActivityEstatisticasAdmin.class));
                return true;
            } else if (id == R.id.nav_admin_gerenciar) {
                startActivity(new Intent(this, ActivityGerenciarProgramas.class));
                return true;
            } else if (id == R.id.nav_admin_novo) {
                return true;
            }

            return false;
        });
    }
}