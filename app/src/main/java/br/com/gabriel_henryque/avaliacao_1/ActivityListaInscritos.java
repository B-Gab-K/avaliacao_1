package br.com.gabriel_henryque.avaliacao_1;

import android.os.Bundle;

import br.com.gabriel_henryque.avaliacao_1.ProgramaAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaInscritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_inscritos);

        RecyclerView lista = findViewById(R.id.recyclerProgramas);
        lista.setLayoutManager(new LinearLayoutManager(this));

        List<Programa> programaList = new ArrayList<>();

        programaList.add(new Programa("Zumba na Praça", "20"));

        ProgramaAdapter adapter = new ProgramaAdapter(programaList);
        lista.setAdapter(adapter);
    }
}