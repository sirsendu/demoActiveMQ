class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
	"/api/trades"
	{
	    controller = "notification"
	    action = [POST: "index2"]
	}
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
