package com.example.quote.data

import com.example.quote.R
import com.example.quote.model.Quote

class DataSource {
    fun loadQuote(): List<Quote> {
        return listOf<Quote>(


            Quote(R.string.quotes1, R.drawable.image1, R.string.author1),
            Quote(R.string.quotes2, R.drawable.image2, R.string.author2),
            Quote(R.string.quotes3, R.drawable.image3, R.string.author3),
            Quote(R.string.quotes4, R.drawable.image4, R.string.author4),
            Quote(R.string.quotes5, R.drawable.image5, R.string.author5),
            Quote(R.string.quotes6, R.drawable.image6, R.string.author6),
            Quote(R.string.quotes7, R.drawable.image7, R.string.author7),
            Quote(R.string.quotes8, R.drawable.image8, R.string.author8),
            Quote(R.string.quotes9, R.drawable.image9, R.string.author9),
            Quote(R.string.quotes10, R.drawable.image10, R.string.author10)

        )
    }
}