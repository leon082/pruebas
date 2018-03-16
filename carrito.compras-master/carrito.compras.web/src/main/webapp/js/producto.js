/* global app */

app.factory('producto',['$resource', function ($resource) {
        return $resource();
    }]);
app.factory('CategoriaPorProducto',['$resource', function ($resource) {
        return $resource();
    }]);
app.factory('FiltroBusqueda',['$resource', function ($resource) {
        return $resource();
    }]);


app.controller('productoController', ['$http', 'producto', '$scope', 'CategoriaPorProducto', 'FiltroBusqueda',  function ($http, producto, $scope, CategoriaPorProducto, FiltroBusqueda) {
        var ob = this;
        
        
        ob.productosFiltroList = [];
        ob.productosList = [];
        ob.categoriaList = [];
        ob.categoriaObj = {};
        ob.categoriaPorProducto = new CategoriaPorProducto();
        ob.filtro = new FiltroBusqueda();
        ob.productoObj = new producto();
        ob.flag = "add";

        ob.filtroBusqueda = new FiltroBusqueda();
        
        ob.init = function () {
            ob.productoObj.codProducto = null;
            ob.productoObj.nombreProducto = null;
            ob.productoObj.descProducto = null;
            ob.productoObj.precio = null;
            ob.productoObj.cantidad = null;
            ob.productoObj.foto = null;
            ob.productoObj.estado = null;
            ob.productoObj.valorMayor = null;
            ob.productoObj.valorMenor = null;
            ob.productoObj.categorias = [];
            
            ob.filtroBusqueda.categoriasFiltro = null;
            ob.filtroBusqueda.descripcion = null;
            ob.filtroBusqueda.precioMenor = null;
            ob.filtroBusqueda.precioMayor = null;
            ob.filtroBusqueda.nombre = null;
            
            ob.error = "";
        };
        
        ob.init;

        ob.productoList = function () {
            ob.error = "";
            ob.flag = "search";
            ob.init();
            $http.get('rest/producto/listProductos').then(
                    function successCallback(response) {
                        if (response.data === null || response.data.length === 0) {
                            ob.error = "no hay productos";
                            console.log(ob.error);
                            console.log(response.data);
                            ob.flag = "searchFailed";
                        }
                        angular.copy(response.data, ob.productosList);
                        getData();
                    },
                    function errorCallback(error) {
                        ob.error = "Ocurrió un error, no fue posible hacer la busqueda de los productos";
                        console.log(ob.error);
                        console.log(error);
                    });
        };

        ob.productoList();

        ob.addProducto = function () {
            ob.error = "";
            ob.flag = "add";
        };


        ob.crearProducto = function () {
            ob.error = "";
            ob.flag = "add";
            if (ob.categoriaList.length > 0) {
                ob.productoObj.categorias = ob.categoriaList;
                $http.post('rest/producto/add', ob.productoObj).then(
                        function successCalback(response) {
                            if (response === null) {
                                ob.flag = "failAdd";
                                ob.error = "no se puso agregar el producto";
                                console.log(response.data);
                            } else {
                                ob.flag = "Add";
                                ob.error = "Agregado correctamente";
                                ob.productoList();
                            }

                        },
                        function errorCallback(error) {
                            ob.error = "Ocurrio un error, no fue posible crear el producto " + ob.productoObj.nombreProducto;
                            console.log(ob.error);
                            console.log(error);
                            ob.flag = "addFailed";
                        });
            } else {
                ob.flag = "failEdit";
                ob.error = "Seleccione al menos una categoria";
            }
        },

        ob.searchById = function (codProductoRow) {
            ob.error = "";
            ob.flag = "";
            $http.post('rest/producto/productoByKey/' + codProductoRow).then(
                    function succesCalback(response) {
                        if (response.data === null || response.data.length === 0) {
                            ob.error = "No se pudo traer la informacion";
                            console.log(ob.error);
                            console.log(response.data);
                            ob.flag = "searchFailed";
                        }else {
                            ob.categoriaList = [];
                            ob.flag = "edit";
                            ob.productoObj = response.data;
                            console.log(ob.productoObj);
                            for (var i = 0; i < ob.productoObj.categorias.length; i++) {
                                if (ob.productoObj.categorias[i].estado === 'Activo') {
                                    ob.productoObj.categorias[i].selected = true
                                    ob.categoriaList.push(ob.productoObj.categorias[i]);
                                }else {
                                    ob.productoObj.categorias[i].selected = false;
                                }

                            }
                            console.log(ob.productoObj.categorias);
                        }
                    },
                    function errorCallback(error) {
                        ob.productoList();
                        ob.error = "Ocurrió un error, no fue posible hacer la busqueda deñ producto";
                        console.log(error);
                    });
        }; 
        
        ob.searchByParams = function () {
            ob.flag = 'search';
            ob.error = 'fail';
            $http.post('rest/producto/searchByParams/', ob.productoObj).then(
                    function succesCallback(response) {
                        if (response === null || response.data.length === 0) {
                            ob.flag = 'searchFailed';
                            ob.error = "No se encontro coincidencias";
                            console.log('response.data');
                            console.log(response.data);
                        } else {
                            angular.copy(response.data, ob.productosList);
                            getData();
                        }
                    },
                    function errorCallback(response) {
                        console.log('response.data error Callback');
                        console.log(response.data);
                        ob.productoList();
                    });
        };
        
        // si la categoria que vino al principio no esta dentro de las nuevas categorias
        // entonces agregarla con estado Inactivo
        ob.guardarCambios = function () {
            ob.flag = "edit";
            ob.error = "";
            var existe;
            console.log('guardar');
            for (var i = 0; i < ob.productoObj.categorias.length; i++) {
                if (ob.productoObj.categorias[i].estado === 'Activo') {
                    existe = false;
                    for (var j = 0; j < ob.categoriaList.length; j++) {
                        if (ob.categoriaList[j].codCategoria === ob.productoObj.categorias[i].codCategoria) {
                            existe = true;
                        }
                    }
                    if (existe === false) {
                        ob.productoObj.categorias[i].estado = 'Inactivo';
                        ob.categoriaList.push(ob.productoObj.categorias[i]);
                    }
                }

            }
            console.log(ob.productoObj);
            ob.productoObj.categorias = ob.categoriaList;
            
            $http.put('rest/producto/update/', ob.productoObj).then(
                    function successCallback(response) {
                        ob.flag = "search";
                        ob.init();
                        ob.productoList();
                    },
                    function errorCallback(error) {
                        ob.flag = "editFailed";
                        ob.error = "Ocurrio un error, no fue posible actualizar el producto de codio " + ob.productoObj.codProducto;
                        console.log(ob.error);
                        console.log(error);
                    });
        };

        ob.inactivar = function (row){
            ob.init();
            ob.productoObj = row;
            if (row.estado === 'Activo') {
                ob.productoObj.estado = 'Inactivo';
            } else {
                ob.productoObj.estado = 'Activo';
            }
            
            ob.error = "";
            ob.flag = "";
            $http.put('rest/producto/update', ob.productoObj).then(
                    function successCallback (response){
                        ob.productoList()();
                        ob.responseSucces = "Producto"+ob.productoObj.estado;
                        console.log(ob.responseSucces);
                        ob.flag = 'search';
                    },
                    function errorCallback(error){
                        ob.error = "Ocurrio un error, no fue posible eliminar la categoria de codio "+ ob.categoriaObj.codCategoria;
                        console.log(error);
                        ob.flag = 'searchFailed';
                        
                    });
        };
        
        ob.seleccionados = function (row) {
            if (row.selected === true) {
                row.estado = 'Activo';
                ob.categoriaList.push(row);
            } else {
                ob.removeCategoria(row.codCategoria);
            }
        };

        ob.removeCategoria = function (id) {
            var flag = true;
            for (var i = 0; i < ob.categoriaList.length && flag; i++) {
                if (ob.categoriaList[i].codCategoria === id) {
                    ob.categoriaList.splice(i, 1);
                    flag = false;
                }
            }
        };

        ob.productosFiltro = function () {
            ob.flag = 'search';
            ob.error = 'fail';
            ob.filtroBusqueda.estado = 'Activo';
            $http.post('rest/producto/filtroUsuario/', ob.filtroBusqueda).then(
                    function succesCallback(response) {
                        if (response === null || response.data.length === 0) {
                            ob.flag = 'searchFailed';
                            ob.error = "No se encontro coincidencias";
                            
                        } else {
                            console.log('response.data Filtro');
                            console.log(response.data);
                            angular.copy(response.data, ob.productosFiltroList);
                            ob.categoriaList = [];
                            getData();
                        }
                    },
                    function errorCallback(response) {
                        console.log('response.data error Callback');
                        console.log(response.data);
                        ob.productoList();
                    });
        };
        
        ob.productosFiltro ();
        
        ob.estados = [{
                codigo: 0,
                nombre: 'Inactivo'
            }, {codigo: 1,
                nombre: 'Activo'
            }];
        
        ob.precios = [{
                codigo: 0,
                valorMenor: 1000,
                valorMayor: 10000
            }, {codigo: 1,
                valorMenor: 10000,
                valorMayor: 50000
            }, {codigo: 2,
                valorMenor: 50000,
                valorMayor: 100000
            }, {codigo: 3,
                valorMenor: 100000,
                valorMayor: 200000
            }, {codigo: 4,
                valorMenor: 200000,
                valorMayor: 500000
            }, {codigo: 5,
                valorMenor: 500000,
                valorMayor: 1000000
            }, {codigo: 6,
                valorMenor: 1000000,
                valorMayor: 2000000
            }, {codigo: 7,
                valorMenor: 2000000,
                valorMayor: 5000000
            }, {codigo: 8,
                valorMenor: 5000000,
                valorMayor: 5000000
            }];
        
        ob.tracks = [];

        function getData() {
            angular.copy(ob.productosList, ob.tracks);
        }
        ;

        ob.reset = function () {
            ob.init();
            ob.flag = 'search';
            ob.error = "";
            ob.productoList();
            ob.categoriasSelected = [];
        }
        
        ob.resetFiltro = function () {
            ob.init();
            ob.productosFiltro();
        }




    }]);

