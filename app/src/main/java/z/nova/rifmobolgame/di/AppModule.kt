package z.nova.rifmobolgame.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import z.nova.rifmobolgame.data.multirepository.GameRepoMulti
import z.nova.rifmobolgame.data.multirepository.GameRepositoryImplMulti
import z.nova.rifmobolgame.data.singlerepository.GameRepo
import z.nova.rifmobolgame.data.singlerepository.GameRepositoryImpl
import z.nova.rifmobolgame.data.singlerepository.dialog.SingleDialogRepo
import z.nova.rifmobolgame.data.singlerepository.dialog.SingleDialogRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGameRepository(): GameRepo {
        return  GameRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesGameRepositoryMulti(): GameRepoMulti {
        return GameRepositoryImplMulti()
    }

    @Provides
    @Singleton
    fun providesSingleDialogRepository(): SingleDialogRepo{
        return SingleDialogRepositoryImpl()
    }

}