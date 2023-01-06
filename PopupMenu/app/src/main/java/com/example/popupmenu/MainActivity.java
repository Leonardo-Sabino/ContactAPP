package com.example.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.os.IResultReceiver;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button AbrirMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AbrirMenu = findViewById(R.id.butão);
        AbrirMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
                //para permitir o toque nos itens do menu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.fav:
                                Intent intent_fav = new Intent(MainActivity.this, FavouritesActivity.class);// intent para ir ate os favoritos
                                startActivity(intent_fav);
                                return true;
                            case R.id.Set:
                                Intent intent_settings = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS); // configuracoes do dispositivo
                                startActivity(intent_settings);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            popupMenu.show(); //para mostrar o popup menu
            }
        });

    }

}