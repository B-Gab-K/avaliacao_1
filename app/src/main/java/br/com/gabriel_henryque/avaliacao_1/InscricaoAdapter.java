package br.com.gabriel_henryque.avaliacao_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InscricaoAdapter extends RecyclerView.Adapter<InscricaoAdapter.InscricaoViewHolder> {

    private List<String> inscricoes;

    public InscricaoAdapter(List<String> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @NonNull
    @Override
    public InscricaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_inscricao, parent, false);
        return new InscricaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InscricaoViewHolder holder, int position) {
        String inscricao = inscricoes.get(position);
        holder.textInscricao.setText(inscricao);
    }

    @Override
    public int getItemCount() {
        return inscricoes.size();
    }

    public static class InscricaoViewHolder extends RecyclerView.ViewHolder {
        TextView textInscricao;

        public InscricaoViewHolder(@NonNull View itemView) {
            super(itemView);
            textInscricao = itemView.findViewById(R.id.textInscricao);
        }
    }
}