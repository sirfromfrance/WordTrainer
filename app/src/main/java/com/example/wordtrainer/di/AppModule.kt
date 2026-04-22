package com.example.wordtrainer.di
import android.app.Application
import androidx.room.Room
import com.example.wordtrainer.data.data_source.CollectionDB
import com.example.wordtrainer.data.repository.CollectionRepositoryImpl
import com.example.wordtrainer.domain.repository.CollectionRepository
import com.example.wordtrainer.domain.repository.use_case.collection.CollectionUseCases
import com.example.wordtrainer.domain.repository.use_case.collection.DeleteCollectionUseCase
import com.example.wordtrainer.domain.repository.use_case.collection.GetCollectionsUseCase
import com.example.wordtrainer.domain.repository.use_case.collection.AddCollection
import com.example.wordtrainer.domain.repository.use_case.collection.GetCollection
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
    fun provideCollectionsDB(app: Application): CollectionDB{
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
            getCollections = GetCollectionsUseCase(repository),
            deleteCollection = DeleteCollectionUseCase(repository),
            addCollection = AddCollection(repository),
            getCollection = GetCollection(repository)
        )
    }
}