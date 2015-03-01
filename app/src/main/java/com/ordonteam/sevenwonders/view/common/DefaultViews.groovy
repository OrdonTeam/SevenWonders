package com.ordonteam.sevenwonders.view.common

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import groovy.transform.CompileStatic

import static com.ordonteam.sevenwonders.view.common.DefaultLayouts.horizontalWeight1

@CompileStatic
class DefaultViews {
    static TextView weightedTextView(Context context,String text) {
        TextView textView = new TextView(context)
        textView.setText(text)
        textView.setLayoutParams(horizontalWeight1())
        return textView
    }

    static EditText weightedEditText(Context context, int inputType) {
        EditText editText = new EditText(context)
        editText.setInputType(inputType)
        editText.setLayoutParams(horizontalWeight1())
        return editText
    }
}
