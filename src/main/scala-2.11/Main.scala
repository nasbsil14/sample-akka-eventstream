import akka.actor._
object Main {
  def main (args: Array[String]) {
    println("EventStream Start")

    val system = ActorSystem("eventstream")
    val publisher = system.actorOf(Props(classOf[Publisher]), "publisher")
    val subscriber = system.actorOf(Props(classOf[Subscriber]), "subscriber")

    publisher ! Publish(Searched("id: 0001"))
    publisher ! Publish(Registered("id: 0002"))
    publisher ! Publish(Updated("id: 0003"))
    publisher ! Publish(Deleted("id: 0004"))
    Thread.sleep(10L)

//    subscriber ! PoisonPill
//    Thread.sleep(30L)

    system.shutdown()
    println("EventStream End")
  }
}