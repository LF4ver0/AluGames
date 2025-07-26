package br.com.alura.alugames.br.com.alura.alugames.principal

import br.com.alura.alugames.br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.servicos.ConsumoApi
import transformarEmIdade
import java.time.LocalDate


fun main() {
    val gamer = Gamer.criarGamer()
    println("Cadastro Concluído com Sucesso ! Dados do Gamer:")
    println(gamer)

    println("Idade do Gamer: " + gamer.dataNascimento?.transformarEmIdade() + "anos.")

    do {
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
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um Novo Jogo ? S/N")
        var resposta = readln()

    } while (resposta.equals("S", true))

    println("Jogos Buscados:")
    println(gamer.jogosBuscados)


    println("Jogos Ordenados por Titulo:")
    gamer.jogosBuscados.sortBy { it?.titulo }

    gamer.jogosBuscados.forEach{
        println("Titulo:" + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("Batman",true) ?: false
    }
    println("Jogos Filtrados")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original ? S/N")
    val opcao = readln()
    if(opcao.equals("S", true)){
        println(gamer.jogosBuscados)
        println("Digite a posição do jogo:")
        val posicao = readln().toInt()
        gamer.jogosBuscados.removeAt(posicao)
        println("Lista Atualizada após exclusão:")
        println(gamer.jogosBuscados)

    }

    println("Busca Finalizada com Sucesso !")
}