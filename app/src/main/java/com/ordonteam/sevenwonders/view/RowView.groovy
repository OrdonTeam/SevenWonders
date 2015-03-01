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
class RowView extends LinearLayout{
    private int columnsNumber
    private String rowLabel
    private int inputType

    RowView(Context context) {
        super(context)
        this.columnsNumber=3
    }

    RowView(Context context, AttributeSet attrs) {
        super(context, attrs)
        this.columnsNumber=3
        extractAttributes(context, attrs)
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1)
        TextView textView = new TextView(context)
        textView.setText(this.rowLabel)
        textView.setLayoutParams(layoutParams)
        addView(textView)
        EditText editText;
        for(int i = 0; i <= 7; i++){
            editText = new EditText(context)
            editText.setInputType(this.inputType)
            editText.setLayoutParams(layoutParams)
            addView(editText)
        }
    }

    private extractAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RowView,
                0, 0)

        try {
            this.rowLabel = a.getString(R.styleable.RowView_text)
            this.inputType = a.getInteger(R.styleable.RowView_android_inputType, 0)
        } finally {
            a.recycle()
        }
    }

    RowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
        this.columnsNumber=3
        extractAttributes(context,attrs)
    }

    int getValue(int column){
        EditText editText = (EditText)getChildAt(column+1)
        return editText.getText().toInteger()?:0
    }

    void setColumnsNumber(int number){
        this.columnsNumber=number
    }

    void addColumn(){
        this.columnsNumber++
    }

    void removeColumn(){
        this.columnsNumber--
    }

    void updateVisibleColumns(){
        for(int i = columnsNumber + 1; i <= 8; i++){
            getChildAt(i).setVisibility(GONE)
        }
    }

    /*<!-- <TextView
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight="1"
    android:text="@string/playerName" />

    <EditText
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight="1"
    android:inputType="text" />-->*/
 }
