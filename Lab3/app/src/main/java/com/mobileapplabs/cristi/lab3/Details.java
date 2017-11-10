package com.mobileapplabs.cristi.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String name = intent.getStringExtra(SendEmail.EXTRA_MESSAGE);
        String position = intent.getStringExtra(SendEmail.EXTRA_MESSAGE_TWO);
        System.out.println(name);
        System.out.println(position);

        // Capture the layout's TextView and set the string as its text
        final EditText nameText = (EditText) findViewById(R.id.textName);
        nameText.setText(name);

        final EditText positionText = (EditText) findViewById(R.id.textPosition);
        positionText.setText(position);

        final Button button = (Button) findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent output = new Intent();
                output.putExtra("Name", nameText.getText().toString());
                output.putExtra("Position", positionText.getText().toString());
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }
}
