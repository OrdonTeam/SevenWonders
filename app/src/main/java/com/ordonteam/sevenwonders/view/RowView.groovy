package com.ordonteam.sevenwonders.view

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import com.ordonteam.sevenwonders.R
import groovy.transform.CompileStatic

import static com.ordonteam.sevenwonders.view.common.AttributeExtractor.extractBooleanAttribute
import static com.ordonteam.sevenwonders.view.common.AttributeExtractor.extractIntAttribute
import static com.ordonteam.sevenwonders.view.common.AttributeExtractor.extractStringAttribute
import static com.ordonteam.sevenwonders.view.common.DefaultViews.weightedEditText
import static com.ordonteam.sevenwonders.view.common.DefaultViews.weightedTextView

@CompileStatic
class RowView extends LinearLayout {
    private int columnsNumber = 3
    private String rowLabel
    private int inputType
    private List<EditText> editTexts = new ArrayList<>()

    RowView(Context context, AttributeSet attrs) {
        super(context, attrs)
        inputType = extractIntAttribute(context, attrs, R.styleable.RowView_android_inputType)
        boolean isMinusable = extractBooleanAttribute(context, attrs, R.styleable.RowView_isMinusable)
        rowLabel = extractStringAttribute(context, attrs, R.styleable.RowView_android_text)
        addView(weightedTextView(context,rowLabel))
        7.times {
            EditText editText = weightedEditText(context,inputType)
            if(isMinusable) editText.text = '-'
            addView(editText)
            editTexts.add(editText)
        }
        updateVisibleColumns()
    }


    int getValue(int column) {
        String value = editTexts[column].getText()
        return value.isInteger() ? value.toInteger() : 0
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

    void setSumAt(int column, int sum) {
        editTexts[column].setText("$sum")
    }
}
