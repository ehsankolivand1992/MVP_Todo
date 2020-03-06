package com.chepra.mvptodo.main.mvpFragmentsPack

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class FragModule {


    @Provides
    public fun provideFragPresenter(model: FragsMVP.Model): FragsMVP.Presenter {
        return FragPresenter(model)
    }



    @Provides
    public fun provideFragModel(context: Context):FragsMVP.Model
    {
        return FragModel(context)
    }
}