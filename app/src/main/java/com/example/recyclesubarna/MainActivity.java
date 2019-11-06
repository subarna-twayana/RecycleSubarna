package com.example.recyclesubarna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.recyclesubarna.adapter.AdapterView;
import com.example.recyclesubarna.model.DetailsClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txname,txage;
    RadioButton rbf, rbm;
    RadioGroup radioGroup;
    Spinner spinnering;
    RecyclerView viewR;
    Button btnsave;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txname=findViewById(R.id.txtname);
        txage=findViewById(R.id.txtage);
        rbf=findViewById(R.id.rbf);
        rbm=findViewById(R.id.rbm);
        spinnering=findViewById(R.id.spinimg);
        viewR=findViewById(R.id.recycleV);
        btnsave=findViewById(R.id.btnsave);
        radioGroup=findViewById(R.id.genderG);

        final List<DetailsClass> detailsClasses= new ArrayList<>();
        final int[]title ={
                (R.drawable.anmol),
                (R.drawable.dai),
                (R.drawable.pooja),
                (R.drawable.flower2),
        };
        final String[] titlename={
                "anmol",
                "dai",
                "pooja",
                "flower2"
        };

        ArrayAdapter<String> imgtitle = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,titlename
        );
        spinnering.setAdapter(imgtitle);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectid=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton= findViewById(selectid);
                gender=radioButton.getText().toString();
                String name=txname.getText().toString();
                String age=(txage.getText().toString());
                int position = (spinnering.getSelectedItemPosition());
                int imageposition=title[position];
                detailsClasses.add(new DetailsClass(name,age,gender,imageposition));
                AdapterView adapterView= new AdapterView(MainActivity.this,detailsClasses);
                viewR.setAdapter(adapterView);
                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });

    }
}
