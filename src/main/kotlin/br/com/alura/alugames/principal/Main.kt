package br.com.alura.alugames.br.com.alura.alugames.principal

import br.com.alura.alugames.br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi


fun main() {
    println("Digite o código do Jogo para buscar:")
    var busca = readln()
    while (busca.isBlank()) {
        println("Código Inválido, tente novamente !")
        busca = readln()
    }

    val buscaApi = ConsumoApi()
    val informacaofoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaofoJogo.info.title,
            informacaofoJogo.info.thumb)
    }

    resultado.onFailure{
        println("Jogo Inexistente. Tente Outro ID.")
    }

    resultado.onSuccess {
        println("Deseja Adicionar uma Descrição Personalizada? S/N")
        val opcao = readln()
        if(opcao.equals("s", true)){
            println("Digite a Descrição Personalizada: ")
            val descricao = readln()
            meuJogo?.descricao = descricao
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
    }

    println(meuJogo)

    resultado.onSuccess {
        println("Busca Finalizada com Sucesso !")
    }
}