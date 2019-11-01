package jp.vipsoft.timemanagement.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import jp.vipsoft.timemanagement.R
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {

            val auth = FirebaseAuth.getInstance()

            Log.d("TAG", "login !!!!!!!")

            val emailEditText = findViewById<EditText>(R.id.emailEditText)
            val emailText = emailEditText.text.toString()

            val passEditText = findViewById<EditText>(R.id.editPassword)
            val passText = passEditText.text.toString()

            Log.i("TAG", emailText)
            Log.i("TAG", passText)

            auth.signInWithEmailAndPassword(emailText, passText)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "signUp 成功", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.w("TAG", "signInWithEmail:failure")
                        Toast.makeText(baseContext, "signUp 失敗", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}
