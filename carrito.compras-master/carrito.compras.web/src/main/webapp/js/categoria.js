/* global app */

app.factory('categoria',['$resource', function($resource){
        return $resource('rest/categoria/:Id', {serviceId: '@codigo'},
            {
                updateService: {method: 'PUT'},
                save: {method: 'POST'}
            }
        );
}]);

app.controller('categoriaController', ['$http', 'categoria', function ($http, categoria) {
        var ob = this;
        ob.prueba = 'prueba';
        
        ob.listCategoria = [];
        ob.categoriaListByParam = [];
        ob.flag = "search";
        ob.error = "";
        ob.correcto = "";
        ob.categoriaObj = new categoria();
        
        ob.init = function () {
            
            ob.categoriaObj.codCategoria = "";
            ob.categoriaObj.descripcion = "";
            ob.categoriaObj.estado = "";
            ob.error = "";
        };
        
        ob.init;
        
        ob.categoriaList = function () {
            ob.error = "";
            ob.flag = "search";
            ob.init();
            $http.get('rest/categoria/listCategoria', ob.categoriaObj).then(
                    function successCallback (response){
                        if (response.data === null || response.data.length === 0) {
                            ob.error = "no hay categorias";
                            console.log(response.data);
                        } 
                        angular.copy(response.data, ob.listCategoria);
                        getData();
                    },
                    function errorCallback(error) {
                        ob.error = "Ocurrió un error, no fue posible hacer la busqueda de categorias";
                        console.log(error);
                    });
        };
        
        ob.categoriaList();
        
        ob.searchById = function (codCategoria) {
            ob.error = "";
            ob.flag = "edit";
            $http.post('rest/categoria/searchById/'+codCategoria).then(
                    function successCallback (response){
                        if (response.data === null || response.data.length === 0) {
                            ob.error = "no hay categorias con ese codigo";
                            console.log(ob.error);
                            console.log(response.data);
                            ob.flag = "search";
                        } 
                        ob.flag = "edit";
                        ob.categoriaObj = response.data;
                    },
                    function errorCallback(error) {
                        ob.error = "Ocurrió un error, no fue posible hacer la busqueda de categorias";
                        console.log(error);
                        ob.categoriaList();
                    });
        };
       
        
        ob.searchByParam = function () {
            ob.error = "";
            ob.flag = "search";
            ob.categoriaObj.estado = 'Activo';
            $http.post('rest/categoria/searchByParams/', ob.categoriaObj).then(
                    function successCallback (response){
                        if (response.data === null || response.data.length === 0) {
                            ob.error = "no hay categorias activas";
                            console.log(ob.error);
                            console.log(response.data);
                            ob.flag = "search";
                        } 
                        ob.flag = "search";
                        console.log('response.data');
                        console.log(response.data);
                        ob.categoriaListByParam = response.data;
                        
                    },
                    function errorCallback(error) {
                        ob.error = "Ocurrió un error, no fue posible hacer la busqueda de categorias";
                        console.log(error);
                        ob.categoriaList();
                    });
        };
        
        ob.searchByParam ();

        ob.addCategoria = function(){
            ob.error = "";
            ob.flag = "add";
        };
        
        ob.crearCategoria = function (){
            ob.error = "";
            ob.flag = "add";
            console.log(ob.categoriaObj);
            $http.post('rest/categoria/add/',ob.categoriaObj).then(
                    function successCallback (response){
                        ob.init();
                        ob.responseSucces = "Categoria agregada correctamente";
                        ob.categoriaList();
                    },
                    function errorCallback(error){
                        ob.error = "Ocurrio un error, no fue posible crear la categoria " + ob.categoriaObj.descripcion;
                        console.log(error);
                        console.log(ob.error);
                    });
        };
        
        ob.guardarCambios = function (){
            ob.error = "";
            $http.put('rest/categoria/update', ob.categoriaObj).then(
                    function successCallback (response){
                        ob.init();
                        ob.correcto = "Categoria guardada correctamente";
                        ob.categoriaList();
                    },
                    function errorCallback(error){
                        ob.error = "Ocurrio un error, no fue posible actualizar la categoria de codio "+ ob.categoriaObj.codCategoria;
                        console.log(error);
                        ob.categoriaList();
                    });
        };
        
        ob.inactivar = function (row){
            ob.init();
            ob.categoriaObj = row;
            if (row.estado == 'Activo') {
                ob.categoriaObj.estado = 'Inactivo';
            } else {
                ob.categoriaObj.estado = 'Activo';
            }
            
            ob.error = "";
            ob.flag = "";
            $http.put('rest/categoria/update', ob.categoriaObj).then(
                    function successCallback (response){
                        ob.categoriaList();
                        ob.responseSucces = "Categoria eliminada correctamente";
                    },
                    function errorCallback(error){
                        ob.error = "Ocurrio un error, no fue posible eliminar la categoria de codio "+ ob.categoriaObj.codCategoria;
                        console.log(error);
                        
                    });
        };
       
        ob.tracks = [];
        
        function getData() {
            angular.copy(ob.listCategoria, ob.tracks);
        };
        
        ob.estados = [{
                codigo: 0,
                nombre: 'Inactivo'
            }, {codigo: 1,
                nombre: 'Activo'
            }];
        
}]);


