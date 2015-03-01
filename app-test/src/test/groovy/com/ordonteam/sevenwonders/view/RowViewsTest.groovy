package com.ordonteam.sevenwonders.view

import org.robolectric.Robolectric
import pl.polidea.robospock.RoboSpecification

class RowViewsTest extends RoboSpecification {
    def "RowViews has 7 rows at start"() {
        given:
        def rowViews = new RowViews(Robolectric.application)
        def rowView = Mock(RowView)
        rowViews.addView(rowView)

        when:
        rowViews.addColumn()

        then:
        1 * rowView.addColumn()

    }
}
