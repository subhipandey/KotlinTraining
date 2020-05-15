

package com.subhipandey.android.colorquotes

object QuoteGenerator {

    private val quoteList = listOf(
        Quote("Our choices show what we truly are.", "A. Dumbledore"),
        Quote("Stay hungry, stay foolish.", "S. Jobs"),
        Quote("An eye for an eye leaves the whole world blind.", "M. Gandhi"),
        Quote("The world is full of obvious things that nobody by any chance ever observes.", "S. Holmes"),
        Quote("Imagination is more important than knowledge.", "A. Einstein")
    )

    fun getQuote(): Quote = quoteList.random()

}