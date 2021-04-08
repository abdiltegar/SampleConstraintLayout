package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;
    private ListViewAdapter adapter;

    String[] listNama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        listNama = new String[]{"Naruto","Ereh","Goku","Luffy","Hamtaro","Nobita","Tsubasa","Hattori","Doraemon","Inuyasha"};

        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada listNama
        for (int i = 0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);//Bind strings ke array
        }

        //membuat object dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //Binds adapter ke ListView
        list.setAdapter(adapter);

        //membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variable nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //memasukkan value dari variable nama dengan kunci a ke dalam bundle
                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(Home_Activity.this);//membuat event untuk pop up menu ketika dipilih
                pm.inflate(R.menu.popup_menu);//menampilkan popup menu dari layout menu
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnView:
                Intent intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnEdit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}