package com.muni.mykotlintuto


import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var selectedHand = ""
    var matchWinner = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        button_rock.setOnClickListener {it
            btnClicked("ROCK")
            scaleBtn(it)
        }

        button_paper.setOnClickListener { it
            btnClicked("PAPER")
            scaleBtn(it)
        }

        button_scissors.setOnClickListener {it
            btnClicked("SCISSORS")
            scaleBtn(it)
        }

        button_reset.setOnClickListener { resetBtn() }
        button_play.setOnClickListener { playBtn(selectedHand) }
        button_play_again.setOnClickListener { playAgain() }
    }

    fun btnClicked(args: String){
        selectedHand = args
        selected_hand.text = "Chosen hand is: $selectedHand"

        if(selectedHand.length != 0) selected_hand.setVisibility(VISIBLE)
        button_play.setVisibility(VISIBLE)
        button_reset.setVisibility(VISIBLE)
        linearLayout.setVisibility(VISIBLE)
    }

    fun scaleBtn(args: Any){
        if(args === button_rock) {
            button_rock.scaleX = "0.85".toFloat()
            button_rock.scaleY = "0.85".toFloat()

            // Button PAPER and ROCK scale reset
            button_paper.scaleX = "1".toFloat()
            button_paper.scaleY = "1".toFloat()
            button_scissors.scaleX = "1".toFloat()
            button_scissors.scaleY = "1".toFloat()

        }else if(args === button_paper) {
            button_paper.scaleX = "0.85".toFloat()
            button_paper.scaleY = "0.85".toFloat()

            // Button ROCK and SCISSORS scale reset
            button_rock.scaleX = "1".toFloat()
            button_rock.scaleY = "1".toFloat()
            button_scissors.scaleX = "1".toFloat()
            button_scissors.scaleY = "1".toFloat()

        }else if(args === button_scissors) {
            button_scissors.scaleX = "0.85".toFloat()
            button_scissors.scaleY = "0.85".toFloat()

            // Button ROCK and PAPER scale reset
            button_rock.scaleX = "1".toFloat()
            button_rock.scaleY = "1".toFloat()
            button_paper.scaleX = "1".toFloat()
            button_paper.scaleY = "1".toFloat()
        } else {
            resetScaledBtns()
        }
    }

    fun resetScaledBtns(){
        button_rock.scaleX = "1".toFloat()
        button_rock.scaleY = "1".toFloat()
        button_paper.scaleX = "1".toFloat()
        button_paper.scaleY = "1".toFloat()
        button_scissors.scaleX = "1".toFloat()
        button_scissors.scaleY = "1".toFloat()
    }

    fun playBtn(args: String){
        val machineCombos = listOf("ROCK", "PAPER", "SCISSORS")
        var machineChoseNum = (0..2).shuffled().first()
        var machineHand = machineCombos[machineChoseNum]

        if(machineHand == "ROCK"){
            if(selectedHand == "ROCK"){
                matchWinner = "DRAW!"
                result(matchWinner)
            } else if(selectedHand == "PAPER"){
                matchWinner = "YOU WIN!"
                result(matchWinner)
            } else {
                matchWinner = "YOU LOSE!"
                result(matchWinner)
            }
        } else if(machineHand == "PAPER"){
            if(selectedHand == "ROCK"){
                matchWinner = "YOU LOSE!"
                result(matchWinner)
            } else if(selectedHand == "PAPER"){
                matchWinner = "DRAW!"
                result(matchWinner)
            } else {
                matchWinner = "YOU WIN!"
                result(matchWinner)
            }
        } else {
            if(selectedHand == "ROCK"){
                matchWinner = "YOU WIN!"
                result(matchWinner)
            } else if(selectedHand == "PAPER"){
                matchWinner = "YOU LOSE!"
                result(matchWinner)
            } else {
                matchWinner = "DRAW!"
                result(matchWinner)
            }
        }

        println("Machine hand is: $machineHand | My hand is: $selectedHand")
    }

    fun resetBtn(){
        selectedHand = ""

        selected_hand.setVisibility(GONE)
        button_play.setVisibility(GONE)
        button_reset.setVisibility(GONE)
        linearLayout.setVisibility(GONE)
        scaleBtn(selectedHand)
    }

    fun result(args: String){
        main_layout.setVisibility(GONE)
        textView.setVisibility(GONE)
        selected_hand.setVisibility(GONE)
        linearLayout.setVisibility(GONE)
        text_result.setVisibility(VISIBLE)
        text_result.text = args
        button_play_again.setVisibility(VISIBLE)
    }

    fun playAgain(){
        matchWinner = ""
        selectedHand = ""

        resetScaledBtns()

        text_result.setVisibility(GONE)
        button_play_again.setVisibility(GONE)
        main_layout.setVisibility(VISIBLE)
        textView.setVisibility(VISIBLE)
    }
}
