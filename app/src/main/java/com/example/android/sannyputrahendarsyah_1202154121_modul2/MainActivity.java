package com.example.android.sannyputrahendarsyah_1202154121_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // method ketika dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOrder(View view) {
        // apabila memilih Dine In dan klik pesan sekarang akan menampilkan pesan Dine In
        if (((RadioButton)findViewById(R.id.rbt_DineIn)).isChecked()){
            Intent intent = new Intent(this, DineIn.class);
            Toast.makeText(this, "Dine In", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            // apabila memilih Take Away dan klik pesan sekarang akan menampilkan pesan Take Away
        }else if (((RadioButton)findViewById(R.id.rbt_TakeAway)).isChecked()){
            Intent intent = new Intent(this, TakeAway.class);
            Toast.makeText(this, "Take Away", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(this,"Pilih salah satu terlebih dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}
