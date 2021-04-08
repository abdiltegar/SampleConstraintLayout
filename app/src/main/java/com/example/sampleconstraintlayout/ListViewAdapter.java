package com.example.sampleconstraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variable dengan jenis data context
    Context mContext;

    //Deklarasi variable dengan jenis data Layout inflater
    LayoutInflater inflater;

    //Deklarasi variable dengan jenis data arrayList
    private ArrayList<ClassNama> arrayList;

    public ListViewAdapter(Context context){
        //memberi nilai mContext dengan context
        mContext = context;

        //mengatur Layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua elemen ke arrayList
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        //cek kondisi apakah view null atau tidak
        if (view == null){
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk TextView
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpa data dalam tampilkan tanpa menggunakan struktur data lain
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        return view;
    }
}
