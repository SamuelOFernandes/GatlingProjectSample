package submarinoperformancetests

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class SpikeTest extends Simulation {

  //1 HTTP Configuration

  val httpConfiguration = http
    .baseUrl("https://www.submarino.com.br")
    .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Mobile Safari/537.36")


  //2 Scenario Definition


  val scn: ScenarioBuilder = scenario("Teste de Carga home page Submarino")
    .exec(http(requestName = "Get Home Page")
      .get("/"))

  //3 Injeção de Carga

  setUp(
    scn.inject(
      nothingFor(5 seconds),
      constantUsersPerSec(2) during (10 seconds),
      rampUsers(100) during (5 seconds),
      constantUsersPerSec(5) during (10 seconds),
      rampUsers(100) during (5 seconds)
    ).protocols(httpConfiguration)
  )
}
