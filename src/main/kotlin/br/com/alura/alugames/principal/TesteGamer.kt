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
    }.also {
        println(gamer1.idInterno)
    }

    gamer1.usuario = "Jack"
    println(gamer1)

    println(gamer1)
}