package com.asama.luong.mvpkotlinsample.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.asama.luong.mvpkotlinsample.BuildConfig
import com.asama.luong.mvpkotlinsample.data.database.AppDatabase
import com.asama.luong.mvpkotlinsample.data.database.repository.option.OptionRepo
import com.asama.luong.mvpkotlinsample.data.database.repository.option.OptionsRepository
import com.asama.luong.mvpkotlinsample.data.database.repository.question.QuestionRepo
import com.asama.luong.mvpkotlinsample.data.database.repository.question.QuestionRepository
import com.asama.luong.mvpkotlinsample.data.network.ApiHeader
import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.network.AppApiHelper
import com.asama.luong.mvpkotlinsample.data.preferences.AppPreferenceHelper
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.di.ApiKeyInfo
import com.asama.luong.mvpkotlinsample.di.PreferenceInfo
import com.asama.luong.mvpkotlinsample.utils.AppConstants
import com.asama.luong.mvpkotlinsample.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
        userId = preferenceHelper.getCurrentUserId(),
        accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo = QuestionRepository(appDatabase.questionDao())

    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): OptionRepo = OptionsRepository(appDatabase.optionDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}