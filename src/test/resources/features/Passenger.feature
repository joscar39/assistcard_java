Feature: Llenar formulario de datos de pasajero y formulario ¿Quién recibe el voucher?

  Background:
    Given que estoy en la página de cotizacion
  @test
  Scenario Outline: llenado de datos correctos en el formulario de pasajeros
    # 1er Escenario: Realizar una cotización
    When Seleccionar un lugar de destino: "<Destiny>"
    When Enviar fecha de inicio de viaje :"<StartDay>", "<StartMonth>", "<StartYear>"
    When Enviar fecha de finalizacion de viaje :"<EndDay>", "<EndMonth>", "<EndYear>"
    When Seleccionar cantidad de pasajeros y edades: "<YearsOld>"
    When Click en boton cotizar
    Then Validar visualizacion de pantalla de cotizacion dado los siguientes datos: "<StartDay>", "<StartMonth>", "<StartYear>", "<EndDay>", "<EndMonth>", "<EndYear>"
    # Segundo Escenario: Seleccionar un producto
    When seleccionar producto de tipo: "<Product>"
    Then Validar visualizacion de pagina Pasajero mostrando el producto "<Product>" seleccionado
    # 3er Escenario: Ingresar datos del pasajero
    When Ingresar dato en el campo nombre: "<Name>"
    When Ingresar dato en el campo apellido: "<Lastname>"
    When Seleccionar una opcion del campo documento: "<TypeDocuments>"
    When Ingresar numero de documento Valido: "<NumberDocument>"
    When Ingresar Dia de nacimiento: "<Day>"
    When Seleccionar mes de nacimiento: "<Month>"
    When Ingresar Año de nacimiento: "<Year>"
    When Seleccionar genero: "<Gender>"
    Then Validar fecha de nacimiento coincide con edad de pasajero
    When Ingresar correo valido en campo email: "<Email>"
    Then Confirmar correo ingresado en el campo confirma tu email: "<Email2>"
    When Seleccionar tipo de telefono: "<TypePhone>"
#    When Seleccionar codigo pais telefonico: "<CodeCountry>"
    When Ingresar numero de telefono valido: "<NumberPhone>"
    When Click en boton continuar
    Then Validar que se muestre la pagina de Mejoras y adicionales


    Examples:

      | Destiny | StartDay | StartMonth | StartYear | EndDay | EndMonth | EndYear | YearsOld | Product | Name  | Lastname | TypeDocuments | NumberDocument | Day | Month | Year | Gender     | Email                 | Email2                | TypePhone | CodeCountry | NumberPhone |
      | sur     | 15       | junio      | 2024      | 20     | junio    | 2024    | 28       | classic | Pedro | Peraza   | pasaporte     | 225sasd22      | 25  | julio | 1994 | No Binario | joscarlenyn@gmail.com | joscarlenyn@gmail.com | celular   | 58          | 22135121    |

