package com.farid.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private int ongkir = 100000;
    private EditText etDiskon;
    private TextView txTotalOngkir, txJarak;
    private Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etDiskon = findViewById(R.id.etInputDisc);
        txTotalOngkir = findViewById(R.id.txTotalOngkir);
        txJarak = findViewById(R.id.txJarak);
        btnHitung = findViewById(R.id.btnHitung);

        btnHitung.setOnClickListener(view -> {
            txJarak.setText(getJarak(-7.797068, 110.370529, -7.550676, 110.828316));
            txTotalOngkir.setText(hitungOngkir(etDiskon.getText().toString().trim(), ongkir));
        });
    }

    private String getJarak(double lat1, double long1, double lat2, double long2) {
        double earthRadius = 3958.75;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLong = Math.toRadians(long2 - long1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1)) *
                Math.cos(Math.toRadians(lat2)) * Math.sin(dLong / 2) * Math.sin(dLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double jarak = earthRadius * c;
        int meterConversion = 1609;
        double myDist = jarak * meterConversion;
        return String.valueOf(Math.floor(myDist / 1000));
    }

    private String hitungOngkir(String voucher, int ongkir) {
        if (voucher.equals("ongkir5")) {
            return String.valueOf(ongkir - 5000);
        } else if (voucher.equals("disc35")) {
            double disc = ongkir * (0.35);
            if (disc > 35000){
                disc = 35000;
            }
            return String.valueOf(ongkir - disc);
        } else {
            return String.valueOf(ongkir);
        }
    }
}