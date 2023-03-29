package uz.it_teacher.cookpedia.util

interface ItemTouchAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int)

    fun onItemDismiss(position: Int)
}