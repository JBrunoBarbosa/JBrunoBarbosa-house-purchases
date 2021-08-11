package bruno_brabosa.convidados.house_purchases.domain.di

import bruno_brabosa.convidados.house_purchases.domain.usecases.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateProductUseCase (useCase: CreateProductUseCaseImpl): CreateProductUseCase

    @Binds
    fun bindGetAllProductsUseCase (useCase: GetAllProductsUseCaseImpl): GetAllProductsUseCase

    @Binds
    fun bindRemoveAllProductsUseCase (useCase: RemoveAllProductsUseCaseImpl): RemoveAllProductsUseCase

    @Binds
    fun bindRemoveProductUseCase (useCase: RemoveProductUseCaseImpl): RemoveProductUseCase
}