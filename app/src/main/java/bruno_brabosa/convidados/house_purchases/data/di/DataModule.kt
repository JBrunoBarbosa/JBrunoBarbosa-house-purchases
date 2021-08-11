package bruno_brabosa.convidados.house_purchases.data.di

import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepository
import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepositoryImpl
import bruno_brabosa.convidados.house_purchases.data.repository.local.storage.ProductsStorage
import bruno_brabosa.convidados.house_purchases.data.repository.local.storage.ProductsStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindLocalRepository (repository: ProductRepositoryImpl): ProductRepository

    @Binds
    fun bindStorage (storage: ProductsStorageImpl): ProductsStorage

}