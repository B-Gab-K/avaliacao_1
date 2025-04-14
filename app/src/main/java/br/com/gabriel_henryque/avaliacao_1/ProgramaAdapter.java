package br.com.gabriel_henryque.avaliacao_1;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgramaAdapter extends RecyclerView.Adapter<ProgramaAdapter.ProgramaViewHolder> {

    private final List<Programa> programaList;

    public ProgramaAdapter(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @NonNull
    @Override
    public ProgramaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_programa, parent, false);
        return new ProgramaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramaViewHolder holder, int position) {
        Programa programa = programaList.get(position);
        holder.nome.setText(programa.getNome());
        holder.vagas.setText("Vagas: " + programa.getVagas());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ActivityDetalhePrograma.class);
                intent.putExtra("nomePrograma", programa.getNome());
                intent.putExtra("vagas", programa.getVagas());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return programaList.size();
    }

    public static class ProgramaViewHolder extends RecyclerView.ViewHolder {
        TextView nome, vagas;

        public ProgramaViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomePrograma);
            vagas = itemView.findViewById(R.id.vagasPrograma);
        }
    }
}
