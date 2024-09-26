package Beans

class Parking {
    var id: Long
    var address: String
    var width: Double
    var length: Double
    var height: Double
    var price: Double
    var phone: String
    var description: String

    constructor(
        id: Long,
        address: String,
        width: Double,
        length: Double,
        height: Double,
        price: Double,
        phone: String,
        description: String
    ) {
        this.id = id
        this.address = address
        this.width = width
        this.length = length
        this.height = height
        this.price = price
        this.phone = phone
        this.description = description
    }
}