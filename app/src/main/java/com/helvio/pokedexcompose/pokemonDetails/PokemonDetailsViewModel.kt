package com.helvio.pokedexcompose.pokemonDetails

import androidx.lifecycle.ViewModel
import com.helvio.pokedexcompose.data.remote.responses.Pokemon
import com.helvio.pokedexcompose.repository.PokemonRepository
import com.helvio.pokedexcompose.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}