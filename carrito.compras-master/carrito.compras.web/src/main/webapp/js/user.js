/* global app */

app.factory('User',['$resource', function($resource){
        return $resource('rest/user/:Id', {serviceId: '@Id'},
            {
                updateService: {method: 'PUT'},
                save: {method: 'POST'}
            }
        );
    }]);

app.controller('UserController', ['$scope', '$http', '$window','User', function ($scope, $http, $window, User) {
       
        var ob = this;
        ob.authenticated = false;
        
        
        ob.init = function() {
            ob.userObj = new User();
            
            ob.flag = "espera";
            ob.error = "";
            ob.userObj.username = "";
            ob.userObj.password = "";

            ob.error = "";
        };
       
        ob.init();
        
        ob.ingresar = function() {
            console.log (ob.userObj);
            ob.error = "";
            $http.post('rest/user/verificar', ob.userObj).then(
                    function successCallback (response){
                        if (response.data === null || response.data.length === 0) {
                            ob.error = "USUARIO O COTRASEÑA INCORRECTA";
                            console.log(response.data);
                        }
                        else {
                            ob.flag = "autenticado";
                            ob.authenticated = true;
                            $window.location.href = "#!/admin";
                        }
                    },
                    function errorCalback (error){
                        ob.flag = "error";
                        ob.error = "Ocurrio un error, no entro al succes ingresar ";
                        console.log(error);
                    });
        };
       
       
}]);


