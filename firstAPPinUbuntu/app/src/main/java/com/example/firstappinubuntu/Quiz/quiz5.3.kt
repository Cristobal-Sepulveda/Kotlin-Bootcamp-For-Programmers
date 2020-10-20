package com.example.firstappinubuntu.Quiz

/** Practice Time

Create a top-level constant for the maximum number of books a person could borrow.

Inside the Book class, create a method canBorrow() that returns true or false depending on whether a
user has already borrowed the max number of books.

Create a Constants object that provides constants to the book. For this example, provide the BASE_URL
for all books in the library catalog. Inside Book, add a method printUrl that creates and prints a
URL composed of BASE_URL, the book title, and “.html”.

The base URL is really of interest to the Book class. As such, it makes sense to limit its scope to
the Book class. Use a companion object to define the constant in Book.
 */
const val maxNumberOfBooks = 30
const val MAX_NUMBER_BOOKS = 20
fun canBorrow(hasBooks: Int): Boolean {
    return (hasBooks < MAX_NUMBER_BOOKS)
}
object Constants {
    const val BASE_URL = "http://www.turtlecare.net/"
}
fun printUrl() {
    println(Constants.BASE_URL + title + ".html")
}
companion object{
    val BASE_URL = "http://www.turtlecare.net/"
}