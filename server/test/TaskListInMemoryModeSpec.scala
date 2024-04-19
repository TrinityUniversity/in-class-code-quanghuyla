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
  }
}
