trait Event {}
case class Searched(description: String) extends Event
case class Registered(description: String) extends Event
case class Updated(description: String) extends Event
case class Deleted(description: String) extends Event