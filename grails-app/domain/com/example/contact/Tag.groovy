package com.example.contact

class Tag {
    String tagName

    static belongsTo = [contact: Contact]

    static constraints = {
    }

    String toString(){
        tagName
    }
}
