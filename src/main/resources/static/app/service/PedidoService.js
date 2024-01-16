;(function() {
    angular
        .module('app')
        .service('PedidoService', ['$http', function($http) {
            return {
                get: function(todos, dataCadastro, numero) {
                    return $http.get(`/pedidos/buscar?todos=${todos}&dataCadastro=${dataCadastro}&numero=${numero}`);
                }
                ,
                save: function(data) {
                    return $http.post('/pedidos/novo', data);
                }
                ,
                getCliente: function() {
                    return $http.get('/clientes/buscar');
                }
            };
        }]);
})();
