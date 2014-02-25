angular.module('contact', [])
    .controller('contactCtrl', ['$scope', '$http', function($scope, $http){
        $scope.user = {username: '', password: ''};
        $scope.result = undefined;
        $scope.showLogin = false;
        var headers = { 'X-Auth-Token': '' };

        $scope.facebookContacts = function(){
            $http.get('http://localhost:8080/grails-spring-security-rest-sample/contacts/facebook', {headers: headers})
                .success(function(data){
                    $scope.result = data;
                })
                .error(function(error, status){
                    if(status != 200) {
                        $scope.showLogin = true;
                        $scope.result = "Not able to get resource for unauthorized user. Check Dev Tool for details.";
                    }
                });
        };

        $scope.authenticate = function(){
            $http.post('http://localhost:8080/grails-spring-security-rest-sample/api/login',
                       {username: $scope.user.username, password: $scope.user.password})
                .success(function(result){
                    $scope.result = result;
                    headers['X-Auth-Token'] = result.token;
                })
                .error(function(error){
                    $scope.result = error;
                });
        }
    }])
    .directive("pop", function(){
        return {
            scope: false,
            link: function($scope, element){
                var options = {
                    container: 'body',
                    html: true,
                    content: "Click again to access resource<br>(now using the generated token)"
                };

                $scope.$watch('result', function(value){
                    if(value && value.token){
                        $(element).popover(options);
                        $(element).popover('show');
                    }
                });
            }
        }
    });