package apps.interview.facts.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facts")
data class Facts(
    @NonNull @PrimaryKey(autoGenerate = false)
    val title: String, // About Canada
    val rows: List<Row>? = null
)

data class Row(
    val description: String? = null, // Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony
    val imageHref: String? = null, // http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg
    val title: String? = null // Beavers
)