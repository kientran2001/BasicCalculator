package com.example.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

    }

    public void btnClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "CE":
                input = "";
                break;

            case "C":
                input = "";
                break;
            case "BS":
                if(input.length() > 0){
                    String newText = input.substring(0, input.length()-1);
                    input = newText;
                }
                break;
            case "=":
                solve();
                answer = input;
                break;
            case "*":
                solve();
                input += "*";
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){

                }
                input += data;
        }
        tv.setText(input);
    }

    public void solve(){
        if(input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try{
                int mul = Integer.parseInt(number[0])*Integer.parseInt(number[1]);
                input = mul + "";
            }catch (Exception e){

            }
        }

        if(input.split("\\/").length == 2){
            String number[] = input.split("\\/");
            try{
                int div = Integer.parseInt(number[0])/Integer.parseInt(number[1]);
                input = div + "";
            }catch (Exception e){

            }
        }

        if(input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try{
                int sum = Integer.parseInt(number[0])+Integer.parseInt(number[1]);
                input = sum + "";
            }catch (Exception e){

            }
        }

        if(input.split("\\-").length == 2){
            String number[] = input.split("\\-");
            try{
                int sub = Integer.parseInt(number[0])-Integer.parseInt(number[1]);
                input = sub + "";
            }catch (Exception e){

            }
        }
    }

}