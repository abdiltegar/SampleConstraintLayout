package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityHasil extends AppCompatActivity {
    TextView tEmail, tPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tEmail = findViewById(R.id.textVEmail);
        tPassword = findViewById(R.id.textVPassword);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("a");
        String password = bundle.getString("b");

        tEmail.setText(email);
        tPassword.setText(password);
    }
}