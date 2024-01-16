# Teste INFUSE TECNOLOGIA LTDA
### Tecnologias usadas:
- Java 17, Spring, Junit, mockito, flyway, mysql, lombok, maven, AngularJs.
- Consumo e consulta à API por xml.
#
## Instruçes para deploy
### Criar banco de dados no mysql com nome **testeinfuse**. As tabelas são criadas pelo flyway ao iniciar a aplicação
#
## Exemplo requisição GET de consulta de pedidos (Postman)
### Referência:
http://localhost:8080/pedidos/buscar?todos=true&dataCadastro=&numero=1
#
## Exemplo requisição POST de criar de pedidos (Postman)
### Referência:
http://localhost:8080/pedidos/novo
#
### Json usado:
```
{
   "pedidos":[
      {
         "numero":2,
         "dataCadastro":"16-07-2024",
         "nome":"Fonte gamer",
         "valor":"199.00",
         "quantidade":50,
         "cliente":{
            "id":3,
            "nome":"cliente 3"
         }
      }
 
```
### Xml usado:
```
<?xml version="1.0" encoding="UTF-8" ?>
<pedidoInput>
  <pedidos>
    <pedido>
        <numero>1</numero>
        <dataCadastro>2024-01-15</dataCadastro>
        <nome>café</nome>
        <valor>12.9</valor>
        <quantidade>60</quantidade>
        <cliente>
        <id>6</id>
        <nome>cliente 5</nome>
        </cliente>
    </pedido>
  </pedidos>
</pedidoInput>
```
## Caso tenham alguma dificuldade em rodar o projeto por gentileza me avisem
# Fico à disposição para sanar qualquer dúvida.

# Atenciosamente,
# Marcos
# omarcosoliveira1997@gmail.com | (61)98622-0070