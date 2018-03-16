var app = angular.module('application', ['ngRoute', 'ngResource'])
        .config(function ($routeProvider, $httpProvider) {
            $routeProvider.when('/producto', {
                templateUrl: 'views/var appproducto.html'
            }).when('/login', {
                templateUrl: 'views/user.html',
                controller: 'UserController',
                controllerAs: 'UserController'
            }).when('/admin/categoria', {
                templateUrl: 'views/categoria.html'
            }).when('/admin/producto', {
                templateUrl: 'views/producto.html'
            }).when('/home', {
                templateUrl: 'views/home.html'
            }).when('/informacionUsuario', {
                templateUrl: 'views/informacionUsuario.html'
            }).when('/admin', {
                templateUrl: 'views/admin.html'
            }).otherwise('/');
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            $httpProvider.defaults.headers.common['Cache-Control'] = 'no-cache, no-store, must-revalidate';
        })
        .service('RedirectService', function ($window) {
            this.redirectTo = function (url) {

                $window.location.href = '#!/' + url;
            };
        })
        .directive('encabezado', function(){
            return{ 
                templateUrl:'views/admin/admin.html'
            };
            
        });

        
function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        evt.preventDefault();
    }
}
