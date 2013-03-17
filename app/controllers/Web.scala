/*
import com.twitter.finagle.http.{Request, ParamMap, Http, Response}
import java.net.InetSocketAddress
import com.zzorba.cards.Deck
import com.zzorba.zombicide._
import org.jboss.netty.handler.codec.http.{HttpRequest, HttpResponse}
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.Service
import com.twitter.util.Future
import util.Properties
import xml.NodeSeq

object Web {
  def main(args: Array[String]) {
    val port = Properties.envOrElse("PORT", "8080").toInt
    println("Starting on port:"+port)
    ServerBuilder()
      .codec(Http())
      .name("hello-server")
      .bindTo(new InetSocketAddress(port))
      .build(new Zombiecide)
    println("Started.")
  }
}

class Zombiecide extends Service[HttpRequest, HttpResponse] {
  def deckAction(deck: Deck[ZombieCard], params: ParamMap): HttpResponse = {


    val response = Response()
    response.setStatusCode(200)
    response.setContentString(content.toString)
    response
  }

  def newGameAction(): HttpResponse = {
    val content =
      <html>
        <div>New Game</div>
        <ul>{
          ZombieCardSet.SuggestedDecks.map(set => {
            val deck =
              ZombieCardFactory.createDeck(Nil, set.ids.map(ZombieCardFactory.forId))
            <li><a href={"/?deck=%s".format(ZombieCardFactory.reshuffle(deck).encode)}>{set.name}</a></li>
          })
        }</ul>
        <div>
          For more information about these decks, see this <a href="http://guillotinegames.com/en/blog-zombie-cards-secrets">blog post</a>.
        </div>
      </html>

    val response = Response()
    response.setStatusCode(200)
    response.setContentString(content.toString)
    response
  }

  def apply(req: HttpRequest): Future[HttpResponse] = {
    val req2 = new Request {
      def remoteSocketAddress: InetSocketAddress = null
      def httpRequest: HttpRequest = req
    }
    val params = new ParamMap(req2)
    val response = params.get("deck").map(ZombieCardFactory.decode) match {
      case Some(deck) => deckAction(deck, params)
      case None => newGameAction()
    }
    Future(response)
  }
}               */