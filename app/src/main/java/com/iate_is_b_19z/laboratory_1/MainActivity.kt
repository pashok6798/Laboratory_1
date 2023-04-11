package com.iate_is_b_19z.laboratory_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

fun getWordsFromString() : List<String>{
    val exampleString = "Одним из наставников Владимира Арсеньева в походах по горно-таёжным дебрям Дальнего Востока стал нанайский охотник Дерсу Узала. Никогда и нигде не учившийся, не умевший ни читать, ни писать, он обладал самым настоящим экологическим сознанием. Оно было впитано им сызмальства. Дерсу был не пришельцем извне, уссурийская тайга была его миром и домом. Всё сущее он называл «люди». Камни, ветер, река, огонь – всё это было для него «люди», не говоря уж о животных и растениях. Всё жило своей сокровенной жизнью, составляя удивительную таёжную симфонию. Не зная таких понятий, как экологическое равновесие или биологическая система, Дерсу, конечно же, хорошо представлял, что это такое. Когда Арсеньев, задумавшись о чём-то, бросил в костёр кусочек мяса, Дерсу выхватил его из огня и отчитал «капитана»: разве можно сжигать пищу? Уйдём отсюда мы – придут другие люди. Не енот – так барсук, не белка – так мышь или муравей…"

    val regexSentence = Regex("[^A-Za-zА-Яа-я\\d]")

    return regexSentence.replace(exampleString, "").split(' ').distinct()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.clickBtn)
        val listView = findViewById<ListView>(R.id.listBox)


        btn.setOnClickListener {
            val strs = getWordsFromString()

            val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, strs)
            listView.adapter = arrayAdapter
        }

    }
}