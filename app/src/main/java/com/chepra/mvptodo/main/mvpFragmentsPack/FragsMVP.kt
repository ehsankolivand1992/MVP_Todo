package com.chepra.mvptodo.main.mvpFragmentsPack

import com.chepra.mvptodo.Database.TaskModel
import io.reactivex.Observer
import org.greenrobot.greendao.rx.RxQuery

enum class eventName {
    Delete,
    Update,
    Done

}
enum class FragPage{
    WORKED_DONE,
    TO_DO
}
interface FragsMVP {

    interface View{
        fun setTask(taskModel: List<TaskModel>)




    }
    interface Presenter {

        fun setView(view: View)
        fun setPage(page: FragPage)
        fun buttonsClicked(taskModels: TaskModel, Name: eventName)

    }
    interface Model{
        fun delete(taskModels: TaskModel)
        fun update(taskModels: TaskModel)
        fun done(taskModel: TaskModel)
        fun allTask(): List<TaskModel>
        fun workedDoneTask(): List<TaskModel>
    }
}