package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.content.SharedPreferences
import android.text.TextUtils.replace
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.entity.Answer
import es.iessaladillo.pedrojoya.pr05_trivial.entity.Question
import es.iessaladillo.pedrojoya.pr05_trivial.ui.gamewon.GameWonFragment

class MainActivityViewModel: ViewModel() {

    var currentFrag = MutableLiveData(0)

    var numberQuestions=5

    var currentQuestion = 0

    private val _response: MutableLiveData<Boolean> = MutableLiveData()
    val response: LiveData<Boolean>
        get()=_response
    fun reply(value: Boolean)   {
        _response.value = value
    }

    private val question:ArrayList<Question> = ArrayList(listOf(
        Question("¿Quién es el creador de la aplicación?", listOf<Answer>(
            Answer("Daniel",true),
            Answer("Paco",false),
            Answer("Juan",false),
            Answer("Ignacio",false))),
        Question("¿Razer Razer?",listOf<Answer>(
            Answer("Hombre, por supuesto",false),
            Answer("Es la mejor marca calidad precio del mercado la verdad",false),
            Answer("Blackwidow chroma 4k edition",true),
            Answer("El color verde no mola",false))),
        Question("¿Que grupo de musica es el favorito del creador?",listOf<Answer>(
            Answer("Backstreet Boys",false),
            Answer("Man with a mission",true),
            Answer("One Direction",false),
            Answer("Skillet",false))),
        Question("¿Que es un Koala?",listOf<Answer>(
            Answer("Coche",false),
            Answer("Moto",false),
            Answer("Animal",true),
            Answer("Lugar Geografico",false))),
        Question("¿Que mando usarias para jugar a la nintendo switch?",listOf<Answer>(
            Answer("Pro Controller Pad",false),
            Answer("Joycons",true),
            Answer("Raton y teclado",false),
            Answer("Taza de té",false))),
        Question("¿Que es una galaxia?",listOf<Answer>(
            Answer("Una galaxia es una galaxia",false),
            Answer("Una galaxia es un conjunto de estrellas que brillan mucho",false),
            Answer("Mi cerebro",true),
            Answer("Polvo de estrellas",false))),
        Question("¿Que es Ucrania?",listOf<Answer>(
            Answer("Un lugar al cual no quieres ir",false),
            Answer("Un país mas",true),
            Answer("Un animal",false),
            Answer("Un tipo de tanque",false))),
        Question("¿Que es una python?",listOf<Answer>(
            Answer("Un arma",false),
            Answer("Un lenguaje de programación",false),
            Answer("Una serpiente",false),
            Answer("Todas son correctas",true))),
        Question("¿Eres el mejor?",listOf<Answer>(
            Answer("Soy una mierda",false),
            Answer("Zoy el mah meho",true),
            Answer("Puede",false),
            Answer("SI SI Y SI",false))),
        Question("¿Cuanto pesa una sandia de talla 3?",listOf<Answer>(
            Answer("2 kg",false),
            Answer("3 kg",false),
            Answer("5 kg",true),
            Answer("4 kg",false))),
        Question("¿El mejor pokemon de tipo hielo?",listOf<Answer>(
            Answer("Froslass",true),
            Answer("Eiscue",false),
            Answer("Mamoswine",false),
            Answer("Articuno",false))),
        Question("¿Conduciendo que medio de transporte tienes que abonar el parkimetro en Florida si te bajas a hacer un recado?",listOf<Answer>(
            Answer("Elefante",true),
            Answer("Trigre",false),
            Answer("Oso Pardo",false),
            Answer("Bicicleta",false))),
        Question("¿Desde que vehiculo en Georgia puedes escupir por la ventanilla?",listOf<Answer>(
            Answer("Elefante",false),
            Answer("Camión",true),
            Answer("Automovil",false),
            Answer("Velociraptor",false))),
        Question("¿Hay algun juego en el cual se hable de cubos?",listOf<Answer>(
            Answer("Minecraft",false),
            Answer("Yu-Gi-Oh",true),
            Answer("Staxel",false),
            Answer("Tetris",false))),
        Question("De la lista de objetos que hay aqui ¿Cual no es un arma?",listOf<Answer>(
            Answer("AK-47",false),
            Answer("FAMAS",false),
            Answer("JustAway",true),
            Answer("Colt",false))),
        Question("Si te pones unas gafas de rayos x y te miras a un espejo,¿Qué ves?",listOf<Answer>(
            Answer("Te ves normal",true),
            Answer("Ves la Nada",false),
            Answer("Ves tu tonteria",false),
            Answer("Ves el esqueleto tuyo",false)))))



    fun shuffleAndPlay() {
        currentQuestion=0
        question.shuffle()
    }

    fun getQuestion(id:Int): Question {
        return question.get(id)
    }






}