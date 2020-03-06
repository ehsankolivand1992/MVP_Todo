package com.chepra.mvptodo.main.mvpPackage

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class MainModule {


  @Provides
  public fun provideMainPresenter(model: MainMVP.Model): MainMVP.Presenter
  {
    return MainPresenter(model)
  }

    @Provides
    public fun provideTaskModel(context: Context): MainMVP.Model {

        return TaskModels(context)
    }



}