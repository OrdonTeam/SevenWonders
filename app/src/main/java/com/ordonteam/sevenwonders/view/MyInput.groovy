package com.ordonteam.sevenwonders.view;

import android.content.Context
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.ordonteam.sevenwonders.dialog.DialogWindow
import groovy.transform.CompileStatic;

@CompileStatic
public class MyInput extends TextView implements View.OnClickListener {


    MyInput(Context context) {
        super(context)
        setOnClickListener(this);
    }

    MyInput(Context context, AttributeSet attrs) {
        super(context, attrs)
        setOnClickListener(this);
    }

    MyInput(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
        setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new DialogWindow(getContext(), {String newValue ->
                setText(newValue);
        }).show()
    }
}
