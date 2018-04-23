package com.example.jessica.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {


    VoluntarioList voluntarios = new VoluntarioList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = getIntent();

        voluntarios.getVoluntarios();


        List<String> programas = voluntarios.returnAllProgramas();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, programas);

        final Spinner spinnerVol = (Spinner) findViewById(R.id.vol);

        final Spinner spinnerCri = (Spinner) findViewById(R.id.cri);

        spinnerVol.setAdapter(adapter);



        spinnerVol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedPrograma = String.valueOf(spinnerVol.getSelectedItem());

                List<String> voluntarioLocal = voluntarios.returnVoluntariosByPrograma(selectedPrograma);

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, voluntarioLocal);


                spinnerCri.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spinnerCri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedPrograma = String.valueOf(spinnerVol.getSelectedItem());
                String selectedLocal = String.valueOf(spinnerCri.getSelectedItem());


                String result = voluntarios.returnNome(selectedPrograma, selectedLocal);

                TextView resultArea = (TextView) findViewById(R.id.result);

                resultArea.setText(result);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

}