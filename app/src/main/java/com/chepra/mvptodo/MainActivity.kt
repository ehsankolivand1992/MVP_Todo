package com.chepra.mvptodo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chepra.mvptodo.Database.TaskModel
import com.chepra.mvptodo.root.App
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tm: TaskModel = (application as App).daoSession.taskModelDao.load(1L)
        Toast.makeText(this,tm.title,Toast.LENGTH_LONG).show()

    }
}
