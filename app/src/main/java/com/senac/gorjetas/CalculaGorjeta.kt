package com.senac.gorjetas

class CalculaGorjetas (val valor: Double,
                       val percentualGorjeta: Double) {

    fun getValorGorjeta15() : Double {
        return valor * 0.15
    }
    fun getValorGorjeta() : Double {
        return valor * (percentualGorjeta/100)
    }

    fun getTotalComGorjeta15() : Double {
        return valor + this.getValorGorjeta15()
    }

    fun getTotalComGorjeta() : Double {
        return valor + this.getValorGorjeta()
    }
}