package com.ordonteam.sevenwonders.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import groovy.transform.CompileStatic

@CompileStatic
class RowView extends LinearLayout{
    RowView(Context context) {
        super(context)
    }

    RowView(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    RowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }
}
