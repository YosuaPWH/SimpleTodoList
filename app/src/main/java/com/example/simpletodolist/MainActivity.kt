package com.example.simpletodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvToDoList: RecyclerView
    private var list: ArrayList<ToDoList> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvToDoList = findViewById(R.id.rv_todolist)

        list.addAll(DataList.dataKu)

        val todoListAdapter = ToDoListAdapter(list)
        rvToDoList.adapter = todoListAdapter
        rvToDoList.layoutManager = LinearLayoutManager(this)

        btn_addtodo.setOnClickListener {
            val todoText = edt_todo.text.toString()
            if (todoText.isNotEmpty()) {
                val todo = ToDoList(todoText)
                todoListAdapter.addTodoList(todo)
                DataList.addTodo(todoText, false)
                edt_todo.text.clear()
            }
        }

        btn_delete.setOnClickListener {
            todoListAdapter.deleteTodoList()
        }
    }
}