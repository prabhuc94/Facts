package apps.interview.facts.utils

import androidx.room.TypeConverter
import apps.interview.facts.data.Row
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converter {

    @JvmStatic @TypeConverter
    fun listToString(rowData : List<Row>) : String{
        return Gson().toJson(rowData,object : TypeToken<List<Row>>(){}.type)
    }

    @JvmStatic @TypeConverter
    fun stringToList(rowString: String) : List<Row>{
        return Gson().fromJson(rowString, object : TypeToken<List<Row>>(){}.type)
    }
}