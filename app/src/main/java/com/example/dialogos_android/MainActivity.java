package com.example.dialogos_android;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialogos_android.Dialogos.DialogoInformacion;
import com.example.dialogos_android.Dialogos.DialogoRespuesta;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , DialogoRespuesta.OnDialogoSINOListener{
    Button btnDialogInfo, btnDialogSiNo;
    TextView txtDialogInfo, txtRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnDialogInfo.setOnClickListener(this);
        btnDialogSiNo.setOnClickListener(this);
    }

    private void instancias() {
        btnDialogInfo = findViewById(R.id.btnDialogoInfo);
        txtDialogInfo = findViewById(R.id.txtInfo);
        btnDialogSiNo = findViewById(R.id.btnDialogoResouesta);
        txtRespuesta = findViewById(R.id.txtRespuesta);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDialogoInfo:
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(),"ejemploInfo");
                break;
            case R.id.btnDialogoResouesta:
                DialogoRespuesta dialogoRespuesta = new DialogoRespuesta();
                dialogoRespuesta.show(getSupportFragmentManager(), "respuestaSINO");
                break;

        }
    }

    @Override
    public void onDialogSelected(String s) {
        Toast.makeText(getApplicationContext(),"La opcion selecionada es:"+s, Toast.LENGTH_SHORT).show();
    }
}
