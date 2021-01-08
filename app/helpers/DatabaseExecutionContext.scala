package helpers

import akka.actor.ActorSystem
import com.google.inject.Inject
import com.google.inject.Singleton
import com.google.inject.name.Named
import play.api.libs.concurrent.CustomExecutionContext

@Singleton
@Named("dbContext")
class DatabaseExecutionContext @Inject()(system: ActorSystem)
  extends CustomExecutionContext(system, "contexts.db")