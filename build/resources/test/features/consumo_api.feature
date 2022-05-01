#lenguage: es
#encoding: UTF-8
#2
Feature: Consumo total de api post

  @primero
  Scenario: Quiero realizar un consumo directo que no sea outline
    Given I want to run an Api

    When run an Api with params

    Then I Get a Response

  @segundo
  Scenario Outline: Quiero realizar este request con models
    Given I want to run an Api
    When run an Api with params differents
      | name   | job   |
      | <name> | <job> |
    Then I Get a Response
    Examples:
      | name   | job             |
      | Camila | QA              |
      | yeison | Desarrollador   |
      | Brayan | infraestructura |
      | juan   | Analyst         |
