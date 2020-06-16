package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static final int AAA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void kliknij(View view){
        Intent intencja= new Intent(this, LoginActivity.class);
        startActivity(intencja);

        Toast.makeText(getApplicationContext(),"Kliknieto button", Toast.LENGTH_SHORT).show();
    }

    public void kliknij2(View view){
        Intent intencja= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intencja, AAA);

    }


    public void zmianaButtona(View view){
        Random losowanie = new Random();
        int liczba = losowanie.nextInt(5);
        FloatingActionButton button2 = (FloatingActionButton)findViewById(R.id.button3);
        if(liczba == 0){
            button2.setImageDrawable(getResources().getDrawable(R.drawable.test));
        }
        else if (liczba == 1){
            button2.setImageDrawable(getResources().getDrawable(R.drawable.test2));
        }
        else if (liczba == 2){
            button2.setImageDrawable(getResources().getDrawable(R.drawable.unnamed));
        }
        else if (liczba == 3){
            button2.setImageDrawable(getResources().getDrawable(android.R.drawable.btn_star_big_off));
        }
        else{
            button2.setImageDrawable(getResources().getDrawable(android.R.drawable.btn_star_big_on));
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay=(ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Kliknieto settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.test1:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk test1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.test2:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk test2" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.test3:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk test3", Toast.LENGTH_SHORT).show();
                break;
        }



        return super.onOptionsItemSelected(item);
    }
}
