package developer.abdulahad.homework221.Models

class User {
    var id: Int? = null
    var name:String? = null
    var authors:String? = null
    var about:String? = null
    var date:String? = null

    constructor(name: String?, authors: String?, about: String?, date: String?) {
        this.name = name
        this.authors = authors
        this.about = about
        this.date = date
    }

    constructor()

    constructor(id: Int?, name: String?, authors: String?, about: String?, date: String?) {
        this.id = id
        this.name = name
        this.authors = authors
        this.about = about
        this.date = date
    }

}