package Calculadora_basica

fun help(){
    println("Programa calculadora - Digite qualquer valor e a operação desejada")
    println("Para sair, digite outro caractere")
    println("Operações disponibilizadas: Somar, Subtrair, Multiplicar e Dividir")
    println("Caso seja digitado algum valor não numérico, o mesmo será convertido para 0")
}

fun cabecalho(vararg opcoes: String) {
    for(x in opcoes){
        println(x)
    }
}


fun main(args: Array<String>){
    cabecalho("o que deseja","1 - Calcular", "2 - Ajuda", "Para sair, digite outro caractere" )
    var resultado: Double = 0.0
    var x: String = "|||"
    while(x != "") {
        var inicio = if (x == "|||") "O que deseja?" else "Algo mais?"
        println(inicio)
        x = readLine().toString().trim()

        if(x == "1"){
            println("Primeiro valor: ")
            var valor1 = readLine()?.toDoubleOrNull() ?: 0.0

            println("Segundo valor: ")
            var valor2 = readLine()?.toDoubleOrNull() ?: 0.0

            cabecalho("|_| Lista de operações |_|", "1 - Somar", "2 - Subtração", "3 - Multiplicação", "4 - divisão", "Outros - Voltar")
            var operador = readLine()?.toString() ?: ""

            if(operador == "1"){
                resultado = valor1 + valor2
                println(resultado)
            } else if(operador == "2"){
                resultado = valor1 - valor2
                println(resultado)
            } else if(operador == "3"){
                resultado = valor1 * valor2
                println(resultado)
            } else if(operador == "4"){
                resultado = valor1 / valor2
                println(resultado)
            } else {
                continue
            }
        }else if(x == "2"){
            help()
        } else {
            break
        }
    }
    print("Até mais...")
}