package com.chepra.mvptodo.main.mvpFragmentsPack

import android.content.Context
import com.chepra.mvptodo.Database.DaoMaster
import com.chepra.mvptodo.Database.DaoSession
import com.chepra.mvptodo.Database.TaskModel
import com.chepra.mvptodo.Database.TaskModelDao
import com.chepra.mvptodo.root.App
import org.greenrobot.greendao.rx.RxDao
import org.greenrobot.greendao.rx.RxQuery


class FragModel:FragsMVP.Model {

     var daoSession: DaoSession
    var context: Context
    private lateinit var taskQuery: RxQuery<TaskModel>

    constructor(context: Context){

        this.context = context
         daoSession = (context as App).daoSession


    }




    override fun delete(taskModels: TaskModel) {
        daoSession.delete(taskModels)

    }

    override fun update(taskModels: TaskModel) {
        daoSession.update(taskModels)
    }

    override fun done(taskModel: TaskModel) {
        daoSession.update(taskModel)
    }

    override fun allTask(): List<TaskModel> {


        return daoSession.taskModelDao.queryBuilder().where(TaskModelDao.Properties.Done.eq(0)).list()

    }

    override fun workedDoneTask(): List<TaskModel> {
        return daoSession.taskModelDao.queryBuilder().where(TaskModelDao.Properties.Done.eq(1)).list()
    }
}