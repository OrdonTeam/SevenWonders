package com.ordonteam.sevenwonders.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.ordonteam.sevenwonders.R
import groovy.transform.CompileStatic

@CompileStatic
class DialogWindow extends AlertDialog.Builder{

    public DialogWindow(Activity activity) {
        super(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_window, null);
        setView(view);
        show();
    }
}
