package com.cleanarch.di

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Room
import com.cleanarch.data.data_source.local.room.UserDao
import com.cleanarch.data.data_source.local.room.UserDatabase
import com.cleanarch.data.data_source.remote.TestApi
import com.cleanarch.data.repo.MainRepoImpl
import com.cleanarch.domain.repo.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserEmail() = "yk@usa.com"

    @Provides
    @Singleton
    fun provideMainRepo(email: String, userDao: UserDao, testApi: TestApi) : MainRepo
        = MainRepoImpl(email,userDao,testApi)

    @Provides
    @Singleton
    fun provideRoomDao(@ApplicationContext context: Context) : UserDao{
        val database
            = Room.databaseBuilder(context,UserDatabase::class.java,"yk")
                .build()

        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideTestApi(@ApplicationContext context: Context) : TestApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient =
            OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .cache(Cache(File(context.cacheDir, "http_cache"),(50*1024*1024).toLong()))
//                .addNetworkInterceptor(CacheInterceptor())
//                .addInterceptor(ForceCacheInterceptor())
                .build()

        return Retrofit
            .Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(TestApi.BASE_URL)
            .build()
            .create(TestApi::class.java)
    }


}
