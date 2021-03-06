package com.example.dialogos_android;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialogos_android.Dialogos.DialogoFecha;
import com.example.dialogos_android.Dialogos.DialogoInformacion;
import com.example.dialogos_android.Dialogos.DialogoItem;
import com.example.dialogos_android.Dialogos.DialogoMultipleItem;
import com.example.dialogos_android.Dialogos.DialogoPerso;
import com.example.dialogos_android.Dialogos.DialogoRespuesta;
import com.example.dialogos_android.Dialogos.DialogoSINOPerso;
import com.example.dialogos_android.Dialogos.DialogoSingleItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoRespuesta.OnDialogoSINOListener ,
        DialogoSingleItem.OnDialogoItenSingleSelected{
    Button btnDialogInfo, btnDialogSiNo, btnDialogoPersoResp, btnDialogoRespItem, btnDialogoSimple, btnDialogoMultiple, btnDialogoPersonalizado, btnDialogoHora, btnDialogoFecha;
    TextView txtDialogInfo, txtRespuesta, txtDialogoPersoRes, txtDialogoItem, txtDialogoSingle, txtDialogoMultiple, txtDialogoPersonalizado;

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
        btnDialogoPersoResp.setOnClickListener(this);
        btnDialogoRespItem.setOnClickListener(this);
        btnDialogoSimple.setOnClickListener(this);
        btnDialogoMultiple.setOnClickListener(this);
        btnDialogoPersonalizado.setOnClickListener(this);
        btnDialogoFecha.setOnClickListener(this);
        btnDialogoHora.setOnClickListener(this);
    }

    private void instancias() {
        btnDialogInfo = findViewById(R.id.btnDialogoInfo);
        txtDialogInfo = findViewById(R.id.txtInfo);
        btnDialogSiNo = findViewById(R.id.btnDialogoResouesta);
        txtRespuesta = findViewById(R.id.txtRespuesta);
        btnDialogoPersoResp = findViewById(R.id.btnDialogoPersoRespuesta);
        txtDialogoPersoRes = findViewById(R.id.txtRespuestaPerso);
        btnDialogoRespItem = findViewById(R.id.btnDialogRespuestaItem);
        txtDialogoItem = findViewById(R.id.txtRespuestaItem);
        btnDialogoSimple = findViewById(R.id.btnDialogSingle);
        txtDialogoSingle = findViewById(R.id.txtRespuestaItemSingle);
        btnDialogoMultiple = findViewById(R.id.btnDialogRespuestaItemMultiple);
        txtDialogoMultiple = findViewById(R.id.txtRespuestaItemMultiple);
        btnDialogoPersonalizado = findViewById(R.id.btnDialogPersonalizado);
        txtDialogoPersonalizado = findViewById(R.id.txtDialogoPersonalizado);
        btnDialogoFecha = findViewById(R.id.boton_dialogo_fecha);
        btnDialogoHora = findViewById(R.id.boton_dialogo_hora);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDialogoInfo:
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "ejemploInfo");
                break;
            case R.id.btnDialogoResouesta:
                DialogoRespuesta dialogoRespuesta = new DialogoRespuesta();
                dialogoRespuesta.show(getSupportFragmentManager(), "respuestaSINO");
                break;
            case R.id.btnDialogoPersoRespuesta:
                DialogoSINOPerso dialogoSINoPerso = DialogoSINOPerso.newInstance("Ivan");
                dialogoSINoPerso.show(getSupportFragmentManager(), "respuestaPerso");
                break;
            case R.id.btnDialogRespuestaItem:
                DialogoItem dialogoItem = new DialogoItem();
                dialogoItem.show(getSupportFragmentManager(),"items");
                break;
            case R.id.btnDialogSingle:
                DialogoSingleItem dialogosingleItem = new DialogoSingleItem();
                dialogosingleItem.show(getSupportFragmentManager(), "single");
                break;

            case R.id.btnDialogRespuestaItemMultiple:
                DialogoMultipleItem dialogoMultiple = new DialogoMultipleItem();
                dialogoMultiple.show(getSupportFragmentManager(), "multiple");
                break;

            case R.id.btnDialogPersonalizado:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(),"personalizado");
                break;

            case R.id.boton_dialogo_fecha:
                DialogoFecha diaologoFecha= new DialogoFecha();
                diaologoFecha.show(getSupportFragmentManager(), "fecha");

        }
    }

    @Override
    public void onDialogSelected(String s) {
        //Toast.makeText(getApplicationContext(),"La opcion selecionada es:"+s, Toast.LENGTH_SHORT).show();
        txtRespuesta.setText(s);
    }

    @Override
    public void onSingleItemSelected(String item) {
        txtDialogoSingle.setText(item);
    }


    }

