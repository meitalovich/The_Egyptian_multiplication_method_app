package com.example.egyptianproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ReConnection2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_connection2);

        Intent intent=getIntent();
        String num1=intent.getStringExtra("number1");

        String num2=intent.getStringExtra("number2");
        Button btn =findViewById(R.id.button);
        int counter=1;
        int sum=0;
        String sumValue="";
        int n1=Integer.parseInt(num1);
        int n2=Integer.parseInt(num2);
        TextView result=findViewById(R.id.result1);
        TextView tx7=findViewById(R.id.textView7);
        TextView tx8=findViewById(R.id.textView8);

        double binaryno=0;
        int tempNum2=Integer.parseInt(num2);
        int k=0;
        int ten=10;
        while(tempNum2!=0)
        {
            int temp1=tempNum2%2;
            binaryno=binaryno+ temp1*Math.pow(ten,k);
            k++;
            tempNum2=tempNum2/2;
        }
        ArrayList<Integer> values=new ArrayList<Integer>();
        String reuslt1txt="";
        while(counter<=Integer.parseInt(num2))
        {
            if(counter==1)
            {
                int temp=n1*counter;
                values.add(temp);
                reuslt1txt += String.valueOf(n1)+" x "+ String.valueOf(counter)+" = " +String.valueOf(temp);
                reuslt1txt+='\n';
            }
            else
            {
                int temp = n1 * counter;
                values.add(temp);
                reuslt1txt += String.valueOf(n1)+" x "+ String.valueOf(counter)+" = " +String.valueOf(temp);
               reuslt1txt+='\n';
            }
            counter*=2;
        }
        int j=0;
        int tempBinary=(int)binaryno;
        String sumValue1="";

        int tempNum22=n2;
        int counterr=0;
        while(tempNum22!=1)
        {
            if(counterr==0)
            {
                tempNum22=tempNum22/1;
                sumValue += String.valueOf(tempNum22)+" / 1="+ String.valueOf(tempNum22);
                sumValue+='\n';
            }
            else
            {
                sumValue += String.valueOf(tempNum22)+" / 2=";

                tempNum22=tempNum22/2;
                sumValue+= String.valueOf(tempNum22);
                sumValue+='\n';
            }
            counterr++;
        }

        while(j<values.size())
        {
            double tempb=tempBinary%10;
            if(tempb==1)
            {
                sum+=values.get(j);

                sumValue1+=values.get(j)+"+";
            }
            tempBinary=tempBinary/10;
            j++;
        }

        sumValue1=sumValue1.substring(0, sumValue1.length() - 1);
        sumValue1+=" = "+sum;
        tx8.setText(sumValue1);
        result.setText(sumValue);
        tx7.setText(reuslt1txt);
        String data=sumValue1;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ReConnection2.this, MainActivity.class);
                i.putExtra("resultValue1",data);
                startActivity(i);
            }
        });

    }
}