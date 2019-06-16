package com.parisotto.motivation.mock

import com.parisotto.motivation.util.MotivationConstants
import java.util.*

class Phrase(val descricao:String,val categoria:Int)

fun Int.random():Int =  Random().nextInt(this)


class Mock{

    private val ALL = MotivationConstants.PHRASE_FILTER.all
    private val SUN = MotivationConstants.PHRASE_FILTER.sun
    private val HAPPY = MotivationConstants.PHRASE_FILTER.happy

    private val mListFrase: List<Phrase> = listOf(
        Phrase("frase de happy1",HAPPY),
        Phrase(" de happy2",HAPPY),
        Phrase("frase de happy1",HAPPY),
        Phrase("frase de sun1",SUN),
        Phrase("frase de sun2",SUN),
        Phrase("frase de sun3",SUN),
        Phrase("frase de all1",SUN),
        Phrase("frase de all2",HAPPY),
        Phrase("frase de all3",SUN)
    )

    fun getPhrase(value: Int): String{
       val filtered = mListFrase.filter{it -> (it.categoria == value || value == ALL)}

        val rand = filtered.size.random()

        return filtered[rand].descricao
    }
}