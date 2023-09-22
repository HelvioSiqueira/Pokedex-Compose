package com.helvio.pokedexcompose.repository

import com.helvio.pokedexcompose.data.remote.PokeApi
import com.helvio.pokedexcompose.data.remote.responses.Pokemon
import com.helvio.pokedexcompose.data.remote.responses.PokemonList
import com.helvio.pokedexcompose.utlis.Resource
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {

        val response = try {
            Resource.Success(api.getPokemonList(limit, offset))
        } catch (error: Exception) {
            return Resource.Error("Um erro desconhecido ocorreu.")
        }

        return response
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {

        val response = try {
            Resource.Success(api.getPokemonInfo(pokemonName))
        } catch (error: Exception) {
            return Resource.Error("Um erro desconhecido ocorreu.")
        }

        return response
    }

}