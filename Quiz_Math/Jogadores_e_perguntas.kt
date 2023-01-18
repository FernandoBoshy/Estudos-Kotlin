package Quiz_Math

class Jogadores(
    var nome: String = "A",
    var pontuacao: Int = 0)

class Perguntas(var id: Int = 0,
                var enunciado: Any? = "",
                var resposta_certa_id: String = "",
                var resposta_certa_enunciado: Any? = 0)

fun sortearPerguntas(): Array<Any?> {
    val total_de_perguntas = Array(8) { arrayOfNulls<Any>(2) }

    total_de_perguntas[0][0] = "Pergunta número 1 - Qual o valor de 1 + 0:"
    total_de_perguntas[0][1] = 1

    total_de_perguntas[1][0] = "Pergunta número 2 - Qual o valor de 1 + 1:"
    total_de_perguntas[1][1] = 2

    total_de_perguntas[2][0] = "Pergunta número 3 - Qual o valor de 1 + 2:"
    total_de_perguntas[2][1] = 3

    total_de_perguntas[3][0] = "Pergunta número 4 - Qual o valor de 1 + 3:"
    total_de_perguntas[3][1] = 4

    total_de_perguntas[4][0] = "Pergunta número 5 - Qual o valor de 1 + 4:"
    total_de_perguntas[4][1] = 5

    total_de_perguntas[5][0] = "Pergunta número 6 - Qual o valor de 1 + 5:"
    total_de_perguntas[5][1] = 6

    total_de_perguntas[6][0] = "Pergunta número 7 - Qual o valor de 1 + 6:"
    total_de_perguntas[6][1] = 7

    total_de_perguntas[7][0] = "Pergunta número 8 - Qual o valor de 1 + 7:"
    total_de_perguntas[7][1] = 8

    return total_de_perguntas.random()
}

fun printOpcoes(jog: Int = 0): Int {

    val posicao_array = arrayListOf<Int>()
    while(posicao_array.size != 4) {
        val posicao: Int = (0..3).random()

        if(!posicao_array.contains(posicao))  // verifica se o valor de posição ja está inserido na array
            posicao_array.add(posicao)
    }
    val (pergunta_atual, resposta_atual) = sortearPerguntas()
    val pergunta = Perguntas(id = posicao_array[0], enunciado =  pergunta_atual, "", resposta_certa_enunciado = resposta_atual)
    val resposta_errada = arrayListOf<Int>(
        opcoesErradas(pergunta.resposta_certa_enunciado),
        opcoesErradas(pergunta.resposta_certa_enunciado),
        opcoesErradas(pergunta.resposta_certa_enunciado))


    val resposta_conjunto = Array<Any?>(4) {}
    when(pergunta.id){
        0 -> pergunta.resposta_certa_id = "A"
        1 -> pergunta.resposta_certa_id = "B"
        2 -> pergunta.resposta_certa_id = "C"
        3 -> pergunta.resposta_certa_id = "D"
    }
    resposta_conjunto[pergunta.id] = pergunta.resposta_certa_enunciado
    resposta_conjunto[posicao_array[1]] = resposta_errada[0]
    resposta_conjunto[posicao_array[2]] = resposta_errada[1]
    resposta_conjunto[posicao_array[3]] = resposta_errada[2]

    println(pergunta.enunciado)
    println("")
    println("A - ${resposta_conjunto[0]}")
    println("B - ${resposta_conjunto[1]}")
    println("C - ${resposta_conjunto[2]}")
    println("D - ${resposta_conjunto[3]}")
    println("")
    println("Qual é a letra certa?")
    val resposta = readLine().toString().trim().uppercase()

    if (resposta == pergunta.resposta_certa_id){
        println("Acertou")
        println("*Enter para continuar*")
        readLine()
        return 1
    } else {
        println("Errou")
        println("*Enter para continuar*")
        readLine()
        return 0
    }
}

fun opcoesErradas(x: Any?): Int {
    var resp: Int = 0
    if(x is Int){
         resp = x
    }
    val rand: Int = (-5..5).random()
    if(rand != 0){
        return rand + resp
    } else {
        return rand + resp + 1
    }
}