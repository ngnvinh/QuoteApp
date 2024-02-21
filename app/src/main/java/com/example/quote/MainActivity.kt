package com.example.quote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quote.data.DataSource
import com.example.quote.model.Quote
import com.example.quote.ui.theme.QuoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteTheme {
                // A surface container using the 'background' color from the theme
                    QuoteApp()

            }
        }
    }
}


@Composable
fun QuoteApp()
{
    QuoteList(
        quotesList = DataSource().loadQuote()
    )
}
@Composable
fun QuoteList(quotesList: List<Quote>, modifier: Modifier = Modifier)
{
    LazyColumn {
        items(quotesList)
        {
            quote: Quote -> QuoteCard(quote = quote)
        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier)
{

    Card (modifier = Modifier.fillMaxWidth())
    {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {


                //Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(id = quote.author),

                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(

                    painter = painterResource(id = quote.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp).clip(RectangleShape),
                    contentScale = ContentScale.Crop

                )
        }
            Text(
                text = stringResource(id = quote.stringResourceId),
                modifier = modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun QuoteCardReview()
{
    QuoteCard(Quote(R.string.quotes1, R.drawable.image1, R.string.author1))
}


/*
@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = quote.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Author Name", // Replace with actual author name
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = quote.stringResourceId),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

 */
/*
data class Quote(val author: String, val stringResourceId: Int, val imageResourceId: Int)


@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = quote.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = quote.stringResourceId),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

 */