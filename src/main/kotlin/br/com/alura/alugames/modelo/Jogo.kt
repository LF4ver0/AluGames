package br.com.alura.alugames.br.com.alura.alugames.modelo

class Jogo(
    val titulo: String,
    val capa: String) {

    var descricao:String? = null

    override fun toString(): String {
        return "Jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }
}