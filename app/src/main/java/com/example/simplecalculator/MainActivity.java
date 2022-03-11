package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonDot,buttonAdd,buttonSubtract,buttonMultiply,buttonDivide,
            buttonPercentage,buttonMod,buttonEqual,buttonClear,buttonPower;

    TextView textView;

    boolean isSecondNo=false;
    double num1,num2;
    double result;
    String  sign;
    String input=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button0=findViewById(R.id.button0);button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);button9=findViewById(R.id.button9);
        buttonAdd=findViewById(R.id.buttonAdd);buttonSubtract=findViewById(R.id.buttonSubtract);
        buttonMod=findViewById(R.id.buttonModulus);buttonPower=findViewById(R.id.buttonPower);
        buttonMultiply=findViewById(R.id.buttonMultiply);
        buttonDivide=findViewById(R.id.buttonDivide);buttonDot=findViewById(R.id.buttonDot);
        buttonPercentage=findViewById(R.id.buttonPercentage);
        buttonEqual=findViewById(R.id.buttonEqual);buttonClear=findViewById(R.id.buttonClear);
        textView=findViewById(R.id.textView);

        button0.setOnClickListener(this);button1.setOnClickListener(this);
        button2.setOnClickListener(this);button3.setOnClickListener(this);
        button4.setOnClickListener(this);button5.setOnClickListener(this);
        button6.setOnClickListener(this);button7.setOnClickListener(this);
        button8.setOnClickListener(this);button9.setOnClickListener(this);
        buttonDot.setOnClickListener(this);buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);buttonPower.setOnClickListener(this);
        buttonPercentage.setOnClickListener(this);buttonMod.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);buttonClear.setOnClickListener(this);









    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:buttonPressed("0");
                break;
            case R.id.button1: buttonPressed("1");
                break;
            case R.id.button2:buttonPressed("2");
                break;
            case R.id.button3:buttonPressed("3");
                break;
            case R.id.button4:buttonPressed("4");
                break;
            case R.id.button5:buttonPressed("5");
                break;
            case R.id.button6:buttonPressed("6");
                break;
            case R.id.button7:buttonPressed("7");
                break;
            case R.id.button8:buttonPressed("8");
                break;
            case R.id.button9:buttonPressed("9");
                break;
            case R.id.buttonAdd:buttonOperator("add");
                break;
            case R.id.buttonSubtract:buttonOperator("subtract");
                break;
            case R.id.buttonMultiply:buttonOperator("multiply");
                break;
            case R.id.buttonDivide:buttonOperator("divide");
                break;
            case R.id.buttonPercentage:buttonOperator("percent");
                break;
            case R.id.buttonPower:buttonOperator("power");
                break;
            case R.id.buttonDot:buttonPressed(".");
                break;
            case R.id.buttonModulus:buttonOperator("mod");
                break;
            case R.id.buttonClear:textView.setText("");
                break;
            case R.id.buttonEqual:calcluation();
                break;


        }
    }

    private void calcluation() {
        num2=Double.parseDouble(textView.getText().toString());
        Log.d(TAG, "vlaue of num1 :  "+num1);
        Log.d(TAG, "value of num2: "+num2);
        switch(sign){
            case "add":
                 result=num1+num2;
                Log.d(TAG, "result : "+result);
                break;
            case "subtract":
                 result=num1-num2;
                break;
            case "multiply":
                result=num1*num2;
                break;
            case "divide":
                result=num1/num2;

            break;
            case "power":
                result=Math.pow(num1,num2);

                break;
            case "mod":
                result=num1%num2;

                break;
            case "percent":
                result=(num1*num2)/100;

                break;
        }
        textView.setText(String.valueOf(result));

    }

    private void buttonOperator(String s) {
        num1=Double.parseDouble(textView.getText().toString());
        Log.d(TAG, "buttonOperator: "+ s);
         sign=s;
       // operatorTextView.setText(operator);
        isSecondNo= true;

    }

    private void buttonPressed(String i) {
        if(isSecondNo==false){
            input=String.valueOf(textView.getText().toString());
            textView.setText(input+i);
        }else{
            textView.setText("");
            textView.setText(String.valueOf(i));
            isSecondNo=false;
        }
    }
}