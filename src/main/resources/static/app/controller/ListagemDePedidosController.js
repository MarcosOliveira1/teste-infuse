;(function() {
    angular
        .module('app')
        .controller('ListagemDePedidosController', ['$scope', 'SweetAlert', 'PedidoService', function($scope, SweetAlert, PedidoService) {
            var vm = this;

            $scope.numeroFiltro = '';
            $scope.dataFiltro = '';
            $scope.todosFiltro = true;


            function buscarPedidos() {
                PedidoService.get($scope.todosFiltro, $scope.dataFiltro, $scope.numeroFiltro).then(function(response) {
                    vm.pedidos = response.data;
                }, function(response) {
                    SweetAlert.swal({
                        title: 'Erro ao carregar pedidos',
                        text: response.data.mensagem,
                        type: 'error'
                    });
                });
            }
            function init() {
                buscarPedidos();
            }

            function formatarData(data) {
                data = new Date(data);
                const yyyy = data.getFullYear();
                let mm = data.getMonth() + 1; // Months start at 0!
                let dd = data.getDate();
                if (dd < 10) dd = '0' + dd;
                if (mm < 10) mm = '0' + mm;
                return formattedToday = dd + '-' + mm + '-' + yyyy;
            }

            function filtrarTodos(){
                if ($scope.todosFiltro) {
                    $scope.numeroFiltro = '';
                    $scope.dataFiltro = '';
                }
            }

            function iniciarFiltrar() {
                $scope.todosFiltro = false;
            }

            init();

            vm.filtrarTodos = filtrarTodos;
            vm.iniciarFiltrar = iniciarFiltrar;
            vm.buscarPedidos = buscarPedidos;

            return vm;
        }]);
})();
