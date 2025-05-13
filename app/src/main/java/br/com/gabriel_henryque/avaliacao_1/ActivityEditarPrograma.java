package br.com.gabriel_henryque.avaliacao_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEditarPrograma extends AppCompatActivity {

    EditText edtNome, edtDescricao, edtVagas, edtData;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_programa);

        edtNome = findViewById(R.id.edtNomePrograma);
        edtDescricao = findViewById(R.id.edtDescricaoPrograma);
        edtVagas = findViewById(R.id.edtVagasPrograma);
        edtData = findViewById(R.id.edtDataPrograma);
        btnSalvar = findViewById(R.id.btnSalvarAlteracoes);

        String nome = getIntent().getStringExtra("nome");
        String vagas = getIntent().getStringExtra("vagas");
        String data = getIntent().getStringExtra("data");

        edtNome.setText(nome);
        edtDescricao.setText("Descrição existente...");
        edtVagas.setText(vagas);
        edtData.setText(data);

        btnSalvar.setOnClickListener(v -> {
            String novoNome = edtNome.getText().toString().trim();
            String novaDescricao = edtDescricao.getText().toString().trim();
            String novasVagas = edtVagas.getText().toString().trim();
            String novaData = edtData.getText().toString().trim();

            if (novoNome.isEmpty() || novasVagas.isEmpty() || novaData.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos obrigatórios.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Programa atualizado:\n" + novoNome, Toast.LENGTH_LONG).show();
            finish();
        });
    }
}