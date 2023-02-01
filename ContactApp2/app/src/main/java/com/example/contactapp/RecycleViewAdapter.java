package com.example.contactapp;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Contatos> listaContatos;
    Context context;

    public RecycleViewAdapter(List<Contatos> listaContatos, Context context) {
        this.listaContatos = listaContatos;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{ //temos que estender para o recycleView e ele gera um construtor
        // defenindo os elementos que ficarao no lista de contato
        ImageView img_contato;
        TextView nome_contato;
        TextView numero_contato;
        TextView email_contato;
        ImageButton img_fav;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView); //gera sozinho tem haver a classe parent
            //passsando o id do contatos_layout.xml
            img_contato = itemView.findViewById(R.id.foto_contato);
            nome_contato = itemView.findViewById(R.id.contato_nome);
            numero_contato = itemView.findViewById(R.id.contato_numero);
            email_contato = itemView.findViewById(R.id.contato_email);
            img_fav = itemView.findViewById(R.id.fav_contato);

            itemView.setOnCreateContextMenuListener(this);
            img_fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // img_fav.setBackgroundColor(Color.parseColor(" #ff0000"));
                    Toast.makeText(context, "Contato adicionado aos Favoritos", Toast.LENGTH_SHORT).show();
                }
            });
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0,itemView.getId(),0,"Chamar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(context, "Voce clicou para fazer uma chamada", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            menu.add(0,itemView.getId(),0,"Enviar sms").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(context, "Voce clicou para enviar um sms", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            menu.add(0,itemView.getId(),0,"Apagar o contato").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    listaContatos.remove(getLayoutPosition());
                    notifyDataSetChanged();
                    return false;
                }
            });

        }

    }
    //metodos que o metodo (public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>)pede
    @NonNull
    @Override
    //
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater vai expandir o nosso layout e o colocar em diferentes componentes
        //temos que passar o contexto do objeto pai
        // e no R.layout temos que passar o layout que queremos inflar, o parent que é o root, ele sera enraizado em seu pai(parent) eo terceiro é falso
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contatos_layout,parent,false);
        //criando uma  instancia para o meu viewholder e passar a nova versao do viewHolder declarado em cima, ligando os dois (adapter acontecendo)
        MyViewHolder holder = new MyViewHolder(view);

        return holder; //retornar o holder
    }

    @Override
    // sao os valores que vao com cada linha da nossa lista
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nome_contato.setText(listaContatos.get(position).getNome()); //ele apanha o texto na  lista de contatos na posicao nome
        holder.numero_contato.setText(String.valueOf(listaContatos.get(position).getNumero())); //String.valueOf porque numero é um inteiro e um inteiro nao pode ser usado no setText
        holder.email_contato.setText(listaContatos.get(position).getEmail());
        Glide.with(this.context).load("https://www.pngall.com/wp-content/uploads/12/Avatar-No-Background.png").into(holder.img_contato); //into e onde queremos por a imagem
    
    }
    //refere-se ao numero de itens que vou colocar na minha lista
    @Override
    public int getItemCount() {
        return listaContatos.size(); //para retornar todos os itens do da lista
    }

}
