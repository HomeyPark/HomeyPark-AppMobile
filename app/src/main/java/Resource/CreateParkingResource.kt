package Resource

import Beans.Location
import Beans.Schedule

data class CreateParkingResource (
    val address: String,
    val width: Double,
    val length: Double,
    val height: Double,
    val price: Double,
    val phone: String,
    val description: String,
    val location: Location,
    val schedule: Schedule
)