package jp.vipsoft.timemanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.vipsoft.timemanagement.R
import kotlinx.android.synthetic.main.activity_setup.*

class SetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

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
    }
}
