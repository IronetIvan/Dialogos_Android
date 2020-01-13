package com.example.dialogos_android.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoMultipleItem extends DialogFragment {

    private OnDialogoItemMultipleSelected listener;
    private int  posicion;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener= (OnDialogoItemMultipleSelected)context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] opciones = {"Opcion1", "Opcion2", "Opcion3", "Opcion4"};
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Titulo del dialogo multiple item");

        dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss();
                listener.onMultipleItemSelected(opciones[posicion]);
            }

        });
        return dialogo.create();
    }
       



    public interface OnDialogoItemMultipleSelected{
        public void onMultipleItemSelected(String item);
    }

}
