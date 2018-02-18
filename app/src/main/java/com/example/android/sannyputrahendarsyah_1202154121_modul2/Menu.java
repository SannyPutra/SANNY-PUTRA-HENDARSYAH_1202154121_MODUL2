package com.example.android.sannyputrahendarsyah_1202154121_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class Menu extends AppCompatActivity {

    // untuk deklarasi objek
    private final LinkedList<String> makanan = new LinkedList<>();
    private final LinkedList<Integer> harga = new LinkedList<>();
    private final LinkedList<Integer> gambar = new LinkedList<>();
    private int mCount = 0;

    private RecyclerView mRecyclerView;
    private MenuAdapter mAdapter;

    // method ketika dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dummiesData();
        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // membuat adapter dan memanggil data yang akan ditampilkan
        mAdapter = new MenuAdapter(this, makanan, harga, gambar);
        // menghubungkan adaptor dengan RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // memberikan RecyclerView sebagai pengelola tata letak default.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void dummiesData(){
        for (int i = 0;i < 1; i++){
            // memberi dan memanggil nama untuk data yang ditampilkan
            makanan.add("Ayam Teriyaki");
            makanan.add("Ayam Katsu");
            makanan.add("Sapi Donburi");
            makanan.add("Sapi Teriyaki");
            makanan.add("Sapi Teppanyaki");
            makanan.add("Sushi Roll ala vvibu");
            makanan.add("Sashimi ala vvibu");
            makanan.add("Mie Udon ala vvibu");
            makanan.add("Mie Ramen ala vvibu");
            makanan.add("Ocha Panas/Dingin");
            makanan.add("Teh Hijau ala vvibu");

            // mamanggil harga
            harga.add(40000);
            harga.add(40000);
            harga.add(60000);
            harga.add(55000);
            harga.add(55000);
            harga.add(45000);
            harga.add(50000);
            harga.add(36500);
            harga.add(32500);
            harga.add(15000);
            harga.add(10000);

            // memanggil foto yang ada di drawable
            gambar.add(R.drawable.ayamteriyaki);
            gambar.add(R.drawable.ayamkatsu);
            gambar.add(R.drawable.sapidonburi);
            gambar.add(R.drawable.sapiteriyaki);
            gambar.add(R.drawable.sapiteppanyaki);
            gambar.add(R.drawable.sushi);
            gambar.add(R.drawable.sashimi);
            gambar.add(R.drawable.mieudon);
            gambar.add(R.drawable.mieramen);
            gambar.add(R.drawable.tehocha);
            gambar.add(R.drawable.tehhijau);
        }
    }
}
