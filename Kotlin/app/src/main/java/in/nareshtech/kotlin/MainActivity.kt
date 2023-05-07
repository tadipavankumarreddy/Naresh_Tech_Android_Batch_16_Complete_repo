package `in`.nareshtech.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.textView2)
        val b : Button = findViewById(R.id.button);

        b.setOnClickListener(View.OnClickListener {
            count++
            tv.text = ""+count
        })
    }
}