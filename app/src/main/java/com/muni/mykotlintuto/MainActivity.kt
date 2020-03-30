package com.muni.mykotlintuto

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    private lateinit var animatable: Animatable
    companion object {
        val log = Logger.getLogger(MainActivity::class.java.name)
    }
    var recyclerView: RecyclerView? = null
    var startButton1:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycler_main_actvity)
        startButton1=findViewById(R.id.startButton)
        animatable = animatedImageView.drawable as Animatable
        animatable.start()

        var adapter = MainActivityAdapter(generateData())
        val layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()

       // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.about_me,menu)
        return super.onCreateOptionsMenu(menu)

    }
    private fun generateData(): ArrayList<UserDto> {
        var result = ArrayList<UserDto>()

        for (i in 0..9) {
            var user: UserDto = UserDto("Muni", "Android ;)")
            result.add(user)
        }

        return result
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.about_me -> {
                Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()
                AlertDialog.Builder(this)
                    .setView(R.layout.about_me)
                    .create()
                    .show()
               return true
            }
            R.id.animator -> {
                animatable = animatedImageView.drawable as Animatable
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onStart() {
        super.onStart()
            startButton.setOnClickListener {
                animatable.start()

        }
        log.info("onStart Called")
        Toast.makeText(this,"onStart Called",Toast.LENGTH_LONG).show()
    }
/* Activity Life cycles*/
   /* override fun onRestart() {
        super.onRestart()
        log.info("OnRestart Called")
        Toast.makeText(this,"OnRestart Called",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        log.info("OnResume Called")
        Toast.makeText(this,"OnResume Called",Toast.LENGTH_LONG).show()
    }


    override fun onStop() {
        super.onStop()
        log.info("OnStop Called")
        Toast.makeText(this,"OnStop Called",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        log.info("OnPause Called")
        Toast.makeText(this,"OnPause Called",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        log.info("OnDestroy Called")
        Toast.makeText(this,"OnDestroy Called",Toast.LENGTH_LONG).show()
    }*/
/*for navigate the Fingerprint Activity Screen*/
    fun openFingerPrintActivity(view: View) {
        val intent=Intent(this,FingerPrintActivity::class.java)
        startActivity(intent)
    }

    fun openCirculartActivity(view: View) {
        val i=Intent(this,CircularActivity::class.java)
        startActivity(i)
    }


}
