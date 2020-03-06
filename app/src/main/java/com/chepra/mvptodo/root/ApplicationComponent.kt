package com.chepra.mvptodo.root

import com.chepra.mvptodo.main.FragDone
import com.chepra.mvptodo.main.FragToDo
import com.chepra.mvptodo.main.MainActivity
import com.chepra.mvptodo.main.mvpFragmentsPack.FragModel
import com.chepra.mvptodo.main.mvpFragmentsPack.FragModule
import com.chepra.mvptodo.main.mvpPackage.MainModule
import com.chepra.mvptodo.main.mvpPackage.TaskModels
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ApplicationModule::class,MainModule::class,FragModule::class))
interface ApplicationComponent {

    fun inject(target: MainActivity)
    fun inject(target: TaskModels)
    fun inject(target: FragDone)
    fun inject(target: FragToDo)

}