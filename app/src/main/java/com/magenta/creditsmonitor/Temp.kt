package com.magenta.creditsmonitor



/**
 * Created by ${User} on ${Date}
 */
class Curious private constructor() {
    companion object  {
        operator fun invoke(): Curious {
            println("IN companion invoke, no instance exists")
            return Curious()
        }
    }

    init {
        println("In init, instance is now exists")
    }

}

fun main() {
    val curious = Curious()
    print(curious)
}