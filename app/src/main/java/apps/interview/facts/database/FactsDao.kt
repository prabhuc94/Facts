package apps.interview.facts.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import apps.interview.facts.data.Facts

@Dao
interface FactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(factsData : Facts)

    @Query("SELECT * FROM facts")
    fun getFacts() : LiveData<Facts>
}