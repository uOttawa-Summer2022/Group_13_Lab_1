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

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button btn1;
    Button btn2;
    Button btn_addition, btn_subtraction, btn_division, btn_multiplication, btn_equal, btn_decimal, btn_clear;
    TextView text_display;
    double num1, num2;
    boolean isNumber, mul, div, isDecimal;
    ScriptEngine engine;

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
        btn_addition = (Button) findViewById(R.id.btn_addition);
        btn_subtraction= (Button) findViewById(R.id.btn_subtraction);
        btn_multiplication = (Button) findViewById(R.id.btn_multiplication);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_equal= (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_decimal = (Button) findViewById(R.id.btn_decimal);
        text_display = (TextView) findViewById(R.id.text_display);
        setClickListeners();
        engine = new ScriptEngineManager().getEngineByName("rhino");
        text_display.setText("");
    }
    void setClickListeners(){
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn_addition.setOnClickListener(this);
        btn_multiplication.setOnClickListener(this);
        btn_subtraction.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_decimal.setOnClickListener(this);
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
        switch (v.getId()) {
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
        }
    }
    private String evaluate(String expression) throws ScriptException {
        String result = engine.eval(expression).toString();
        BigDecimal decimal = new BigDecimal(result);
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }
}
