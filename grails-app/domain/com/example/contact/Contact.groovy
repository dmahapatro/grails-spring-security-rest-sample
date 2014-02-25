package com.example.contact

class Contact {
    String name
    String phone
    String email

    static hasMany = [tags: Tag]

    static constraints = {
    }

    String toString(){
        "$name - $phone"
    }
}
