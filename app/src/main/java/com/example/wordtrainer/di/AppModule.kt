package com.example.wordtrainer.di
import androidx.room.Room
import com.example.wordtrainer.WordTrainerApp
import com.example.wordtrainer.data.data_source.CollectionDB
import com.example.wordtrainer.data.repository.CollectionRepositoryImpl
import com.example.wordtrainer.domain.repository.CollectionRepository
import com.example.wordtrainer.domain.repository.use_case.CollectionUseCases
import com.example.wordtrainer.domain.repository.use_case.DeleteCollectionUseCase
import com.example.wordtrainer.domain.repository.use_case.GetCollectionUseCase
import com.example.wordtrainer.domain.repository.use_case.AddCollection
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
    fun provideCollectionsDB(app: WordTrainerApp): CollectionDB{
        return Room.databaseBuilder(
                app,
            CollectionDB::class.java,
            CollectionDB.DATABASE_NAME
                ).build()
    }
    @Provides
    @Singleton
    fun provideCollectionRepository(db: CollectionDB): CollectionRepository{
        return CollectionRepositoryImpl(db.collectionDao)
    }

    @Provides
    @Singleton
    fun provideCollectionUseCases(repository: CollectionRepository): CollectionUseCases{
        return CollectionUseCases(
            getCollection = GetCollectionUseCase(repository),
            deleteCollection = DeleteCollectionUseCase(repository),
            addCollection = AddCollection(repository)
        )
    }
}