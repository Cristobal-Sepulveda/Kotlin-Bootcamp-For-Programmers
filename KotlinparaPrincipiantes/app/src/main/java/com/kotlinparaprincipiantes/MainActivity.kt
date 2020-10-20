package com.kotlinparaprincipiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/** PRINCIPIOS BASICOS DE KOTLIN */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** leccion 1
        Función variablesYConstantes() */

        /**leccion 2
        tiposDeDatos() */

        /**leccion 3
        sentenciaIf()*/

        /**leccion 4
        sentenciaWhen() */

        /**Leccion 5
        arrays() */

        /**Practica 1
        jugandoconestructuras() */

        /** Leccion 6
        maps() */

        /** Leccion 7
        loops() */

        /** Lección 8
        nullSafety()*/

        /** lección 9
        funciones() */

        /** Lección 10 */
        classes()

    }

    private fun tiposDeDatos() {
        /******* aqui vamos a hablar sobre los tiposDeDatos/dataType */

        /******* string*/

        val myString2 = "osdok"
        val myString = "hola cris"
        val myString3 = myString + " " + myString2

        println(myString3)

        /******* enteros (byte (-127 y 128,< short<, int (usar este)<, long)*/

        val myInt1 = 1
        val myInt2 = 3
        val myInt3 = myInt1 + myInt2

        println(myInt3)

        /******* decimales ( float, double (Usar este))*/

        val myDouble = 1.5
        val myDouble2 = 2.6
        val myFloat: Float = 1.5f
        val myDouble3 = 1

        // en realidad este es un int, puedo realizar operaciones
        // con variables de distinto tipo//

        val myDouble4 = myDouble + myDouble2 + myDouble3 + myFloat + myInt1

        println(myDouble4)

        /******* boolean (bool)*/
        // un dato boolean solo puede tomar 2 valores, TRUE O FALSE

        val myBool1 = true
        val myBool2 = false

        // val mybool3 = myBool1 + myBool2 //falso, esto solo es posible con strings, ints y decimal
        //booleanos solo sirven para operaciones logicas

        println(myBool1 == myBool2)
        println(myBool1 && myBool2)

        /*******  */
    }

    private fun variablesYConstantes() {
        /*************************************variables   ******************************************/
        var myFirstVariable = "HELLO CRIS"
        println(myFirstVariable)
        myFirstVariable = "hola mati"
        var myFirstNumber = 1
        println(myFirstVariable)
        println(myFirstNumber)
        /** no podemos asignar un tipo int a una de tipo string
        myFirstVariable = 1  */
        var mySecondVariable = "q sucede"
        println(mySecondVariable)
        mySecondVariable = myFirstVariable
        println(mySecondVariable)
        myFirstVariable = "hola"
        println(myFirstVariable)
        println(myFirstNumber)
        println(mySecondVariable)
        /*********************************** Constantes********************************************/
        val myFirstConstant = "te ha gustado el tutorial?"
        println(myFirstConstant)
        /** una constante no puede modificar su valor
         * myFirstConstant = "suscribete" */
        val mySecondConstant = myFirstVariable
        println(mySecondConstant)
        myFirstVariable = "olo"
        println(myFirstVariable)
        println(mySecondConstant)
    }

    private fun sentenciaIf() {

        val myNumber = 6
        /** aqui vamos a hablar de la sentencia if*/
        /** operaciones condicionales para if; >, <, >=, <=, ==, != . */
        /** operadores logicos para condiciones de if;  y = && ;  o = || ; no = !    */

        if (!(myNumber <= 10 && myNumber > 5) || myNumber == 53) {

            println("$myNumber es menor o igual a 10 o es igual a 53")
        } else if (myNumber == 60) {

            println("$myNumber es igual a 60")
        } else if (myNumber != 70) {

            println("$myNumber es distinto de 70")
        } else {
            println("$myNumber es mayor que 10 o menor o igual que 5 y no es 53")
        }
    }

    fun sentenciaWhen() {

        /** aqui vamos a hablar de la sentencia when */

        /** when con string */

        val country = "China"
        when (country) {
            "España", "Mexico", "Perú", "Colombia", "Argentina" -> {
                println("el idioma es Español")
            }
            "EEUU" -> {
                println("el idioma es Inglés")
            }
            "Francia" -> {
                println("el idioma es Francés")
            }
            else -> {
                println("No conocemos el idioma")
            }
        }

        /** when con int */

        val age = 100
        when (age) {
            0, 1, 2 -> {
                println("eres un bebe")
            }
            in 3..10 -> {
                println("eres un niño")
            }
            in 11..17 -> {
                println("eres un adolescente")
            }
            in 18..69 -> {
                println("eres un adulto")
            }
            in 70..99 -> {
                println("eres un anciano")
            }
            else -> {
                println(":o")
            }
        }
    }

    fun arrays() {

        /** aqui vamos a hablar de arrays o arreglos */

        val name = "Cristóbal"
        val surname = "Sepúlveda"
        val company = "Empresa"
        val age = "32"

        /** creación de nuestro array */

        val myArray = arrayListOf<String>()

        /** añadir datos de 1 en 1 */

        myArray.add(name)
        myArray.add(surname)
        myArray.add(company)
        myArray.add(age)

        /**myArray.add (age)        // es posible repetir los datos en la estructura//
        myArray.add (age)*/

        println(myArray)

        /** añadir un conjunto de datos */

        myArray.addAll(listOf("hola", "bienvenidos al tutorial"))
        println(myArray)

        /** acceder a datos de un array */

        val myCompany = myArray[2]
        println(myCompany)

        /** modificar datos de un array */

        myArray[5] = "suscribete y activa la campana"
        println(myArray)

        /** eliminar datos */

        myArray.removeAt(4)
        println(myArray)

        /** recorrer un array */

        myArray.forEach {
            println(it)
        }

        /** otras operaciones */

        println(myArray.count())
        /** contador de datos en la estructura */

        /** verificador de existencia de datos y respuesta a este */
        myArray.forEach {
            if (it == name) {
                println("encontrado")
            }
        }

        /** limpiar/vaciar una estructura de datos
        myArray.clear()
        println(myArray.count()) */

        /** acceder al primer elemento o al ultimo
        myArray.first()
        myArray.last()
        //ordenar lista segun criterios, existe mas de un sort
        myArray.sort()
        etc */
    }

    fun jugandoconestructuras() {

        val estructura = arrayListOf<String>()

        var nombre = "cristobal"
        var dirección = "alfonso vial 563"
        var fechadelpedido = "16/05/2020"

        val detalle = arrayListOf<Int>()

        var manzana = 250
        var platano = 500
        var lechuga = 400

        estructura.addAll(listOf(nombre, dirección, fechadelpedido))
        detalle.addAll(listOf(manzana, platano, lechuga))

        detalle.sort()
        println(detalle)

    }

    fun maps() {
        /** aqui vamos a hablar de mapas, tambien llamados diccionarios, asi es como se crean */
        var myMap: Map<String, Int> = mapOf()
        println(myMap)
        /** aqui vamos a añadir elementos, esta consiste en el primer ingreso de elementos
        al diccionario/mapa, si declaramos myMap como =mapOf(), este no sera mutable, es un
        diccionario estatico. De querer poder incluir claves y valores en el futuro, debemos
        declarar myMap como un =mutableMapOf()*/
        myMap = mutableMapOf(
            "Tomate" to 1990,
            "lechuga" to 1000,
            "palta" to 4000,
            "zapallo" to 1990
        )
        println(myMap)
        /** AQUI añadiremos un solo valor*/
        myMap["LIMON"] = 7
        myMap.put("Manzana", 500)
        println(myMap)
        /** Actualización de un dato */
        myMap.put("Manzana", 600)
        myMap["Manzana"] = 700
        println(myMap)
        myMap.put("Pera", 1000)
        println(myMap)
        /** Acceso a un Datos */
        println(myMap["Tomate"])
        /** Eliminar un dato */
        myMap.remove("Tomate")
        println(myMap)

    }

    private fun loops() {

        /** aqui vamos a hablar de loops, tambien llamados bucles */

        val myArray: List<String> = listOf("Cristóbal", "Sepúlveda, hola")
        val myMap = mutableMapOf("Tomate" to 1990, "Curry" to 599)
        println("________________")
        println(myMap)
        println(myArray)

        /** de la manera que vimos arriba, es como se invoca una variable o constante
         * de otra funcion, se deben de llamar/invocar de la manera señalada, es decir, puedo
         * incluir aquellas variables que ya tuve declaradas y adicionalmente, puedo añadirle
         * nuevas aqui,eso si, al usar println, solo seran señaladas las incluidas en
         * esta funcion */

        /** bucles */
        for (myString in myArray) {
            println(myString)
        }
        for (myElements in myMap) {
            println("${myElements.key}-${myElements.value}")
        }
        for (x in 0..10) {
            println(x)
        }
        for (x in 0 until 10){
            println(x)
        }
        for (x in 0..10 step 2){
            println(x)
        }
        for (x in 10 downTo 0 step 3){
            println(x)
        }

        /** por ultimo, atendiendo a rangos, el siguiente es un truco.Como crear un array
         * de un rango numerico */

        val myNumericArray = (0..20)
        for (myNum in myNumericArray){println(myNum)}

        /** WHILE, MIENTRAS */

        var x = 0
        while(x <= 10){
            println(x)
            /** x++ esto incrementa 1 */
            x += 2 /** este sirve para sumar el digito que uno quiera */
        }
    }

    fun nullSafety(){

        /** aqui vamos a hablar de seguridad contra nulos (nullSafety) */

        var myString = "Cristobal"

        /** myString=  null  esto daria un error de compilación, con esto el compilador de
                            kolin ya no esta ayudando, ya que no nos deja ejecutar el
                            programa, nos esta diciendo que hay un error de compilación, con
                            lo cual esta evitando que el programa pueda poseer un error en
                            tiempo de ejecucion*/

        println(myString)
        /** etendido lo anterior vamos a empezar a hablar de verdad de la gestion de nulos */

        /** variable null safety */
        var mySafetyString: String? = "mouredev null safety"
        println(mySafetyString)
        mySafetyString = null
        println(mySafetyString)

        mySafetyString = "perfectirijillo"

        /** esto ya no se hace, no es necesario ya hacer estas  comprobaciones
        if(mySafetyString != null) {
            println(mySafetyString!!)
        } else {
            println(mySafetyString)
        }
        */

        /** SAFE CALL
         * el signo ?, a diferencia del !!(que obliga a que no sea nula, hace que en caso de
         * ser nulo, no imprima la funcion llamada post signo . */

        println(mySafetyString?.length)
        /** que es lo bueno que tenemos cuando trabajamos con variables que pueden ser nulas,
         es que podemos, al llamar estas variables, incluir el ? al final de ellas, para que
         cualquier funcion que se quiera usar con esta variable, si esta variable es nula,
         pueda arrojar null y no generar un error
         */

        mySafetyString?.let {
            println(it)  /** esto ejecuta codigo cuando es no nulo */
        } ?: run {
            println(mySafetyString)
        }
    }

    fun funciones(){
        /** aqui vamos a hablar de funciones */
        sayHello()
        sayHello()
        sayHello()
        sayMyName("cristobal")
        sayMyName("mati")
        sayMyName("vale")
        sayMyNameAndAge("cristobal", 29)

        /**las 2 primeras son opciones =, validas y utiles en diferentes cirscunstancias */
        val sumResult = sumTwoNumbers(10, 5)
        println(sumResult)
        println(sumTwoNumbers(15,9))
        println(sumTwoNumbers(10, sumTwoNumbers(5,5)))
    }

    fun classes(){
        /** aqui vamos a hablar de las clases */
        val sara = Programmer ("sara",
                            29,
                            arrayOf(Programmer.Language.kotlin, Programmer.Language.c))
            println(sara.name)
            sara.age = 30

        val cris = Programmer ("crist",
                                28,
                                arrayOf(Programmer.Language.java, Programmer.Language.c),
                                arrayOf(sara))

            cris.code()
            sara.code()
            println("${sara.friends?.first()?.name} es amigo de ${sara.name}")
            if (cris.friends == null){
                println("no tiene amigos")
            }else {
                println("${cris.friends?.first()?.name} es amigo de ${cris.name}")
            }
    }


    /** ESTAS FUNCIONES DE ABAJO NO ESTAN DECLARADAS EN EL OVERRIDE, POR LO QUE SUS PRINTS
     * NO SALDRAN POR PANTALLA, PERO PODRAN SER LLAMADAS POR OTRAS FUNCIONES PARA UTILIZAR
     * SU FUNCIONALIDAD, Y DE ESTAR EN EL OVERRIDE, SALDRIAN POR PANTALLA, DE SER ASI EL CASO
        VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV*/

    /** funcion simple, esta se puede pensar que no es muy util ya que la logica es interna y
     * no podemos interactuar con elementos de fuera de esta funcion*/
    fun sayHello(){
        println("hola")
    }
    /** funciones con parametro de entrada, esta si permite actuar con variables creadas
     * fuera de la funcion */
    fun sayMyName(name: String){
        println("hola, mi nombre es $name")
    }
    /** funciones con mas de un parametro de entrada */
    fun sayMyNameAndAge(name: String, age : Int){
        println("hola, mi nombre es $name y mi edad es $age")
    }
    /** funciones con un valor de retorno */
    fun sumTwoNumbers (firstNumber: Int, secondNumber: Int): Int{
        val sum = firstNumber + secondNumber
        return sum
    }
}