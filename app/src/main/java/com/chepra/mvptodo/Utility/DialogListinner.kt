package com.ehsankolivand.mvvmtodo.Utility

import com.chepra.mvptodo.Database.TaskModel


interface DialogListinner {
    fun addTaskToDatabase(task: TaskModel)
}