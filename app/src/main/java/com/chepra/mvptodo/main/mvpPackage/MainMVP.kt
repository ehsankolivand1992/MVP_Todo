package com.chepra.mvptodo.main.mvpPackage

import com.chepra.mvptodo.Database.TaskModel

interface MainMVP {

    interface Model{
        fun SaveUser(taskModel: TaskModel): Long


    }
    interface View{
        fun ShowDialog(txt: String)
        fun dismisDialog()


    }
    interface Presenter{
        fun setView(view: View)
        fun fabButtonClicked()
        fun saveTask(taskModel: TaskModel)
        fun dialog_btnSaveClicked(title: String, desctipion: String,labelValue: Int)





    }

}