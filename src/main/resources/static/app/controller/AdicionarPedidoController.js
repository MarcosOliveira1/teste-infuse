;(function() {
    angular
        .module('app')
        .controller('AdicionarPedidoController', ['$scope','$uibModal', 'PedidoService','SweetAlert', function($scope, $uibModal, PedidoService, SweetAlert) {
            var vm = this;
            $scope.pedido = {};
            $scope.pedidosList = [];

            function iniciarPedido() {
                $scope.pedido = {
                    numero: '',
                    dataCadastro: new Date(),
                    nome: '',
                    valor: '',
                    quantidade: 1,
                    cliente: {
                        id: '',
                        nome: ''
                    }
                };
            }
            function init() {
                iniciarPedido();
                PedidoService.getCliente().then(function(response) {
                    vm.clientes = response.data;
                }, function(response) {
                    SweetAlert.swal({
                        title: 'Erro ao carregar clientes',
                        text: response.data.mensagem,
                        type: 'error'
                    });
                })
            }

            function formatarData(data) {
                data = new Date(data);
                const yyyy = data.getFullYear();
                let mm = data.getMonth() + 1; // Months start at 0!
                let dd = data.getDate();
                if (dd < 10) dd = '0' + dd;
                if (mm < 10) mm = '0' + mm;
                const formattedToday = dd + '-' + mm + '-' + yyyy;
                return formattedToday;
            }
            function addPedido() {
                $scope.pedido.dataCadastro = formatarData($scope.pedido.dataCadastro);
                $scope.pedidosList.push($scope.pedido);
                   iniciarPedido();
            }

            function removerPedido(index) {
                let list = $scope.pedidosList;
                list.splice(index, 1);

            }

            function calcularTotal(quantidade, valorUnitario) {
                let total = valorUnitario*quantidade;
                return calcularDeconto(quantidade, total);
            }

            function calcularDeconto(quantidade, valorTotal) {
                if (quantidade >= 10 ){
                    return valorTotal*0.90;
                } else if (quantidade > 5){
                    return valorTotal*0.95;
                } else{
                    return valorTotal;
                }
            }

            function salvarPedido() {
                let data = {"pedidos": $scope.pedidosList}

                PedidoService.save(data).then(function(response) {
                    $uibModal.open({
                        ariaLabelledBy: 'modal-title',
                        ariaDescribedBy: 'modal-body',
                        templateUrl: 'components/modals/sucessoAoAdicionarPedido.html',
                        controllerAs: 'vm',
                        controller: function() {
                            var vm = this;
                            vm = response.data;
                            return vm;
                        }
                    });
                    $scope.pedidosList = [];
                }, function(response) {
                    SweetAlert.swal({
                        title: 'Erro ao criar novo pedido',
                        text: response.data.errors[0],
                        type: 'error'
                    });
                });
            }

            init();

            vm.salvarPedido = salvarPedido;
            vm.addPedido = addPedido;
            vm.removerPedido = removerPedido;
            vm.calcularTotal = calcularTotal;
            return vm;
        }]);
})();
