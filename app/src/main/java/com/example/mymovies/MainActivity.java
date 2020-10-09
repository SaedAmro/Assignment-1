package com.example.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.simple_spinner_dropdown_item;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        /*spinner.setOnItemSelectedlistener(this);*/

        final AutoCompleteTextView actv1 = (AutoCompleteTextView)findViewById(R.id.actv1);
        final AutoCompleteTextView actv2 = (AutoCompleteTextView)findViewById(R.id.actv2);
        Button button = (Button)findViewById(R.id.button);
       final TextView tv = (TextView)findViewById(R.id.tv);
        ImageView img1 = (ImageView)findViewById(R.id.img1);
        ImageView img2 = (ImageView)findViewById(R.id.img2);
         actv1.setThreshold(3);
actv2.setThreshold(6);



/*
         ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
*/
           actv1.setAdapter(adapter);

/*
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
*/
        actv2.setAdapter(adapter);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              actv1.showDropDown();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv2.showDropDown();

            }
        });

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String a = actv1.getText().toString();
                String a2 = actv2.getText().toString();
/*
             tv.setText(s + "  " + sl);
*/
            }
        });

    }
     private static final String[] yers = new String[]{"2020","2019"};
    private static final String[] name = new String[]{",,,,,,,,,","........"};

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}