package com.ordonteam.sevenwonders.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import groovy.transform.CompileStatic

@CompileStatic
class RowViews extends LinearLayout{
    private int columnsNumber = 3

    RowViews(Context context) {
        super(context)
    }

    RowViews(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    RowViews(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }

    void setColumnsNumber(int number){
        columnsNumber = number
        for(int i = 0; i < childCount; i++){
            ((RowView)getChildAt(i)).setColumnsNumber(number)
        }
    }

    void addColumn(){
        columnsNumber++
        for(int i = 0; i < childCount; i++){
            ((RowView)getChildAt(i)).addColumn()
        }
    }

    void removeColumn(){
        columnsNumber--
        for(int i = 0; i < childCount; i++){
            ((RowView)getChildAt(i)).removeColumn()
        }
    }

    void sum() {
        for(int column=0;column<columnsNumber;column++){
            int sum = 0;
            for(int i = 0; i < childCount-1; i++){
                sum += ((RowView)getChildAt(i)).getValue(column)
            }
            ((RowView)getChildAt(childCount - 1 )).setSumAt(column,sum)
        }
    }
}
