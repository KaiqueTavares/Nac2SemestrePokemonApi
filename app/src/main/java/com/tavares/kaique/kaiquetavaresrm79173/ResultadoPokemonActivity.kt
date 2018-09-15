package com.tavares.kaique.kaiquetavaresrm79173

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.tavares.kaique.kaiquetavaresrm79173.api.PokemonService
import com.tavares.kaique.kaiquetavaresrm79173.model.Pokemon
import kotlinx.android.synthetic.main.activity_resultado_pokemon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultadoPokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_pokemon)

        val numeroPokemon = intent?.getStringExtra("NumeroPokemon")!!.toInt()

        tvPokemonNumber.text = "ID POKEMON: " + numeroPokemon.toString()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(PokemonService::class.java)
        service.buscarPokemon(numeroPokemon.toString()).enqueue(object : Callback<Pokemon>{
            override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {
                Toast.makeText(this@ResultadoPokemonActivity,
                        "Falha na Captura do Dado",
                        Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {
                val pokemon = response?.body()
                Picasso.get().load(pokemon?.sprite?.imagemPokemon).into(ivPokemon)
                tvNomePokemon.text = "Nome Pokemon: " + pokemon?.nome
            }

        })
    }
}
