package br.com.zup.mvvm.room.example

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Example(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var exampleTitle: String
)

