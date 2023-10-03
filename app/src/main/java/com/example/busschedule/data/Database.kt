package com.example.busschedule.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database
abstract class Database: RoomDatabase {
    abstract fun busScheduleDao(): BusScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    Database::class.java,
                    "database"
                )
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}