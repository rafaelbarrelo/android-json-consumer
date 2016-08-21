package br.com.rafaelbarrelo.readonlinejson;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.rafaelbarrelo.readonlinejson.model.Usuario;

/**
 * Created by rafaelbarrelo on 8/21/16.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Usuario> usuarios;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return  new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        UsuarioViewHolder holder = (UsuarioViewHolder) viewHolder;
        holder.setUsuario(usuarios.get(position));
    }

    @Override
    public int getItemCount() {
        return this.usuarios == null ? 0 : this.usuarios.size();
    }

    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }


    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvNome;
        private final TextView tvId;
        private final TextView tvSenha;

        public UsuarioViewHolder(View itemView) {
            super(itemView);

            this.tvNome = (TextView)itemView.findViewById(R.id.text_nome);
            this.tvId = (TextView)itemView.findViewById(R.id.text_id);
            this.tvSenha = (TextView)itemView.findViewById(R.id.text_password);
        }

        public void setUsuario(Usuario usuario){
            this.tvNome.setText(usuario.getName());
            this.tvId.setText(usuario.getId());
            this.tvSenha.setText(usuario.getPassword());
        }

    }

}
