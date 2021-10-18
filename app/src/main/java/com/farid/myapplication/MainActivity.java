package com.farid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher, AdapterView.OnItemClickListener {

    private List<Barang> listBarang;
    private ListView listView;
    private EditText editText;
    private Button button1;
    private ArrayAdapter<Barang> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_data);
        editText = findViewById(R.id.etInput);
        button1 = findViewById(R.id.button1);

        loadData();

        listView.setOnItemClickListener(this);
        editText.addTextChangedListener(this);

        button1.setOnClickListener(view -> {
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        });
    }

    void loadData() {
        listBarang = new ArrayList<>();
        listBarang.add(new Barang("barang 1", "sabun"));
        listBarang.add(new Barang("barang 2", "pakaian"));
        listBarang.add(new Barang("barang 3", "aksesori"));

        arrayAdapter = new ArrayAdapter<Barang>(this, R.layout.support_simple_spinner_dropdown_item, listBarang);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.toString().isEmpty()){
            listView.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.VISIBLE);
        }
        arrayAdapter.getFilter().filter(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}