package controllers
import javax.inject._
import play.api.mvc._
import play.api.i18n._
import models.TaskListInMemoryModel
import play.api.libs.json._
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer

@Singleton
class WebSocketChat @Inject() (cc:ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc){
    def index = Action { implicit request=>
        Ok(views.html.chatPage())
    }
/*
    def socket = WebSocket.accept[String, String]{ request=>
        println("Getting socket")
        ActorFlow.actorRef { out=>
          ??
        
        }
    }
}
*/

