class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/contacts/facebook"(controller: 'contact', action: 'facebookContacts')

        "/"(view: '/index')
        "500"(view:'/error')
	}
}
