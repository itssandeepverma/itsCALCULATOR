package com.example.user.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.btnLogin);
        Info=(TextView)findViewById(R.id.tvInfo);

        Info.setText("no of attempts remaining:"+String.valueOf(counter));
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate( String username, String userpassword){
        if ((username.equals("sandeep")) && (userpassword.equals("kumar"))) {
            Intent intent = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Main3Activity.this, "SUCCESFULLY LOGGED IN\n      ENJOY CALC", Toast.LENGTH_SHORT).show();

        } else {
            counter--;
            Info.setText("No of attempts remaining:" + String.valueOf(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }


        }
    }
}
