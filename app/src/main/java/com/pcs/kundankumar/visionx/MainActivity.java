package com.pcs.kundankumar.visionx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private Button LButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText=(EditText)findViewById(R.id.email);
        passwordText=(EditText)findViewById(R.id.password);
        LButton=(Button)findViewById(R.id.button);


        LButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailText.getText().toString().equals("pankaj") && passwordText.getText().toString().equals("1234")){

                    Intent koi=new Intent(MainActivity.this,inventory.class);
                    startActivity(koi);
                    toastMessage("Login successfully...");
                    emailText.setText("");
                    passwordText.setText("");
                }else{
                    toastMessage("Enter valid username and password");
                    //Wrong Password
                        //Toast.makeText(this,"rrt", LENGTH_LONG).show();
                }
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
