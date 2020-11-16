package Kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

fun main(){

    // Get API key from https://github.com/settings/tokens/new and select the User field and generate key
    val apiKey = "superSecretKey"
    // URL where the post request will be made
    val githubUrl = URL("https://api.github.com/user")

    // Function to get one of the quotes from the arraylist
    val quote = fetchQuote()
    // Create a json format
    val bio = """{"bio": "$quote"}"""

    with(githubUrl.openConnection() as HttpURLConnection) {
        // Define as post require
        requestMethod = "POST"
        // Add properties
        setRequestProperty ("Authorization", "token $apiKey");
        setRequestProperty("Content-Type", "application/json");
        doOutput = true;
        // Send the new bio in the post request
        val wr = OutputStreamWriter(getOutputStream());
        wr.write(bio);
        wr.flush();

        println("URL : $url")
        println("Response Code : $responseCode")

        if(responseCode != 200){
            println("Error connecting to API, Error Code: $responseCode")
            return;
        }

        BufferedReader(InputStreamReader(inputStream)).use {
            val response = StringBuffer()

            var inputLine = it.readLine()
            while (inputLine != null) {
                response.append(inputLine)
                inputLine = it.readLine()
            }
            println("Response : $response")
        }
    }
}


fun fetchQuote(): String {

// I got lazy so quotes are just an arraylist :)
val quotesList = listOf("Genius is one percent inspiration and ninety-nine percent perspiration. - Thomas Edison","You can observe a lot just by watching. - Yogi Berra","A house divided against itself cannot stand. - Abraham Lincoln","Difficulties increase the nearer we get to the goal. - Von Goethe","Fate is in your hands and no one elses - Byron Pulsifer","Be the chief but never the lord. - Lao Tzu","Nothing happens unless first we dream. - Carl Sandburg","Well begun is half done. - Aristotle","Life is a learning experience, only if you learn. - Yogi Berra","Self-complacency is fatal to progress. - Margaret Sangster","Peace comes from within. Do not seek it without. - Buddha","What you give is what you get. - Byron Pulsifer","We can only learn to love by loving. - Iris Murdoch","Life is change. Growth is optional. Choose wisely. - Karen Clark","You'll see it when you believe it. - Wayne Dyer","Today is the tomorrow we worried about yesterday. - Unknown","It's easier to see the mistakes on someone else's paper. - Unknown","Every man dies. Not every man really lives. - Unknown","To lead people walk behind them. - Lao Tzu","Having nothing, nothing can he lose. - William Shakespeare")

//Get the size of the arraylist
val arrSize = quotesList.size - 1
// Get a random index from the arraylist
val index = (0..arrSize).random()

// Return the string for that index
    return quotesList[index]

}
