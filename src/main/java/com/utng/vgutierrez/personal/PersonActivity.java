package com.utng.vgutierrez.personal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonActivity extends AppCompatActivity {
  private Button btnRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        btnRegistration = (Button) findViewById(R.id.btn_add);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentAdd = new Intent(PersonActivity.this, RegistrationActivity.class);
              //  startActivity(intentAdd);

            }
        });

    }
    public void nextActivity(View view){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    }


