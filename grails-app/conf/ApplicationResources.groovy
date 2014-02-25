modules = {

    application {
        resource url: '/js/application.js'
    }

    jquery {
        resource url: 'https://code.jquery.com/jquery-1.11.0.js'
    }

    angular {
        resource url: 'https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.js'
    }

    bootstrap {
        dependsOn 'jquery'
        resource url: 'http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'
        resource url: 'http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'
    }

    contactApp {
        dependsOn 'angular, bootstrap'
        resource url: '/css/main.css'
        resource url: '/js/contact/app.js'
    }
}