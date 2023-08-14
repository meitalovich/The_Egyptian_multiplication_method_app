package com.example.egyptianproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Reconnection1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconnection1);


        Intent intent=getIntent();
        String num1=intent.getStringExtra("number1");

        String num2=intent.getStringExtra("number2");
        Button btn =findViewById(R.id.btnmain);
        int counter=1;
        int sum=0;
        String sumValue="";
        int n1=Integer.parseInt(num1);
        TextView result=findViewById(R.id.result);

        //convert no into binary
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

        while(counter<=Integer.parseInt(num2))
        {
            if(counter==1)
            {
                int temp=n1*counter;
                sumValue += String.valueOf(counter)+" x "+ String.valueOf(n1)+" = " +String.valueOf(temp);
                sumValue+='\n';
                values.add(temp);
            }
            else
            {
                int temp = n1 * counter;
                values.add(temp);
                //sum +=temp;
                sumValue += String.valueOf(counter)+" x "+String.valueOf(n1)+" = "+ String.valueOf(temp);
                sumValue+='\n';

            }
            counter*=2;
        }

        int j=0;
        int tempBinary=(int)binaryno;
        while(j<values.size())
        {
            double tempb=tempBinary%10;
            if(tempb==1)
            {
                sum+=values.get(j);
            }

            tempBinary=tempBinary/10;
            j++;
        }
        j=0;
        tempBinary=(int)binaryno;
        while(j<values.size())
        {
            double tempb=tempBinary%10;
            if(tempb==0)
            {
                values.remove(j);
            }
            tempBinary=tempBinary/10;
            j++;
        }

        int q=values.size();
        while(q>0)
        {
            if(q==1)
            {
                sumValue+=values.get(q-1);
            }
            else{
                sumValue+=values.get(q-1)+"+";
            }
            q--;

        }

        sumValue+="="+sum;
        result.setText(sumValue);

        int value11=sum;
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(Reconnection1.this, MainActivity.class);
               i.putExtra("resultValue",value11);
               startActivity(i);
           }
       });




    }
}