package com.example.simpletodolist

object DataList {
    var dataList = arrayListOf(
        arrayOf("Training", false),
        arrayOf("Coding", false)
    )

    fun addTodo(kata: String, check: Boolean) {
        val temp = arrayOf(kata, check)
        val size = dataList.size
        dataList = arrayListOf<Array<out Any>>().apply {
            for (ch in 0 until size) {
                add(dataList[ch])
            }
            add(temp)
        }
    }

    val dataKu: ArrayList<ToDoList>
        get() {
            val list = arrayListOf<ToDoList>()
            for (data in dataList) {
                val listKu = ToDoList()
//                listKu.id = data[0] as Int
                listKu.title = data[0] as String
                listKu.check = data[1] as Boolean

                list.add(listKu)
            }
            return list
        }


}


