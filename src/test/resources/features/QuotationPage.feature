Feature: Realizar una cotizacion

  Background:
    Given que estoy en la página de cotizacion
  @test
  Scenario Outline: Seleccionar usaurios y rango de fecha para realziar cotizacion
    # Primer Escenario: Crear una cotizacion
    When Seleccionar un lugar de destino: "<Destiny>"
    When Enviar fecha de inicio de viaje :"<StartDay>", "<StartMonth>", "<StartYear>"
    When Enviar fecha de finalizacion de viaje :"<EndDay>", "<EndMonth>", "<EndYear>"
    When Seleccionar cantidad de pasajeros y edades: "<YearsOld>"
    When Click en boton cotizar
    Then Validar visualizacion de pantalla de cotizacion dado los siguientes datos: "<StartDay>", "<StartMonth>", "<StartYear>", "<EndDay>", "<EndMonth>", "<EndYear>"

    Examples:
      | Destiny | StartDay | StartMonth | StartYear | EndDay | EndMonth | EndYear | YearsOld |
      | sur     | 15       | julio      | 2023      | 25     | juo      | 2023    | 15,20    |
