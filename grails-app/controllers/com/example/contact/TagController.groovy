package com.example.contact

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class TagController {

    static scaffold = true

    //def index() { }

}
