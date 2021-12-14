package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnFelvetel;
    private Button btnKeres;
    private EditText edit;
    private DBHelper db;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        String EditMezo = edit.getText().toString().trim();
        if (EditMezo.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Mindent tölts ki!", Toast.LENGTH_SHORT).show();
        }
        btnFelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent felvetel = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(felvetel);
                finish();
            }
        });
        btnKeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keres = new Intent(MainActivity.this, SearchResultActivity.class);
                startActivity(keres);
                finish();
            }
        });
    }
    private void init(){
        btnFelvetel = findViewById(R.id.btn_felvetel);
        btnKeres = findViewById(R.id.btn_keres);
        edit = findViewById(R.id.edit);


        db = new DBHelper(this);
    }
}