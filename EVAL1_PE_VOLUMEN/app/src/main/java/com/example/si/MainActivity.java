package com.example.si;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView txtAngulo;
    public SeekBar sbAngulo;
    public EditText edtxtRadio;
    public ImageView imgc;
    public LinearLayout lin;
    Button btnCalcular;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        txtAngulo = findViewById(R.id.textView3);
        sbAngulo = findViewById(R.id.seekBar);
        edtxtRadio = findViewById(R.id.editTextNumberDecimal);
        btnCalcular = findViewById(R.id.btnCalcular);
        imgc = findViewById(R.id.imgc);
        lin = findViewById(R.id.lin);
        sbAngulo.setMax(360);

        sbAngulo.setProgress(0);

        sbAngulo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAngulo.setText(""+ progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Double a = Double.valueOf(txtAngulo.getText().toString());

                    Double r = Double.valueOf(edtxtRadio.getText().toString());

                    double vol = Math.PI * (Math.pow(r, 3)) * (a / 270);
                    Toast.makeText(getApplicationContext(), "El Volumen es: " + vol, Toast.LENGTH_SHORT).show();
                }
                //En caso de tener valores nulos en las variables del problema
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ponga un valor de radio plox"+e,Toast.LENGTH_SHORT ).show();
                }
            }
        });

    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtxtRadio.getWindowToken(), 0);
    }


}