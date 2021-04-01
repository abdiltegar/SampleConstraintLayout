package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtRePassword;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        fab = findViewById(R.id.fabSimpan);
        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtRePassword = findViewById(R.id.edRePass);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (edtNama.getText().toString().isEmpty() ||
                    edtAlamat.getText().toString().isEmpty() ||
                    edtEmail.getText().toString().isEmpty() ||
                    edtPassword.getText().toString().isEmpty() ||
                    edtRePassword.getText().toString().isEmpty()
                ){
                    Snackbar.make(view, "Wajib diisi ! Tidak boleh ada data yang kosong !", Snackbar.LENGTH_LONG).show();
                }else{
                    if (edtPassword.getText().toString().equals(edtRePassword.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Pendaftaran berhasil",Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else{
                        Snackbar.make(view, "Password dan Re-Password harus sama !", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}