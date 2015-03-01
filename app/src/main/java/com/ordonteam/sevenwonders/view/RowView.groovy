package com.ordonteam.sevenwonders.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.ordonteam.sevenwonders.R
import groovy.transform.CompileStatic

@CompileStatic
class RowView extends LinearLayout {
    private int columnsNumber = 3
    private String rowLabel
    private int inputType
    private List<EditText> editTexts = new ArrayList<>()

    RowView(Context context, AttributeSet attrs) {
        super(context, attrs)
        extractAttributes(context, attrs)
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1)
        TextView textView = new TextView(context)
        textView.setText(rowLabel)
        textView.setLayoutParams(layoutParams)
        addView(textView)
        7.times {
            EditText editText = new EditText(context)
            editText.setInputType(inputType)
            editText.setLayoutParams(layoutParams)
            addView(editText)
            editTexts.add(editText)
        }
        updateVisibleColumns()
    }

    private extractAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RowView,
                0, 0)

        try {
            this.rowLabel = a.getString(R.styleable.RowView_android_text)
            this.inputType = a.getInteger(R.styleable.RowView_android_inputType, 0)
        } finally {
            a.recycle()
        }
    }

    int getValue(int column) {
        EditText editText = (EditText) getChildAt(column)
        String value = editText.getText()?: 0
        int intValue
        if(value=="" || !value.isInteger()){
            return 0
        } else {
            return value.toInteger()
        }
    }

    void setColumnsNumber(int number) {
        this.columnsNumber = number
        updateVisibleColumns()
    }

    void addColumn() {
        this.columnsNumber++
        updateVisibleColumns()
    }

    void removeColumn() {
        this.columnsNumber--
        updateVisibleColumns()
    }

    void updateVisibleColumns() {
        for (int i = columnsNumber + 1; i <= 7; i++) {
            getChildAt(i).setVisibility(GONE)
        }
        for (int i = 0; i <= columnsNumber; i++) {
            getChildAt(i).setVisibility(VISIBLE)
        }
    }
}
