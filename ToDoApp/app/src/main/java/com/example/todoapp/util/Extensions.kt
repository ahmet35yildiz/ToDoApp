package com.example.todoapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.useTransition(v:View,id:Int){
    findNavController(v).navigate(id)
}
fun Navigation.useTransition(v:View,id:NavDirections){
    findNavController(v).navigate(id)
}