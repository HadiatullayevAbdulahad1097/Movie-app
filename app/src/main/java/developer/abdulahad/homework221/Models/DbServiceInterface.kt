package developer.abdulahad.homework221.Models

interface DbServiceInterface {

    fun addUser(user: User)

    fun getUsers():ArrayList<User>

    fun upDateUser(user: User):Int

    fun delete (user: User)
}