package com.example.eva1_pe_acredita_no_acredita;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mostrarPorcentaje;
    private TextView mostrarPorcentaje2;
    private SeekBar sbPuntos;
    private SeekBar sbCali;

    private int progressBar1;
    private int progressBar2;
    private TextView txtVwAcreditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txtVwAcreditar = findViewById(R.id.txtVwAcreditar);

        mostrarPorcentaje = (TextView)findViewById(R.id.txtVwPuntos);
        mostrarPorcentaje2 = findViewById(R.id.txtVwCali);

        sbPuntos = findViewById(R.id.sbPuntos);
        sbPuntos.setProgress(0);
        sbPuntos.setMax(100);
        sbPuntos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mostrarPorcentaje.setText(String.valueOf(progress)+" ");
                setProgressBar1(progress);
                acreditar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbCali = findViewById(R.id.sbCali);
        sbCali.setProgress(0);
        sbCali.setMax(100);
        sbCali.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mostrarPorcentaje2.setText(String.valueOf(progress)+" ");
                setProgressBar2(progress);
                acreditar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void acreditar(){
        if(progressBar2>=progressBar1){
            txtVwAcreditar.setText("ACREDITADO!!!!");

        }else{
            txtVwAcreditar.setText("NO ACREDITADO");

        }

    }

    public int getProgressBar1() {
        return progressBar1;
    }

    public void setProgressBar1(int progressBar1) {
        this.progressBar1 = progressBar1;
    }

    public int getProgressBar2() {
        return progressBar2;
    }

    public void setProgressBar2(int progressBar2) {
        this.progressBar2 = progressBar2;
    }
}