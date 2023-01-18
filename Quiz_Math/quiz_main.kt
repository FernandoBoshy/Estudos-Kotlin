package Quiz_Math

fun main(args: Array<String>) {
    println("Iniciando Quiz. . .")
    println("O jogador que marcar mais pontos será o vencedor")
    println("Nome do jogador 1: ")
    val jogador1 = Jogadores(readLine().toString().trim(), pontuacao = 0)
    println("Nome do jogador 2: ")
    val jogador2 = Jogadores(readLine().toString().trim(), 0)
    print("Escolha a quantidade de perguntas: ")
    val qt_perguntas: Int = readLine()?.toIntOrNull() ?: 0
    if (qt_perguntas == 0) {
        println("Quantidade inválida")


    //______________________________// inicio do programa
    } else {
        for(rodada in 0 until qt_perguntas) {
            if (rodada == 0){println("Vamos começar . . .")} else {println("O jogador ${jogador1.nome} tem ${jogador1.pontuacao} pontos \nO jogador ${jogador2.nome} tem ${jogador2.pontuacao} pontos")}
            println("Jogador(a) ${jogador1.nome}")
            jogador1.pontuacao += printOpcoes()

            println("Jogador(a) ${jogador2.nome}")
            jogador2.pontuacao += printOpcoes()

        }
    }

    println("Até mais")
}