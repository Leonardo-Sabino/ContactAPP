package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lista_Contatos extends AppCompatActivity {

    //private static  final String tag = "Contato App";

    // array list do tipo contatos
    List<Contatos> listaContatos = new ArrayList<Contatos>();
    //
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter ;
    private RecyclerView.LayoutManager layoutManager;
    //referencia para a MyApplication
    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        //para ir buscar a lista dos contatos no MyApplication
        listaContatos = myApplication.getListaContatos();
        //Toast.makeText(this, "Contatos lista = " +listaContatos.size(), Toast.LENGTH_LONG).show();
        recyclerView = findViewById(R.id.Lista_contatos);
        //
        recyclerView.setHasFixedSize(true);
        //
        layoutManager = new LinearLayoutManager(this);
        //
        recyclerView.setLayoutManager(layoutManager);
        //para especificar o adaptador
        mAdapter = new RecycleViewAdapter(listaContatos,this); //pede para criar a classe RecycleViewAdapter
        recyclerView.setAdapter(mAdapter);
    }

    public void add(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}