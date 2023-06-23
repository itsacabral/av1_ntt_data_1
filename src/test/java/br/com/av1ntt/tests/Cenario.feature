Feature: Buscar por vagas de PESSOA ENGENHEIRA DE DADOS

  Scenario: Buscar por vagas de PESSOA ENGENHEIRA DE DADOS
    Given que tenha acessado o site da ntt
    When clicar no menu job opportunities
    And buscar por pessoa engenheira de dados
    Then o site retornara a busca conforme parametros inseridos