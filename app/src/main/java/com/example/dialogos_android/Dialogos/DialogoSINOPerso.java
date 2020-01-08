package com.example.dialogos_android.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos_android.R;

public class DialogoSINOPerso extends DialogFragment {

    public String nombre;
    final static String TAG_ARG1= "nombre";

    public static DialogoSINOPerso newInstance(String nombre) {

        DialogoSINOPerso dialogoSINOPerso = new DialogoSINOPerso();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1, nombre);
        dialogoSINOPerso.setArguments(bundle);
        //this.nombre = nombre;
        return dialogoSINOPerso;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.nombre = this.getArguments().getString(TAG_ARG1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle(R.string.tituloRespuestaPerso);
        dialogo.setMessage(nombre+ " Estas seguro que deseas continuar?");
        return dialogo.create();
    }
}
