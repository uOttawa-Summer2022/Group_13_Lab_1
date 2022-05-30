package com.example.tester2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tester2.databinding.ActivityMainBinding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_clear,
            btn0,btn_division,btn_equal,btn_addition,btn_subtraction,btn_decimal,btn_multiplication;
    TextView text_display;
    double num1, num2;
    boolean isNumber, mul, div, isDecimal;
    ScriptEngine engine;
    String op1 = "";
    String op2 = "";
    String operand = "";
    String result="";
    boolean isOperandSet = false;
    boolean resetText= false;
    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        setContentView(R.layout.activity_main);
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
       // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //binding.btn1.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View view) {
       //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
      //      }
      //  });
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
       /* btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);*/
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn0 = (Button) findViewById(R.id.button0);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_addition = (Button) findViewById(R.id.btn_addition);
        btn_subtraction = (Button) findViewById(R.id.btn_subtraction);
        btn_multiplication = (Button) findViewById(R.id.btn_multiplication);
        btn_decimal = (Button) findViewById(R.id.btn_decimal);

        text_display = (TextView) findViewById(R.id.text_display);
        setClickListeners();
        engine = new ScriptEngineManager().getEngineByName("rhino");
        text_display.setText("");
    }
    void setClickListeners(){
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn_addition.setOnClickListener(this);
        btn_multiplication.setOnClickListener(this);
        btn_subtraction.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_decimal.setOnClickListener(this);
        text_display.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        // this is the place where I will add code
        /*switch (v.getId()) {
            case R.id.btn1:
                text_display.setText(text_display.getText()+"1"); //
                break;
            case R.id.btn2:
                text_display.setText(text_display.getText()+"2"); //
                break;
            case R.id.btn_multiplication:
                text_display.setText(text_display.getText()+"*");
                break;
            case R.id.btn_division:
                text_display.setText(text_display.getText()+"/");
                break;
            case R.id.btn_addition:
                text_display.setText(text_display.getText()+"+");
                break;
            case R.id.btn_subtraction:
                text_display.setText(text_display.getText()+"-");
                break;
            case R.id.btn_decimal:
                text_display.setText(text_display.getText()+".");
                break;
            case R.id.btn_clear:
                text_display.setText("");
                break;
            case R.id.btn_equal:
                if (text_display.getText() != "") {
                    String result = null;
                    try {
                        result = evaluate(text_display.getText().toString());
                        text_display.setText(result);
                    } catch (ScriptException e) {
                        text_display.setText("ERROR");
                    }
                } else {
                    text_display.setText("NO EXPRESSIONS");
                }
                break;
        }*/
        int temp=v.getId();
        if(resetText){
            text_display.setText("");
            resetText = false;
        }

        switch(temp) {
            case R.id.button0:
                if (isOperandSet == false) {
                    op1 = op1 + btn0.getText();

                    text_display.setText((text_display.getText().toString().concat(btn0.getText().toString())));
                } else {
                    op2 = op2.concat(btn0.getText().toString());
                    text_display.setText((text_display.getText().toString().concat(btn0.getText().toString())));
                }
                break;
            case R.id.btn1:
                if (isOperandSet == false) {
                    op1 = op1 + btn1.getText();

                    text_display.setText((text_display.getText().toString().concat(btn1.getText().toString())));
                } else {
                    op2 = op2.concat(btn1.getText().toString());
                    text_display.setText((text_display.getText().toString().concat(btn1.getText().toString())));
                }

                break;
            case R.id.btn2:
                if (isOperandSet == false) {
                    op1 = op1.concat(btn2.getText().toString());
                    text_display.setText((text_display.getText().toString().concat(btn2.getText().toString())));

                }else {
                    op2 =op2.concat( btn2.getText().toString());
                    text_display.setText((text_display.getText().toString().concat(btn2.getText().toString())));
                }
                break;
            case R.id.btn_addition:
                if (isOperandSet == false){
                    operand = btn_addition.getText().toString();
                    isOperandSet = true;
                    text_display.setText(text_display.getText().toString().concat(operand));

                }
                break;
            case R.id.btn_subtraction:
                if (isOperandSet == false){
                    operand = btn_subtraction.getText().toString();
                    isOperandSet = true;
                    text_display.setText(text_display.getText().toString().concat(operand));
                }
                break;
            case R.id.btn_multiplication:
                if (isOperandSet == false){
                    operand = btn_multiplication.getText().toString();
                    isOperandSet = true;
                    text_display.setText(text_display.getText().toString().concat(operand));
                }
                break;
            case R.id.btn_division:
                if (isOperandSet == false){
                    operand = btn_division.getText().toString();
                    isOperandSet = true;
                    text_display.setText(text_display.getText().toString().concat(operand));
                }
                break;
            case R.id.btn_equal:
                if(!op1.equals("") && !op2.equals("") && !operand.equals("")){
                    calc.setOperands(op1,op2);
                    calc.setArithmeticOperator(operand);
                    result = calc.getResult();
                    text_display.setText(result);
                    op1 = "";
                    op2 = "";
                    operand = "";
                    isOperandSet = false;
                    resetText = true;
                }

                break;
            case R.id.btn_clear:
                text_display.setText("");
                op1 = "";
                op2 = "";
                operand = "";
                isOperandSet = false;
                resetText = true;
                break;
        }
    }
   /* private String evaluate(String expression) throws ScriptException {
        String result = engine.eval(expression).toString();
        BigDecimal decimal = new BigDecimal(result);
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }*/
}
