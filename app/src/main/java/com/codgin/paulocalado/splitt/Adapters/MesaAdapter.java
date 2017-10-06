package com.codgin.paulocalado.splitt.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Model.Mesa;
import com.codgin.paulocalado.splitt.R;

import java.util.List;

/**
 * Created by Paulo on 06/10/2017.
 */
public class MesaAdapter extends RecyclerView.Adapter<MesaAdapter.MesaViewHolder> {
    List<Mesa> listaMesas;

    public MesaAdapter(List<Mesa> listaMesas){
        this.listaMesas = listaMesas;
    }

    @Override
    public MesaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens_lista, parent, false);
        MesaViewHolder mvh = new MesaViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MesaViewHolder holder, int position) {
        holder.txtNomeMesa.setText(String.valueOf(listaMesas.get(position).getNome()));
        holder.txtQuantidadePessoaMesa.setText(String.valueOf(listaMesas.get(position).getQuantidadePessoas())+" Pessoas");
        holder.txtTotalMesa.setText(holder.txtTotalMesa.getContext().getResources().getString(R.string.total_mesa)+String.format("%.2f", listaMesas.get(position).getTotal()));
    }

    @Override
    public int getItemCount() {
        return listaMesas.size();
    }

    public static class MesaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtNomeMesa;
        TextView txtQuantidadePessoaMesa;
        TextView txtTotalMesa;

        MesaViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardItenListaMesa);
            txtNomeMesa = (TextView)itemView.findViewById(R.id.txtNomeMesaLista);
            txtQuantidadePessoaMesa = (TextView)itemView.findViewById(R.id.txtQuantidadePessoasMesaLista);
            txtTotalMesa = (TextView)itemView.findViewById(R.id.txtTotalMesa);
            //qual itemView.setOnClickListener( itemView);
        }


    }

}
