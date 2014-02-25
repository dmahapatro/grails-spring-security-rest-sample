package com.example.contact

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

class ContactController extends RestfulController<Contact> {

    static responseFormats = ['json', 'xml']

    ContactController() {
        super(Contact)
    }

    @Secured(['permitAll'])
    def index() { }

    @Secured(['ROLE_ADMIN'])
    def facebookContacts(){
        def result = Tag.findAllByTagName('facebook')*.contact
        respond result, [excludes: ['class']]
    }
}
