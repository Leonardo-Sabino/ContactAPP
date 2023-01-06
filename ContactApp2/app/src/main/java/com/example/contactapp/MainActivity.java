package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nome,email,foto,numero;

    List<Contatos> listaContatos; //instanciando a lista contatos
    MyApplication myApplication = (MyApplication) this.getApplication(); //instanciar myApplication


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContatos = myApplication.getListaContatos();//para receber os contados recenbendo os elementos da lista da classe principal

        nome = findViewById(R.id.nome);
        numero = findViewById(R.id.numero);
        email = findViewById(R.id.email);
        foto =  findViewById(R.id.foto_novo_contato);

    }

    public void add_button(View view) {
            //int novoNumero = myApplication.getNovoNumero();
            Contatos novoContato = new Contatos(nome.getText().toString(),Integer.parseInt(numero.getText().toString()),email.getText().toString(),foto.toString()); //para adicionar um novo contato ao clicar no botao
            listaContatos.add(novoContato);
            Toast.makeText(this, "Novo contato adicionado", Toast.LENGTH_SHORT).show();
            Intent intend = new Intent(this, Lista_Contatos.class);
           startActivity(intend);
        }
   }
