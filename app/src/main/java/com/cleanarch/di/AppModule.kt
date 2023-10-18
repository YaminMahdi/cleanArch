package com.cleanarch.di

import android.provider.ContactsContract.CommonDataKinds.Email
import com.cleanarch.data.repo.MainRepoImpl
import com.cleanarch.domain.repo.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserEmail() = "yk@usa.com"

    @Provides
    @Singleton
    fun provideMainRepo(email: String) : MainRepo = MainRepoImpl(email)


}
