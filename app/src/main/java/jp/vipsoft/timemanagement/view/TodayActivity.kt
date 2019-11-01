package jp.vipsoft.timemanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import jp.vipsoft.timemanagement.R
import kotlinx.android.synthetic.main.activity_today.*


class TodayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnToDay.setOnClickListener {
            val intent = Intent(this, TodayActivity::class.java)
            startActivity(intent)
        }

        btnCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }

        btnSetUp.setOnClickListener {
            val intent = Intent(this, SetupActivity::class.java)
            startActivity(intent)
        }

        val timeZone = TimeZone.getTimeZone("Asia/Tokyo")
        val cal = Calendar.getInstance(timeZone)
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DATE)
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val min = cal.get(Calendar.MINUTE)

        val date = findViewById<TextView>(R.id.txtTime)
        date.text = "${year}/${month}/${day}"

        val time = findViewById<TextView>(R.id.txtDate)
        time.text = "${hour}:${min}"
    }
}
