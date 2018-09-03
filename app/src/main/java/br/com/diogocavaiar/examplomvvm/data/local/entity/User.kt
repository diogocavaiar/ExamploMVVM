package br.com.diogocavaiar.examplomvvm.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true)
                val uid: Long,
                val firstName: String = "",
                val fullName: String = "",
                val avatar_url: String = "")
