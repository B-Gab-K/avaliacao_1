package br.com.gabriel_henryque.avaliacao_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    TextView textTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTitulo = findViewById(R.id.textTitulo);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setSelectedItemId(R.id.nav_inicio);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_inicio) {
                return true;

            } else if (id == R.id.nav_programas) {
                startActivity(new Intent(MainActivity.this, ActivityListaProgramas.class));
                return true;

            } else if (id == R.id.nav_inscricoes) {
                startActivity(new Intent(MainActivity.this, ActivityInscricoes.class));
                return true;
            }

            return false;
        });
    }
}