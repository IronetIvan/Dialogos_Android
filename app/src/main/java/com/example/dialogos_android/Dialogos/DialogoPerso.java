package com.example.dialogos_android.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos_android.R;


public class DialogoPerso extends DialogFragment {

    EditText txtnombre, txtpasswd;
    Button btnloggin;
    View vista;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_perso, null);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        instancias();
        AlertDialog.Builder dialogo_perso = new AlertDialog.Builder(getContext());
        View vista = LayoutInflater.from(getContext()).inflate(R.layout.dialogo_perso, null);
        dialogo_perso.setView(vista);
        return dialogo_perso.create();
    }

    private void instancias() {
        txtnombre = vista.findViewById(R.id.nombre_dialogo);
        txtpasswd = vista.findViewById(R.id.passwd_dialogo);
        btnloggin = vista.findViewById(R.id.btn_dialogo);
    }
}
