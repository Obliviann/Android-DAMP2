package com.liv.damp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

//ACTIVITY : A core Android class responsible for drawing an app user inerface and receiving input evens
//They have an associated layout files (XML) with VIEW tags (text, images, buttons). They are connected by:
//LayoutInflation - process triggered when the act starts
//                  inflates views into Kotlin view objs in memory.

//AppCompatActivity-subclass of Android that gives: access to modern Android features + backwards compatibility with older versions
class MainActivity : AppCompatActivity() {

//Android does not have a main method, instead the AndroidManifest defines the MainActivity as the launching point for your app
    //Activities do NOT use Constructors to do their setup, instead they call a series of predefined methods:
    //1. onCreate - you will allways override.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2. setCV() - associates a layout to the activity, and inflates it
        //R- generated class (Resources) mapping of all the resources matched to the view ids that exist in the project
        setContentView(R.layout.activity_main)

        //they have implicit type specification
        val countButton = findViewById<Button>(R.id.count_button)
        val textView = findViewById<TextView>(R.id.value_textView) //TODO: as textView?
        var counter = 0

    //context obj - allows you to communicate with and get info about the current state of the android OS
    //An Activity is a subclass of Context
        countButton.setOnClickListener{
            counter = counter+1
            var string = counter.toString()
            //.text property is equivalent to getText() or setText() in Java
            textView.text = string
            println("the value is: $string")
        }

        val changeAct2Btn = findViewById<Button>(R.id.a02_button)

        changeAct2Btn.setOnClickListener{
            //To change to another activity
            startActivity(Intent(this@MainActivity, LinearLayoutAct::class.java))
        }
    }
}
