import java.util.*

data class Task(val id: Int, var description: String, var isCompleted: Boolean = false)

class ToDoList {
    private val tasks = mutableListOf<Task>()
    private  var nextId = 1 // This will be used to generate the next id for the task


    fun addTask(description: String) {
        tasks.add(Task(nextId++, description))
        println("Task added successfully")
    }

    fun viewTasks() {
        if (tasks.isEmpty()) {
            println("No tasks to show")
            return
        }else{
            tasks.forEach { task ->
                val status = if (task.isCompleted) "X" else " "
                println("${task.id} [$status] ${task.description}")
            }
        }
    }

    fun markAsCompleted(id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            task.isCompleted = true
            println("Task marked as completed")
        } else {
            println("Task not found")
        }
    }

    fun removeTask(id: Int) {
        val removed = tasks.removeIf { it.id == id }
        if (removed) {
            println("Task removed successfully")
        } else {
            println("Task not found")
        }
    }
}

fun main() {
    val toDoList = ToDoList()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n==== To-Do List ====")
        println("1. Add Task")
        println("2. View Tasks")
        println("3. Mark as Completed")
        println("4. Remove Task")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> {

                println("Enter task description: ")
                val description = scanner.next()
                toDoList.addTask(description)
            }
            2 -> toDoList.viewTasks()
            3 -> {
                print("Enter task id: ")
                val id = scanner.nextInt()
                toDoList.markAsCompleted(id)
            }
            4 -> {
                print("Enter task id: ")
                val id = scanner.nextInt()
                toDoList.removeTask(id)
            }
            5 -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid choice")
        }
    }
}