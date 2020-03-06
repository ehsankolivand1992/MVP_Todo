package com.chepra.mvptodo.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule
{
private lateinit var application : Application

   constructor(application : Application){

       this.application = application
   }

    @Provides
    @Singleton
    public fun provideContext(): Context {
        return  application
    }

}