package com.chepra.mvptodo.main.mvpFragmentsPack

import androidx.annotation.Nullable
import com.chepra.mvptodo.Database.TaskModel
import org.greenrobot.greendao.rx.RxQuery


class FragPresenter(model :FragsMVP.Model): FragsMVP.Presenter {


    private lateinit var taskQuery: RxQuery<TaskModel>


    @Nullable
    private var model: FragsMVP.Model = model
    private lateinit var fragView: FragsMVP.View

    lateinit var pageName : FragPage

    override fun setView(view: FragsMVP.View) {
        this.fragView = view
    }

    override fun setPage(page: FragPage) {
        pageName = page



        when(page)
        {
            FragPage.TO_DO ->{


                fragView.setTask(model.allTask())
            }
            FragPage.WORKED_DONE ->{
                fragView.setTask(model.workedDoneTask())
            }

        }

    }

    override fun buttonsClicked(taskModels: TaskModel, Name: eventName) {

        when(Name)
        {
            eventName.Delete ->{
                model.delete(taskModels)
                this.setPage(pageName)

            }
            eventName.Done ->{
                donee(taskModels)

                model.done(taskModels)
                this.setPage(pageName)


            }
            eventName.Update -> {
                model.update(taskModels)
                this.setPage(pageName)

            }

        }
    }

    private fun donee(taskModels: TaskModel) {
        when (pageName) {
            FragPage.TO_DO -> {
                taskModels.done = true
            }
            FragPage.WORKED_DONE -> {
                taskModels.done = false
            }

        }
    }
}