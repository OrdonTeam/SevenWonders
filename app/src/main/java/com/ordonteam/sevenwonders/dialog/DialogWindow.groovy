package com.ordonteam.sevenwonders.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.ordonteam.sevenwonders.R
import groovy.transform.CompileStatic

@CompileStatic
class DialogWindow extends AlertDialog.Builder{
    EditText inputValue
    private Closure callback
    private AlertDialog dialog

    public DialogWindow(Context activity, Closure callback) {
        super(activity);
        this.callback = callback
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE )
        View view = inflater.inflate(R.layout.dialog_window, null);
        inputValue = (EditText) view.findViewById(R.id.inputValue)
        view.findViewById(R.id.confirmButton).setOnClickListener({
            onConfirmButtonClicked()
        });
        setView(view);
    }

    @Override
    AlertDialog show() {
        dialog = super.show()
        return this.dialog
    }

    void onConfirmButtonClicked(){
        callback(inputValue.getText().toString())
        dialog.dismiss()
    }
}


