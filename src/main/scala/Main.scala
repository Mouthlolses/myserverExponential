import cask.model.Request
import upickle.default.*


case class User(name: String, age: Int)

case class Game(title: String, gender: String)

implicit val rw: ReadWriter[User] = macroRW

implicit val rwt: ReadWriter[Game] = macroRW

object Main extends cask.MainRoutes:
  private var users = List.empty[User]
  private var games = List.empty[Game]

  @cask.post("/users")
  def addUser(request: cask.Request): cask.Response[String] = {
    val bodyText = request.text()
    val user = read[User](bodyText)
    users = users :+ user
    cask.Response("User Saved", statusCode = 201)
  }

  @cask.post("/games")
  def addGame(request: cask.Request): cask.Response[String] = {
    val bodyText = request.text()
    val game = read[Game](bodyText)
    games = games :+ game
    cask.Response("Game Saved", statusCode = 201)
  }

  @cask.get("/games")
  def getGames(): ujson.Value = {
    writeJs(games)
  }

  @cask.get("/users")
  def getUsers(): ujson.Value = {
    writeJs(users)
  }

  initialize()