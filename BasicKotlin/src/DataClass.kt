fun main(args: Array<String>){
 data class Podcast(val title: String, val description: String,
                    val url: String )

    val podcast = Podcast("Android Developer", "A podcast for android developers",
                           "https://feeds.feedburner.com")

    val podcast2 = podcast.copy("Developers Backstage")

    val (title, description, url) = podcast2
    print("Title = $title, url = $url")
}