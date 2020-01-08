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

public class DialogoRespuesta extends DialogFragment {

    OnDialogoSINOListener dialogoSINOListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dialogoSINOListener = (OnDialogoSINOListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dialogoSINOListener= null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle(R.string.tituloRespuesta);
        dialogo.setMessage(R.string.mensajeSiNo);
        dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // System.out.println("Pulsado SI");
                dialogoSINOListener.onDialogSelected("SI");
            }
        });
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //System.out.println("Pulsado NO");
                dialogoSINOListener.onDialogSelected("NO");
            }
        });

        dialogo.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // System.out.println("Pulsado Cancel");
                dialogoSINOListener.onDialogSelected("Cancelar");
            }
        });

        return dialogo.create();
    }


    public interface OnDialogoSINOListener{
        void onDialogSelected(String s);
    }
}
