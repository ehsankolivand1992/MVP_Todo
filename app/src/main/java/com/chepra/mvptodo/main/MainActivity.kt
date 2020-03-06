package com.chepra.mvptodo.main

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chepra.mvptodo.Database.TaskModel
import com.chepra.mvptodo.R
import com.chepra.mvptodo.Utility.FragmentListinner
import com.chepra.mvptodo.adapters.ViewPagerFragments
import com.chepra.mvptodo.main.mvpPackage.MainMVP
import com.chepra.mvptodo.root.App
import com.ehsankolivand.mvvmtodo.Utility.DialogListinner
import com.ehsankolivand.mvvmtodo.Utility.TaskDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(),FragDone.OnFragmentInteractionListener
    ,FragToDo.OnFragmentInteractionListener,MainMVP.View{

    lateinit var  mydialog: TaskDialog
    lateinit var fargtodo: FragToDo

    @Inject
    lateinit var presenter: MainMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (application as App).component.inject(this)
        mydialog = TaskDialog(this,presenter)

        initMain()
        initFab()

    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)

    }
    private fun initMain() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val adapter = ViewPagerFragments(supportFragmentManager)
        adapter.addFragment(FragToDo(), "Todo")
        adapter.addFragment(FragDone(), "Done")
         fargtodo = adapter.getItem(0) as FragToDo

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)
    }

    private fun initFab()
    {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        fab.setOnClickListener {
            mydialog.ShowTaskDialog()
            presenter.fabButtonClicked()

        }
    }

    override fun onFragmentInteraction(uri: Uri) {
    }

    override fun ShowDialog(txt: String) {
        Toast.makeText(applicationContext,txt,Toast.LENGTH_LONG).show()
    }

    override fun dismisDialog() {
        fargtodo.updatelist()

    mydialog.dismiseDialog()
    }
}
