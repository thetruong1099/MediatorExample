package com.example.mediatorexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animals_table")
data class Animals(
    @ColumnInfo(name = "name_col") var name: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id_col")
    var id: Int = 0
}