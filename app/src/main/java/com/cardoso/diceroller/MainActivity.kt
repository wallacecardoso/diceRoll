package com.cardoso.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * forma de selecionar o botão para rolar o dado.
         * **/
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = getString(R.string.cd_toast_main)
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    /**
     * Função para rolar o dado e adicionar seu resultado no textView do app.
     * **/
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}

/**
 * Classe que foi instanciada para produção do objeto dado(utilizado pela activity main do meu app).
 * **/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

