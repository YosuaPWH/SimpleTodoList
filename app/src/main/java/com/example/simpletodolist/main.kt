package com.example.simpletodolist

import java.io.BufferedReader
import java.io.File
import java.util.*

fun main() {
    val arr = mutableListOf<ToDoList>()

    val buffer: BufferedReader = File("app\\src\\main\\java\\com\\example\\simpletodolist\\dataTodo.txt").bufferedReader()
//    val inputString = buffer.use { it.readText() }

    var line: String = buffer.readLine()
//    println(line)

    val ckck = line.split(",")
    println(ckck[0])
    println(ckck[1].trim().toBoolean())

    DataList.addTodo(ckck[0], ckck[1].trim().toBoolean())
//    val linfe: ToDoList = ToDoList("line", true)
//    arr.add(linfe)



//    val st: StringTokenizer = StringTokenizer(inputString, ",")
//    println(inputString)
//
//    println(st.nextToken().trim())
//    println(st.nextToken().trim())

}