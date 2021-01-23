package com.example.quick_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save=findViewById(R.id.save);
        EditText notes=findViewById(R.id.notes);
        TextView show=findViewById(R.id.show);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg= notes.getText().toString();
                SharedPreferences shr=getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor= shr.edit();

                editor.putString("str",msg);
                editor.apply();
                show.setText(msg);
            }
        });

        SharedPreferences share=getSharedPreferences("demo",MODE_PRIVATE);
        String value=share.getString("str","write a note here ");
        show.setText(value);


    }
}