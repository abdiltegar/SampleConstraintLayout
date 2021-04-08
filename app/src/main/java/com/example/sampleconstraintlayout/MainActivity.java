package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //------- deklarasi variable---------------
    Button btnLogin; //variable untuk button
    EditText edEmail, edPass; //variable untuk editText
    String nama,password, tEmail="admin@mail.com", tPassword="123"; //variable untuk menyimpan email dan password
    //--------- end - deklarasi variable-------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.buttonSignIn);//menghubungkan variable btnLogin dengan buttonSignIn pada layout
        edEmail = findViewById(R.id.editTextEmail);//menghubungkan variable edEmail dengan editTextEmail pada layout
        edPass = findViewById(R.id.editTextPassword);//menghubungkan variable edPass dengan editTextPassword pada layout

        btnLogin.setOnClickListener(new View.OnClickListener(){//fungsi onclick pada button btnLogin
            @Override
            public void onClick(View view){
                nama = edEmail.getText().toString();//menyimpan inputan user di edEmail ke dalam variable nama
                password = edPass.getText().toString();//menyimpan inputan user di edPass ke dalam variable password

                //Toast t = Toast.makeText(getApplicationContext(), "Email anda : "+nama+" dan password anda : "+password, Toast.LENGTH_LONG);
                //t.show();

                if(!nama.equals(tEmail) && !password.equals(tPassword)){//jika email dan password salah
                    Toast.makeText(getApplicationContext(), "Email dan Password yang anda masukkan salah", Toast.LENGTH_LONG).show();
                }else if(!nama.equals(tEmail)){//jika email saja yang salah
                    Toast.makeText(getApplicationContext(), "Email yang anda masukkan salah", Toast.LENGTH_LONG).show();
                }else if(!password.equals(tPassword)){//jika password saja yang salah
                    Toast.makeText(getApplicationContext(), "Password yang anda masukkan salah", Toast.LENGTH_LONG).show();
                }else{//jika tidak maka email dan password benar
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    b.putString("a",nama.trim());
                    b.putString("b",password.trim());

                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                    i.putExtras(b);

                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}