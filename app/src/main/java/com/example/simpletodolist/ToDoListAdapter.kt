package com.example.simpletodolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class ToDoListAdapter(private val list: ArrayList<ToDoList>) :
    RecyclerView.Adapter<ToDoListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ListViewHolder(view)
    }

    fun addTodoList(todo: ToDoList) {
        list.add(todo)
        notifyItemInserted(list.size - 1)
    }

    fun deleteTodoList() {
        list.removeAll { todo ->
            todo.check
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listTodoKu = list[position]

        holder.itemView.apply {
            tv_list.text = listTodoKu.title
            checkbox.isChecked = listTodoKu.check
            strikeThrough(tv_list, listTodoKu.check)
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                strikeThrough(tv_list, isChecked)
                listTodoKu.check = !listTodoKu.check
            }
        }
    }

    private fun strikeThrough(tv: TextView, isChecked: Boolean) {
        if (isChecked) {
            tv.paintFlags = tv.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tv.paintFlags = tv.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}