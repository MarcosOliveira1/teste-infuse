;(function() {
    angular
        .module('app')
        .controller('BuscarClienteController', ['SweetAlert', 'ClienteService', function(SweetAlert, ClienteService) {
            var vm = this;

            function init() {
                ClienteService.getCliente().then(function(response) {
                    vm.clientes = response.data;
                }, function(response) {
                    SweetAlert.swal({
                        title: 'Erro ao carregar clientes',
                        text: response.data.mensagem,
                        type: 'error'
                    });
                });
            }

            init();

            return vm;
        }]);
})();
