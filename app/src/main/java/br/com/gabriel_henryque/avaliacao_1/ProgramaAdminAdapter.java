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

public class ProgramaAdminAdapter extends RecyclerView.Adapter<ProgramaAdminAdapter.ViewHolder> {

    private List<Programa> programaList;

    public ProgramaAdminAdapter(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_programa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Programa programa = programaList.get(position);
        holder.nome.setText(programa.getNome());
        holder.vagas.setText("Vagas: " + programa.getVagas());

        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, ActivityEditarPrograma.class);
            intent.putExtra("nome", programa.getNome());
            intent.putExtra("vagas", programa.getVagas());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return programaList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, vagas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomePrograma);
            vagas = itemView.findViewById(R.id.vagasPrograma);
        }
    }
}