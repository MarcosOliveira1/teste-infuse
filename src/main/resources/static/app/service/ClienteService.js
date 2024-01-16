;(function() {
    angular
        .module('app')
        .service('ClienteService', ['$http', function($http) {
            return {
                getCliente: function() {
                    return $http.get('/clientes/buscar');
                }
            };
        }]);
})();
