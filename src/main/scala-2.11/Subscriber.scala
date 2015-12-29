import akka.actor._

class Subscriber extends Actor with ActorLogging {
  override def receive: Receive = {
    case Searched(description) =>
      log.info("Received searched event: {}", description)
    case Registered(description) =>
      log.info("Received registered event: {}", description)
    case Updated(description) =>
      log.info("Received updated event: {}", description)
    case Deleted(description) =>
      log.info("Received deleted event: {}", description)
    case any@_ =>
      log.warning("Unknown message: {}", any)
  }

  override def preStart(): Unit = {
    log.info("subscriber start")
    context.system.eventStream.subscribe(self, classOf[Event])
  }

  override def postStop(): Unit = {
    log.info("subscriber stop")
  }
}
