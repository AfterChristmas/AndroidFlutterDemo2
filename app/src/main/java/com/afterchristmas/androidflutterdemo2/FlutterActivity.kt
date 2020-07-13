package com.afterchristmas.androidflutterdemo2

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import io.flutter.facade.Flutter
import io.flutter.view.FlutterView.FirstFrameListener
import kotlinx.android.synthetic.main.activity_flutter.*

class FlutterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter)
        var flutterView = Flutter.createView(this, lifecycle, "About")
        val layout =
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        val listeners = arrayOfNulls<FirstFrameListener>(1)
        listeners[0] = FirstFrameListener { anchor.setVisibility(View.VISIBLE) }
        flutterView.addFirstFrameListener(listeners[0])
        anchor.addView(flutterView, layout)
    }
}