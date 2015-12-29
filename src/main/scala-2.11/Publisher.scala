import akka.actor._

class Publisher extends Actor with ActorLogging {
  override def receive: Receive = {
    case Publish(event) =>
      log.info("publish event: {}", event)
      context.system.eventStream.publish(event)
    case any@_ =>
      log.warning("Unknown event: {}", any)
  }

  override def preStart(): Unit = log.info("publisher start")
}

case class Publish(events: Event)
