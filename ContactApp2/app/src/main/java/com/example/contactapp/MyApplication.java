package com.example.contactapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    //extends application permite nos criar uma classe global

    private static List <Contatos> listaContatos = new ArrayList<Contatos>();
    private static int novoNumero = 5843328; // para o proximo a entrar na lista

    private void preencheListaContatos() {

        Contatos c0 = new Contatos("Marvin Tottenham Duarte",5890023,"mar2206taqua@54.mk","https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png");
        Contatos c1 = new Contatos("Kleivy Santos Gomes",5898123,"blasik@54.mk","https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png");
        Contatos c2 = new Contatos("Rosa Duarte",9546939,"Rosa808@gmail.com","https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png");
        Contatos c3 = new Contatos("Iven do Porto",9823579,"kaikaboy808@fernet89.com","https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png");
        Contatos c4 = new Contatos("Carlos Figueiredo",5898327,"rabota062875@127.life","https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png");
        Contatos c5 = new Contatos("Caetano Tottenham",5599164,"sergescheers@dmxs8.com","https://e7.pngegg.com/pngimages/799/987/png-clipart-computer-icons-avatar-icon-design-avatar-heroes-computer-wallpaper-thumbnail.png");
        Contatos c6 = new Contatos("Sousa Fortes",9892262,"kingvart@backwis.com","");
        Contatos c7 = new Contatos("Vieira William",5681471,"dadacontrolli@kongshuon.com","");
        Contatos c8 = new Contatos("Leonardo Sabino",9844468,"SabinoLeonard@gmail.com","");
        Contatos c9 = new Contatos("Alex Tottenham",5823321,"EusouTottenham@gmail.com","");
        Contatos c10 = new Contatos("Casas Aluguel",5652371,"CasasAluguer@hotmail.com","");

        // adicinar no array para recebe-los tudos juntos
        listaContatos.addAll(Arrays.asList(new Contatos[] {c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10}));

        }

    public MyApplication() {

        preencheListaContatos();
    }

    //getters e setters
    public static List<Contatos> getListaContatos() {

        return listaContatos;
    }

    public static void setListaContatos(List<Contatos> listaContatos) {
        MyApplication.listaContatos = listaContatos;
    }

    public static int getNovoNumero() {
        return novoNumero;
    }

    public static void setNovoNumero(int novoNumero) {
        MyApplication.novoNumero = novoNumero;
    }
}
