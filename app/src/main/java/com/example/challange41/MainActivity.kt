package com.example.challange41

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), CallBack {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idGambar = mutableListOf(batu, kertas, gunting)
        var suit = mutableListOf("Batu", "Gunting", "Kertas")
        var player = ""
        var player2 = ""

        var controller = Controller(this)

        for (id in idGambar) {
            id.setOnClickListener {
                var com = (0..2).random()
                var index = id.contentDescription.toString().toInt()
                player = suit[index]
                Log.d(player,suit[index])
                id.setBackgroundColor(getColor(R.color.colorPrimary))
                player2 = suit[com]
                Log.d(player2,suit[com])
                when (com) {
                    0 -> batuCom.setBackgroundColor(getColor(R.color.colorPrimary))
                    1 -> guntingCom.setBackgroundColor(getColor(R.color.colorPrimary))
                    2 -> kertasCom.setBackgroundColor(getColor(R.color.colorPrimary))
                }
                controller.checkPemenang(player, player2)
                sentuh(klik = false)
            }
        }
        repeat.setOnClickListener {
            repeat()
            sentuh(klik = true)
            Log.d(TAG,"GAME DIULANG")
        }
    }
    override fun resultSuit(hasil: Int) {
        versus.setImageResource(hasil) //untuk mengganti gambar versus
        when(hasil){
            R.drawable.comwinner -> Log.d(TAG,"Computer Winner")
            R.drawable.pemainwinner -> Log.d(TAG,"Pemain Winner")
            R.drawable.draw -> Log.d(TAG,"Draw")
        }
    }
    fun sentuh(klik:Boolean){
        batu.isClickable = klik
        kertas.isClickable = klik
        gunting.isClickable = klik
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun repeat(){
        batu.setBackgroundColor(getColor(android.R.color.transparent))
        kertas.setBackgroundColor(getColor(android.R.color.transparent))
        gunting.setBackgroundColor(getColor(android.R.color.transparent))
        batuCom.setBackgroundColor(getColor(android.R.color.transparent))
        kertasCom.setBackgroundColor(getColor(android.R.color.transparent))
        guntingCom.setBackgroundColor(getColor(android.R.color.transparent))
        versus.setImageResource(R.drawable.vs)
    }
}


