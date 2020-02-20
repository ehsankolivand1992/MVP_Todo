package com.chepra.mvptodo.root

import android.app.Application
import com.chepra.mvptodo.Database.DaoMaster
import com.chepra.mvptodo.Database.DaoSession
import com.chepra.mvptodo.Database.TaskModel
import dagger.Component


class App: Application() {

    lateinit var component: Component
    lateinit var daoSession: DaoSession
    override fun onCreate() {
        super.onCreate()
        daoSession = DaoMaster(DaoMaster.DevOpenHelper(this,"TasksDadabase.db").writableDatabase).newSession()
        if (daoSession.taskModelDao.loadAll().size === 0) {
            daoSession.taskModelDao.insert(TaskModel(1L,"test","test",1,false))
        }
    }






}