package com.example.dialogos_android.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos_android.R;

public class DialogoItem extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String[] ArrayOpciones = {"Opcion1", "Opcion2", "Opcion3"};

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle(R.string.tituloDialogoItems);

        dialogo.setItems(ArrayOpciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        return super.onCreateDialog(savedInstanceState);
    }
    public interface OnDialogoItemSelected{
        public void onDialogoItemSelected();
    }
}
