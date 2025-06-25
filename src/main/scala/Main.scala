object Main extends cask.MainRoutes:

  @cask.get("/")
  def index() = cask.Response(
    data = Array.emptyByteArray,
    statusCode = 302,
    headers = Seq("Location" -> "/static/hello.html")
  )


  @cask.staticResources("/static")
  def staticEndpoint(): String = "."


  initialize()
