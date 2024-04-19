import org.scalatestplus.play._
import models.TaskListInMemoryModel

class TaskListInMemoryModelSpec extends PlaySpec {
  "TaskListInMemoryModel" must {
    "validate login for default user" in {
      TaskListInMemoryModel.validateUser("qla", "pass") mustBe (true)
    }
    "reject login with wrong password" in {
        TaskListInMemoryModel.validateUser("qla", "password") mustBe (false)
    }

    "reject login with wrong username" in {
        TaskListInMemoryModel.validateUser("qla1", "password") mustBe (false)
    }
    
    "get correct default task" in{
        TaskListInMemoryModel.getTasks("qla") mustBe List("Make video","Eat","Sleep","Code")
    } 
    
    "create new user with no tasks" in {
        TaskListInMemoryModel.createUser("Mike", "password") mustBe (true)
        TaskListInMemoryModel.getTasks("Mike") mustBe (Nil)
    }
    
    "create new user with existing name" in {
        TaskListInMemoryModel.createUser("qla", "password") mustBe (false)
    }

    "add new task for default user" in {
        TaskListInMemoryModel.addTask( "qla", "testing")
        TaskListInMemoryModel.getTasks("qla") must contain ("testing")
    }

    "add new task for new user" in {
        TaskListInMemoryModel.addTask("Mike", "testing1")
        TaskListInMemoryModel.getTasks ("Mike") must contain ("testing1")
    }

    "remove task from default user" in {
        TaskListInMemoryModel.removeTask("qla", TaskListInMemoryModel.getTasks ("qla").indexOf("Eat"))
        TaskListInMemoryModel.getTasks ("qla") must not contain ("Eat")
    }
}
}
