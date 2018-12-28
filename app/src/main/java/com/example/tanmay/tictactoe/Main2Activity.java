package com.example.tanmay.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class Main2Activity extends AppCompatActivity {


    public static EditText name1,name2;
    Switch s=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name1 = findViewById(R.id.editText);
        name2 = findViewById(R.id.editText2);
        s=findViewById(R.id.switch1);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {

                if(isChecked) {
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    Main2Activity.this.startActivity(intent);
                }
            }

        });

    }
}
