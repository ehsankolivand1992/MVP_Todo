package com.chepra.mvptodo.main.mvpPackage

import android.content.Context
import com.chepra.mvptodo.Database.DaoMaster
import com.chepra.mvptodo.Database.DaoSession
import com.chepra.mvptodo.Database.TaskModel
import com.chepra.mvptodo.root.App


class TaskModels: MainMVP.Model{

    lateinit var daoSession: DaoSession
     var context: Context

    constructor(context: Context){

        this.context = context
        daoSession = (context as App).daoSession



    }

    override fun SaveUser(taskModel: TaskModel): Long {
        return daoSession.taskModelDao.insert(taskModel)

    }
}