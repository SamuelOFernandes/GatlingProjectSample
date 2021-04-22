gatling-performance
=========================

Projeto simples em Maven para a demonstração da execução de testes de performance com exemplos de spike test e load test.

Para executar um teste específico utilize comando abaixo:

    $mvn gatling:test -Dgatling.simulationClass=computerdatabase.<NomeDaClasseSimulation>

Se desejar executar todas as classes de teste execute o comando :

    $mvn gatling:test
