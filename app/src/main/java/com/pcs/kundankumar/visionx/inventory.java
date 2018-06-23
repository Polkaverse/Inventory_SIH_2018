package com.pcs.kundankumar.visionx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class inventory extends AppCompatActivity {
    private Button mFirebaseBtn , Btn2;
    private DatabaseReference mDatabase;

    private EditText mNameField;
    private EditText mPriceField;
    private EditText mQuanField;
    private EditText mExDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        mFirebaseBtn=(Button) findViewById(R.id.button2);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Medicines");

        mNameField=(EditText) findViewById(R.id.editText);
        mPriceField=(EditText) findViewById(R.id.editText2);
        mQuanField=(EditText) findViewById(R.id.editText3);
        mExDate=(EditText) findViewById(R.id.editText4);
        Btn2=(Button) findViewById(R.id.button3);

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mNameField.getText().toString().trim();
                String price = mPriceField.getText().toString().trim();
                String Quantity = mQuanField.getText().toString().trim();
                String expiry = mExDate.getText().toString().trim();

                //Firebase mDatabase = new Firebase(Constant.https://practice-1ed3c.firebaseio.com/medicines).child("rsvp");

                HashMap<String, String> dataMap =new HashMap<String , String>();
                dataMap.put("Price", price);
                dataMap.put("Quantity", Quantity);
                dataMap.put("Expiry Date", expiry);
                mDatabase.child(name).setValue(dataMap);
                mNameField.setText("");
                mPriceField.setText("");
                mQuanField.setText("");
                mExDate.setText("");
                toastMessage(name +" is stored sucessfully...");
                //Toast.makeText(this,"rrt", Toast.LENGTH_LONG).show();

            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent koi=new Intent(inventory.this,MainActivity.class);
                startActivity(koi);
            }
        });


    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
