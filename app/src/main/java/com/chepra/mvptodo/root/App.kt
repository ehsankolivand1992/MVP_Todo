package com.chepra.mvptodo.root

import android.app.Application
import com.chepra.mvptodo.Database.DaoMaster
import com.chepra.mvptodo.Database.DaoSession
import com.chepra.mvptodo.Database.TaskModel
import com.chepra.mvptodo.main.mvpFragmentsPack.FragModule
import com.chepra.mvptodo.main.mvpPackage.MainModule


class App: Application() {

    lateinit var component: ApplicationComponent
    lateinit var daoSession: DaoSession


    override fun onCreate() {
        super.onCreate()
        daoSession = DaoMaster(DaoMaster.DevOpenHelper(this,"TasksDadabase.db").writableDatabase).newSession()
       if (daoSession.taskModelDao.loadAll().size == 0) {
            daoSession.taskModelDao.insert(TaskModel(1L,"test","test",1,false))
        }
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .fragModule(FragModule())
            .mainModule(MainModule()).build()
    
    }








}