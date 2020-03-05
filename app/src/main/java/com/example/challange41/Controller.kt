package com.example.challange41

class Controller(var callBack: CallBack) {
    fun checkPemenang(player1: String, player2: String/*,type: Boolean*/) {
        var suit = mutableListOf("Batu","Gunting","Kertas")
        /*val typePlayer = if (type) {
            "Komputer"
        } else {
            "Player 2"
        }*/

        if (player1 == suit[1] && player2 == suit[0] ||
            player1 == suit[0] && player2 == suit[2] ||
            player1 == suit[2] && player2 == suit[1]
        ) {
            callBack.resultSuit(R.drawable.comwinner)
        } else if (
            player1 == suit[1] && player2 == suit[2] ||
            player1 == suit[0] && player2 == suit[1] ||
            player1 == suit[2] && player2 == suit[0]
        ) {
            callBack.resultSuit(R.drawable.pemainwinner)
        } else {
            callBack.resultSuit(R.drawable.draw)
        }
    }
}