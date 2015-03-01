package com.ordonteam.sevenwonders.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import groovy.transform.CompileStatic

@CompileStatic
class RowViews extends LinearLayout{
    RowViews(Context context) {
        super(context)
    }

    RowViews(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    RowViews(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }
}
