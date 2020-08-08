package apps.interview.facts.database

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import apps.interview.facts.data.Facts
import apps.interview.facts.utils.Converter

@Database(entities = [Facts::class],version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class FactsDatabase : RoomDatabase() {
    abstract fun facts() : FactsDao

    companion object{
        private var database : FactsDatabase ?= null

        fun Context.instance() : FactsDatabase? {
            if (database == null){
                database = Room.databaseBuilder(this,FactsDatabase::class.java,"facts_database")
                    .allowMainThreadQueries()
                    .build()
            }
            return database
        }

        fun Activity.instance() : FactsDatabase? {
            if (database == null){
                database = Room.databaseBuilder(this.applicationContext,FactsDatabase::class.java,"facts_database")
                    .allowMainThreadQueries()
                    .build()
            }
            return database
        }

        fun Application.instance() : FactsDatabase? {
            if (database == null){
                database = Room.databaseBuilder(this.applicationContext,FactsDatabase::class.java,"facts_database")
                    .allowMainThreadQueries()
                    .build()
            }
            return database
        }
    }
}