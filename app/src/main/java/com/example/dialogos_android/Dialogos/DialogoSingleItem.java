package com.example.dialogos_android.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos_android.R;

public class DialogoSingleItem extends DialogFragment {

    private OnDialogoItenSingleSelected listener;
    private int  posicion;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener= (OnDialogoItenSingleSelected)context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] opciones = {"Opcion1", "Opcion2", "Opcion3", "Opcion4"};
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Titulo del dialogo single item");

        dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss();
                listener.onSingleItemSelected(opciones[posicion]);
            }

        });
        return dialogo.create();
    }
       



    public interface OnDialogoItenSingleSelected{
        public void onSingleItemSelected(String item);
    }

}
