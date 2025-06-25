import upickle.default.*


case class User(name: String, age: Int)
implicit val rw: ReadWriter[User] = macroRW

object Main extends cask.MainRoutes:
  var users = List.empty[User]

  @cask.post("/users")
  def addUser(request: cask.Request): cask.Response[String] = {
    val bodyText = request.text()
    val user = read[User](bodyText)
    users = users :+ user
    cask.Response("User Saved", statusCode = 201)
  }

  @cask.get("/users")
  def getUsers(): ujson.Value = {
    writeJs(users)
  }

  initialize()