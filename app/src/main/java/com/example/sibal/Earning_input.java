package com.example.sibal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Earning_input extends AppCompatActivity {

    private Button save;
    private EditText earningamount;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earning_input);

        earningamount = findViewById(R.id.earningamount);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str2= earningamount.getText().toString();

                Intent intent = new Intent(Earning_input.this, MainActivity.class);
                intent.putExtra("str2", str2);
                startActivity(intent);
            }
        });
    }

}
