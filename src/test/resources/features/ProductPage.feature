Feature: Seleccionar productos

  Background:
    Given que estoy en la página de cotizacion
  @test
  Scenario Outline: Seleccionar productos para aseguradora
    # Primer Escenario: Crear una cotizacion
    When Seleccionar un lugar de destino: "<Destiny>"
    When Enviar fecha de inicio de viaje :"<StartDay>", "<StartMonth>", "<StartYear>"
    When Enviar fecha de finalizacion de viaje :"<EndDay>", "<EndMonth>", "<EndYear>"
    When Seleccionar cantidad de pasajeros y edades: "<YearsOld>"
    When Click en boton cotizar
    Then Validar visualizacion de pantalla de cotizacion dado los siguientes datos: "<StartDay>", "<StartMonth>", "<StartYear>", "<EndDay>", "<EndMonth>", "<EndYear>"
    # Segundo Escenario: Seleccionar un producto
    When seleccionar producto de tipo: "<Product>"
    Then Validar visualizacion de pagina Pasajero mostrando el producto "<Product>" seleccionado

    Examples:

      | Destiny | StartDay | StartMonth | StartYear | EndDay | EndMonth | EndYear | YearsOld | Product |
      | africa  | 14       | julio      | 2023      | 26     | julio    | 2023    | 28,15    | classic |