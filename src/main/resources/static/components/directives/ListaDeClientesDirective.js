;(function() {
    'use strict';

    angular
        .module('app')
        .directive('listaDeClientes', [function () {
            return {
                restrict: 'E',
                scope: {
                    'clientes': '='
                }
            }
        }]);

})();
