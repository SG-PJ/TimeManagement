package jp.vipsoft.timemanagement.action

import android.app.Application
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore


class CalendarAction : Application() {

    //cloud
    fun getData(db: FirebaseFirestore, collection:String, document:String){
        db.collection(collection)
            .document(document)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document != null && document.data != null) {
                        Log.d("TAG", "getData")
                        Log.d("TAG", "DocumentSnapshot data: " + document.data?.get("firstName"))
                    } else {
                        Log.d("TAG", "No such document")
                    }
                } else {
                    Log.d("TAG", "get failed with " + task.exception)
                }
            }
            .addOnFailureListener { e -> Log.d("TAG", "Error adding document" + e)}
    }


    fun getData2(db: FirebaseFirestore, collection:String){
        db.collection(collection)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document != null) {
                        Log.d("TAG", "getData2")
                        Log.d("TAG", "DocumentSnapshot data: " + collection)
                    } else {
                        Log.d("TAG", "No such document")
                    }
                } else {
                    Log.d("TAG", "get failed with " + task.exception)
                }
            }
            .addOnFailureListener { e -> Log.d("TAG", "Error adding document" + e)}
    }

    fun getData3(db: FirebaseFirestore, collection:String) {
        db.collection(collection)
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
        }
}