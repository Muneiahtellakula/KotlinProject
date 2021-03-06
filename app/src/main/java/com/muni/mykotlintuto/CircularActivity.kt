package com.muni.mykotlintuto

import android.content.res.ColorStateList
import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import android.view.View
import android.view.ViewAnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.about_me.*
import kotlinx.android.synthetic.main.activity_circular.*
import kotlin.math.hypot


class CircularActivity : AppCompatActivity() {

    var isOpen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular)

        floating_button.setOnClickListener {
            revealMenu()
        }
    }

    private fun revealMenu() {
        if (!isOpen) {
            val x = main_layout.right
            val y = main_layout.bottom

            val startRadius = 0
            val endRadius = hypot(main_layout.width.toDouble(), main_layout.height.toDouble())

            floating_button.backgroundTintList = ColorStateList.valueOf(ResourcesCompat
                .getColor(applicationContext.resources, android.R.color.white, null))
            floating_button.setImageResource(R.drawable.ic_close_black_24dp)
            if (Build.VERSION.SDK_INT >= 21) {
                val anim = ViewAnimationUtils.createCircularReveal(menu_layout,
                    x, y, startRadius.toFloat(), endRadius.toFloat())
                //duration can be custom according to you even can be left and default value will be taken
                //in ms
                anim.duration=800
                menu_layout.visibility = View.VISIBLE
                anim.start()
                isOpen = true
            } else {
                //When below API 21 for example in Kitkat
                menu_layout.visibility = View.VISIBLE
                isOpen = true
            }
        } else {
            val x = layout_text.left
            val y = layout_text.top

            val startRadius = 0
            val end = hypot(main_layout.width.toDouble(), main_layout.height.toDouble())

            floating_button.backgroundTintList = ColorStateList.valueOf(ResourcesCompat
                .getColor(applicationContext.resources, R.color.colorPrimary, null))
            floating_button.setImageResource(R.drawable.ic_add_white_24dp)
            if (Build.VERSION.SDK_INT >= 21) {
                val anim = ViewAnimationUtils.createCircularReveal(layout_text,
                    x, y, startRadius.toFloat(), end.toFloat())
                //duration can be custom according to you even can be left and default value will be taken
                //in ms
                anim.duration=800
                anim.addListener(object : AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        menu_layout.visibility = View.GONE
                    }
                })
                anim.start()
                isOpen = false
            } else {
                //When below API 21 for example in Kitkat
                menu_layout.visibility = View.GONE
                isOpen = false
            }
        }
    }

    fun bt_one_Event(view: View) {
        val layout = layoutInflater.inflate(R.layout.about_me,linearlayout)
        val myToast = Toast(applicationContext)
        myToast.duration = Toast.LENGTH_LONG
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.view = layout//setting the view of custom toast layout
        myToast.show()
        Toast.makeText(this,"Hi",Toast.LENGTH_SHORT).show()
    }
    fun bt_2_Event(view: View) {
        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
    }
}