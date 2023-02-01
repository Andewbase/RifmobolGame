package z.nova.rifmobolgame.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import z.nova.rifmobolgame.data.GameRepo
import z.nova.rifmobolgame.data.GameRepoImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGameRepository(): GameRepo {
        return  GameRepoImpl()
    }

}