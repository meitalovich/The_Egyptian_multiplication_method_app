package com.example.egyptianproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        TextView txt6=findViewById(R.id.textView6);
        txt6.setText("");

        EditText num1=(EditText) findViewById(R.id.num1);
        EditText num2=(EditText)findViewById(R.id.num2);
        String value1= num1.getText().toString();
        String val2= num2.getText().toString();
        Button connection1=findViewById(R.id.button4);
        Button connection2=findViewById(R.id.button5);
        TextView txt4=findViewById(R.id.textView4);


        // button1 clicked
        connection1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(value1!="" && val2!="") {

                    Intent intent = new Intent(MainActivity.this, Reconnection1.class);
                    intent.putExtra("number1", (CharSequence) num1.getText().toString());
                    intent.putExtra("number2", (CharSequence) num2.getText().toString());
                    startActivity(intent);


                }
            }
        });

        // button2 clicked
        connection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent1=new Intent( MainActivity.this, ReConnection2.class);
                intent1.putExtra("number1", (CharSequence) num1.getText().toString());
                intent1.putExtra("number2", (CharSequence) num2.getText().toString());
                startActivity(intent1);

            }
        });
        Intent i1=getIntent();

        if(i1.getIntExtra("resultValue",0)!=0)
        {
            txt4.setText("Total is : "+i1.getIntExtra("resultValue",0));
        }




        Intent i2=getIntent();
        String sr=i2.getStringExtra("resultValue1");
        txt6.setText(sr);



    }
}