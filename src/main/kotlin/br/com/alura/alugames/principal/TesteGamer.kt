import br.com.alura.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Jack",
        "jack@email.com"
    )
    println(gamer1)

    val gamer2 = Gamer(
        "Jeni",
        "jeni@email.com",
        "19/09/1992",
        "jeni123@"
    )
    println(gamer2)

    //Scope Functions
    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "jackSkywalker"
        it.idInterno = "jackSkywalker123"
    }

    println(gamer1)
}