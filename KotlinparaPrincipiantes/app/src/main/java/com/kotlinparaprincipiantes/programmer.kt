package com.kotlinparaprincipiantes

/** creada por scorpio */
                        /**propiedades*/
class Programmer (val name : String,
                  var age : Int,
                  val languages: Array<Language>,
                  val friends: Array<Programmer>? = null){
                            /** toda variable con un ? dps del tipo de dato indica que podra ser
                             * NULL, en este caso lo dejamos asi para que si en main activity
                             * no se agrega un friend al crear un Programmer, este por defecto
                             * quede null*/

    /** este es un enumerado que va a llamarse Language, q va a servir para designar los
     * diferentes lenguajes de programación que puede tener un programador y es el tipo de dato
     * que crearemos que se incluiran en el array de arriba, asi estamos conteniendo el tipo
     * de lenguaje y a su vez nuestro programa y en definitiva, evitando errores.*/
    /** es decir, de la manera que vemos abajo, es la manera en la que se crea un tipo de dato */

    enum class Language{
        kotlin,
        swift,
        java,
        c
    }

    fun code(){
            for(language in languages){
                println("yo $name estoy programando en $language")
            }

    }

}