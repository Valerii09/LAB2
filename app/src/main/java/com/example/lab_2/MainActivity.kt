package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.Touch
import android.text.method.Touch.scrollTo
import android.util.Log
import android.view.*
import android.view.ViewGroup
import android.widget.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            arr = ArrayList(savedInstanceState.getIntArray("array")!!.toList())
        }
        Log.i("MyInfo", "Метод onCreate")
        setContentView(R.layout.activity_main)

        val ySaved = findViewById<ScrollView>(R.id.ScrollView)

        if (savedInstanceState != null) {

            val count = savedInstanceState.getInt("viewsCount")
            for (i in 0 until count)
                addTextView(arr[i])
            if (savedInstanceState != null) {
                ySaved.scrollY = savedInstanceState.getInt("scroll")
            }

        }

    }


    override fun onStart() {
        super.onStart()
        Log.i("MyInfo", "Метод onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("MyInfo", "Метод onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MyInfo", "Метод onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyInfo", "Метод onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyInfo", "Метод onDestroy")
    }

    fun buttonAddClick(view: View) {
        addTextView()

    }
    fun addButton(view: View) {
        addButton()
    }


    private var viewsCount = 0

    var array: MutableList<Int> = mutableListOf()
    var arr =ArrayList<Int>()


    fun rand(a: Int): Int {
        for (i in 0..100){
            array.add(Random.nextInt(1,100))
        }
        return array[a]
    }

    fun addTextView(n: Int = -1) {
        val textView = TextView(this)
        if (n == -1){
            textView.text = rand(viewsCount).toString()
            arr += rand(viewsCount)
        }
        else {
            textView.text = n.toString()
        }

        viewsCount++
        textView.textSize = 24f

        val container = findViewById<LinearLayout>(R.id.innerContainer)
        container.addView(textView)
        Log.i("MyInfo", "Метод addTextView")



    }




    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putInt("scrollView", y)
        val y = findViewById<ScrollView>(R.id.ScrollView)
        val scrollPosition = y.scrollY
        outState.putInt("viewsCount", viewsCount)
        outState.putIntArray("array", arr.toIntArray())
        outState.putInt("scroll",scrollPosition)
    }


    fun addButton() {
        val button = Button(this)
        button.text = "Кнопка № " + viewsCount.toString()
        button.tag = viewsCount
        button.setOnClickListener {it ->
            val toast = Toast.makeText(this,
                "Нажата кнопка ${ it.tag }",
                Toast.LENGTH_SHORT)
            toast.show();}
        val container: ViewGroup = findViewById(R.id.innerContainer)
        container.addView(button)
        Log.i("MyInfo", "Метод addButton")
    }


}