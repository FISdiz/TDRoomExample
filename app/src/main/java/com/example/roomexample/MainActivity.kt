package com.example.roomexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()

        val usersDao = UserRoomDatabase.getDatabase(application).usersDao()

        button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                //usersDao.insert(User(1, "juan", "ayala"))
                //usersDao.insert(User(2, "pericarpio", "poro"))
                usersDao.insert(User("Don", "Juanelo"))
                Toast.makeText(applicationContext, "Usuario agregado", Toast.LENGTH_LONG).show()
            }
        }

       CoroutineScope(Dispatchers.Main).launch {
            val all = usersDao.getAll()
            when(all.isEmpty()) {
                true -> textView.text = "No hay datos"
                false -> textView.text = "${all.size} - ${all[0]}"
            }
        }
    }

    private fun initLog() {
        Timber.plant(DebugTree())
    }

    private fun showUser() {

    }
}