package com.ehsankolivand.mvvmtodo.Utility

import com.chepra.mvptodo.Database.TaskModel

interface AdapterEventistinner {

    fun delete(task: TaskModel)
    fun edit(task: TaskModel)
    fun done(task: TaskModel)
}