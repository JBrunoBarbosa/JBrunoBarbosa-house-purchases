package bruno_brabosa.convidados.house_purchases.data.di

import android.content.Context
import bruno_brabosa.convidados.house_purchases.data.repository.local.database.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext appContext: Context): ProductsDatabase {
        return ProductsDatabase.create(appContext)
    }

}