package com.tavares.kaique.kaiquetavaresrm79173

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pesquisar_pokemon.*

class PesquisarPokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_pokemon)

        btPesquisar.setOnClickListener {
            val telaResultadoPokemon = Intent(this,ResultadoPokemonActivity::class.java)
            val numeroPokemon = etNumeroPokemon.editableText.toString()
            telaResultadoPokemon.putExtra("NumeroPokemon",numeroPokemon)
            startActivity(telaResultadoPokemon)
        }
    }
}
