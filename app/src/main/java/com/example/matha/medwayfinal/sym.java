package com.example.matha.medwayfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sym extends AppCompatActivity {
    TextView injsym;
    Button rem;
    String id,symp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sym);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        injsym=(TextView) findViewById(R.id.injsym);
        rem=(Button) findViewById(R.id.rem);
        id=getIntent().getStringExtra("id");
        symp=getIntent().getStringExtra("symptom");
        injsym.setText(symp);
        rem=(Button) findViewById(R.id.rem);
        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sym.this,remedy.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}
