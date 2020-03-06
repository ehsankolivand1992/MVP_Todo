package com.chepra.mvptodo.main.mvpPackage

import android.util.Log
import android.widget.Toast
import androidx.annotation.Nullable
import com.chepra.mvptodo.Database.TaskModel


class MainPresenter : MainMVP.Presenter {

    @Nullable
    private lateinit var view: MainMVP.View
    private lateinit var model: MainMVP.Model


    constructor(model: MainMVP.Model){
        this.model = model
    }

    override fun setView(view: MainMVP.View) {
        this.view = view
    }

    override fun fabButtonClicked() {


    }

    override fun saveTask(taskModel: TaskModel) {

        Log.i("okeeey","okeeeeeeeeeey")

    }

    override fun dialog_btnSaveClicked(title: String, desctipion: String, labelValue: Int) {
        if (title.isNotEmpty())
        {
            if (desctipion.isNotEmpty())
            {
                val task = TaskModel(null,title,desctipion,labelValue,false)
                var taskListSize = model.SaveUser(task)
               if (taskListSize > 0)
                {
                    view.ShowDialog("Task saved")
                    view.ShowDialog("$taskListSize")

                }else{
                    view.ShowDialog("you have a problem please contact with us")
                }

                view.dismisDialog()




            }else{
                view.ShowDialog("Please Enter a Description")
            }
        }else{
            view.ShowDialog("Please Enter a title")

        }

    }
}