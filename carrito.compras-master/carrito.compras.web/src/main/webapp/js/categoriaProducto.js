app.factory('categoriaProducto', ['$resource', function($resource){
        return $resource();
}]);

app.factory('pedido', ['$resource', function($resource){
        return $resource();
}]);

app.factory('facturaProductos', ['$resource', function($resource){
        return $resource();
}]);


app.controller('categoriaProductoCtrl', ['$http', 'categoriaProducto','pedido','facturaProductos', function ($http, categoriaProducto, pedido, facturaProductos) {
        
        var ob = this;
        ob.vista = 'compra';
        
        ob.flag = 'true';
        ob.productoSeleccionado = [];
        ob.informacion = {};
        
        ob.productosSeleccionados = function (row) {
            row.selected = !row.selected;
            if (row.selected === true && row.cantidadCompra>0 && row.cantidadCompra<row.cantidad) {
                ob.productoSeleccionado.push(row);
                console.log("ob.productoSeleccionado");
                console.log(ob.productoSeleccionado);
            } else {
                row.selected = !row.selected;
                row.cantidadCompra = 0;
            }

        };

        ob.removeProductos = function (row) {
            if (row.selected === true) {
                for (var i = 0; i < ob.productoSeleccionado.length  && row.selected; i++) {
                    if (ob.productoSeleccionado[i] === row) {
                        ob.productoSeleccionado.splice(row, 1);
                        row.selected = !row.selected;
                        row.cantidadCompra = 0;
                    }
                }
            } else {
                row.selected = !row.selected;
            }
        };
        
        ob.sumar = function(row){
                row.cantidadCompra+=1;
                console.log(row.cantidadCompra);
        };
        
        ob.restar = function(row){
            if (row.cantidadCompra>=0) {
            row.cantidadCompra-=1;
            console.log(row.cantidadCompra);
            }
        };
        
         ob.modal = function () {
            if (ob.flag === 'true') {
                ob.flag = 'false';
                console.log(ob.flag);
                console.log('ob.productoSeleccionado');
                console.log(ob.productoSeleccionado);
            } else {
                ob.flag = 'true';
                console.log(ob.flag);
                console.log('ob.productoSeleccionado');
                console.log(ob.productoSeleccionado);
            }
            
        };
        
        ob.comprar = function() {
            ob.vista = 'factura';
        }
        
//////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        var ob = this;
        ob.facturaObj = new pedido();
        ob.factura = new facturaProductos();
        
        ob.init = function () {
            ob.facturaObj.fecha = "";
            ob.facturaObj.pais = "";
            ob.facturaObj.departamento = "";
            ob.facturaObj.ciudad = "";
            ob.facturaObj.direccion = "";
            ob.facturaObj.telefonoFijo = "";
            ob.facturaObj.telefonoCelular = "";
        };
        
        ob.init();

        ob.finalizarCompra = function () {
            ob.factura.detallePedido = ob.productoSeleccionado;
            ob.factura.pedido = ob.facturaObj;
            
            $http.post('rest/pedido/add', ob.factura).then(
                    function succesCallback(response) {
                        console.log('response.data');
                        console.log(response.data);
                        ob.vista = 'compra';
                        ob.vista = 'compra';
                    },
                    function errorCallback(error) {
                        console.log('error');
                        console.log(error);
                    });
        }
        
        ob.imprimirFactura = function(){
            
        };
        
}]);