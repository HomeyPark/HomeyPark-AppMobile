package Beans

class User {

    var id:Int
    var name:String
    var lastName:String
    var email:String
    var password:String

    constructor(id: Int, name: String, lastName: String, email: String, password: String) {
        this.id = id
        this.name = name
        this.lastName = lastName
        this.email = email
        this.password = password
    }
}