package com.example.calculatoralpha2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;





public class My_calculator extends AppCompatActivity {
 private TextView Screen;
 private String input = "", Answer;
 private boolean clearResult;


 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_my_calculator);

  Screen = findViewById(R.id.screen);
 }

 public void ButtonClick(View view) {
  Button button = (Button) view;
  String data = button.getText().toString();
  switch (data) {
   case "AC":
    input = "";
    break;
   case "x":
    clearResult = false;
    Solve();
    input += "*";
    break;

   case "=":
    clearResult = true;
    Solve();
    Answer = input;
    break;

   default:
    if (input == null) {
     input = "";
    }
    if (data.equals("+") || data.equals("-") || data.equals("/")) {
     clearResult = false;
     Solve();
    } else if (clearResult == true) {
     input = "";
     clearResult = false;
    }
    input += data;
  }
  Screen.setText(input);
 }


 public void Solve() {
  if (input.split("\\*").length == 2) {
   String numbers[] = input.split("\\*");
   try {
    double mul = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
    input = mul + "";
   } catch (Exception e) {

   }
  } else if (input.split("/").length == 2) {
   String numbers[] = input.split("/");
   try {
    double div = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
    input = div + "";
   } catch (Exception e) {

   }
  } else if (input.split("\\+").length == 2) {
   String numbers[] = input.split("\\+");
   try {
    double sum = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
    input = sum + "";
   } catch (Exception e) {

   }
  } else if (input.split("\\-").length > 1) {
   String numbers[] = input.split("\\-");
   if (numbers[0] == "" && numbers.length == 2) {
    numbers[0] = 0 + "";
   }
   try {
    double sub = 0;
    if (numbers.length == 2) {
     sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
    } else if (numbers.length == 3) {
     sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
    }
    input = sub + "";
   } catch (Exception e) {
    
   }
  }
  String n[] = input.split("\\.");
  if (n.length > 1) {
   if (n[1].equals("0")) {
    input = n[0];
   }
  }
  Screen.setText(input);
 }
}







