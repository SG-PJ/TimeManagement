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

            /*
            読み込みテスト START
            val db = FirebaseFirestore.getInstance()
            db.collection("user")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            Log.d("TAG", document.id + " => " + document.data)
                        }
                    } else {
                        Log.w("loglog", "Error getting documents.", task.exception)
                    }
                }
            読み込みテスト END
            */

            /*
             書き込みテスト START
            Log.d("TAG", "write click!!!!!!!!!!!!!! ")

            val test = HashMap<String, Any>().apply {
                put("specified_time", 1)
                put("service_system_id", 2)
                put("scheduled_working_to", 3)
                put("scheduled_working_from", 4)
                put("break_time_one", 5)
                put("break_time_two", 6)
                put("break_time_three", 7)
                put("break_time_four", 8)
                put("break_time_five", 9)
            }

            val db2 = FirebaseFirestore.getInstance()
            db2.collection("user")
                .add(test)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot added with ID:" + documentReference.id)
                    Toast.makeText(this, "登録しました。", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                        e -> Log.w("MainActivity", "Error adding document", e)
                }
            書き込みテスト END
            */

            /*
            更新テスト START
            val db3 = FirebaseFirestore.getInstance()
            val ref = db3.collection("user").document("zPATBPCcIpUz5UZk2sQ5")
            ref.update("specified_time", 11)
                .addOnSuccessListener { Log.d("TAG", "DocumentSnapshot successfully updated!") }
                .addOnFailureListener {e -> Log.e("TAG", "Error updating document", e)}
            更新テスト END
             */

        }

    }
}
