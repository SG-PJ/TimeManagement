package jp.vipsoft.timemanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import kotlinx.android.synthetic.main.activity_calendar.*

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(jp.vipsoft.timemanagement.R.layout.activity_calendar)

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


        val toDay = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo")).timeInMillis
        Viewcalendar.setDate(toDay, true, true)

        Viewcalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // カレンダーの選択日付をセット
            val setDate = year.toString() + "/" + month + 1.toString() + "/" + dayOfMonth.toString()

            // 作業時間（休日）
            val holidayTime = findViewById<TextView>(jp.vipsoft.timemanagement.R.id.workTimeHolidayValue)
            holidayTime.text = setDate
        }

        fun calcWorkTime(start: String, end: String): String{
            return "$start + $end"
        }

        val start = "9:30"
        val end = "18:30"

        // 出社時刻
        val startTime = findViewById<TextView>(jp.vipsoft.timemanagement.R.id.startTimeValue)
        startTime.text = start
        // 退社時刻
        val endTime = findViewById<TextView>(jp.vipsoft.timemanagement.R.id.endTimeValue)
        endTime.text = end
        // 作業時間（所定内）
        val workTime = findViewById<TextView>(jp.vipsoft.timemanagement.R.id.workTimeValue)
        workTime.text = calcWorkTime(start, end)
        // 作業時間（時間外）

        // 深夜時間（内役）
        // 合計時間
        // 精算対象時間
    }
}
