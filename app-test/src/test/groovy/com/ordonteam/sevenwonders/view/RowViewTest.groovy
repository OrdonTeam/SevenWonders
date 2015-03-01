package com.ordonteam.sevenwonders.view

import android.text.InputType
import android.widget.TextView
import org.robolectric.Robolectric
import org.robolectric.res.Attribute
import org.robolectric.shadows.RoboAttributeSet
import pl.polidea.robospock.RoboSpecification

class RowViewTest extends RoboSpecification {
    def "should display hello text"() {
        given:
        RoboAttributeSet attrs = new RoboAttributeSet(
                [new Attribute("android.R:attr/inputType", "2", "com.ordonteam.sevenwonders"),
                 new Attribute("android.R:attr/text", "title", "com.ordonteam.sevenwonders")], Robolectric.application.resources, RowView)
        def textView = new RowView(Robolectric.application, attrs)

        expect:
        textView.columnsNumber == 3
    }
}