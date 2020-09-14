package com.example.filmescoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    //Sem Coroutines Por meio de Callback
    fun getFilmes(callback: (filmes: List<Filme>) -> Unit){
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "Titulo 01"),
                    Filme(1, "Titulo 02")
                )
            )
        }).start()
    }

    //Coroutines
    suspend fun getFilmesCoroutines():List<Filme>{
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Filme(1, "Titulo 01"),
                Filme(1, "Titulo 02")
            )
        }
    }
}