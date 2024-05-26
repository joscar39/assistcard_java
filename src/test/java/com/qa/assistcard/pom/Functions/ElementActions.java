package com.qa.assistcard.pom.Functions;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;

public class ElementActions {
	
	private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    public  String getTextOfElement(WebElement element){
        return element.getText();
    }
    public String getTextBylocator(By locator){
        return driver.findElement(locator).getText();
    }

    public void sendText(By locator, String inputText){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(inputText);
            System.out.println("Se envio el texto: "+inputText);
        }catch (TimeoutException ex){
            System.out.println(ex.getMessage());
            System.out.println("El elemento " + locator+" no está disponible en la página dentro del tiempo de espera especificado.");
        }catch (ElementNotInteractableException e){
            System.out.println(e.getMessage());
            System.out.println("El elemento " + locator+", está oculto y no se puede interactuar con él.");

        }
    }

    /**
     * Ingresa un número en un elemento web identificado por un locator.
     * @param locator El locator que identifica al elemento web.
     * @param inputNumber El número a enviar.
     */
    public void sendNumber(By locator, int inputNumber){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(Integer.toString(inputNumber));
            System.out.println("Se envió el número: " + inputNumber);
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
            System.out.println("El elemento " + locator + " no está disponible en la página dentro del tiempo de espera especificado.");
        } catch (ElementNotInteractableException e) {
            System.out.println(e.getMessage());
            System.out.println("El elemento " + locator + ", está oculto y no se puede interactuar con él.");
        }
    }
    public void clickOnElement(By locator){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
            System.out.println("Se hizo click sobre el elemento: "+locator);
        }catch (TimeoutException ex){
            System.out.println("El elemento " + locator+" no está disponible en la página dentro del tiempo de espera especificado.");
            System.out.println(ex);

        }catch (ElementNotInteractableException e){
            System.out.println("El elemento " + locator+", está oculto y no se puede interactuar con él.");
            System.out.println(e);


        }catch (Exception ex) {
            System.out.println("No se puedo realizar click sobre el elemento: "+ locator);
            System.out.println(ex);

        }
    }

    public boolean findElementIsDisplayed(By locator){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("El elemento: "+ locator + "Si esta visible en pantalla");
            return element.isDisplayed();

        }catch (TimeoutException ex){
            System.out.println("El elemento " + locator+" no está disponible en la página dentro del tiempo de espera especificado.");
            System.out.println(ex);

        }catch (ElementNotInteractableException e){
            System.out.println("El elemento " + locator+", está oculto y no se puede interactuar con él.");
            System.out.println(e);


        }catch (Exception ex) {
            System.out.println("No se puedo realizar evaluar si el elemento: " + locator + " estaba disponible en pantalla");
            System.out.println(ex);

        }
        return false;

    }
    public void visit(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void multiClickOnElement(By locator, int cant_click){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            for (int i = 1; i <=cant_click; i++) {
                element.click();
            }
        }catch (TimeoutException ex){
            System.out.println("El elemento " + locator+" no está disponible en la página dentro del tiempo de espera especificado.");
            System.out.println(ex);

        }catch (ElementNotInteractableException e){
            System.out.println("El elemento " + locator+", está oculto y no se puede interactuar con él.");
            System.out.println(e);


        }catch (Exception ex) {
            System.out.println("No se puedo realizar la accion multiclick sobre el elemento: " + locator);
            System.out.println(ex);

        }


    }

    /**
     *Función que permite tomar una captura de pantalla.
     *
     * @param locator Localizador armado por By y la ruta del localizador.
     * @param selectType Tipo de dato a evaluar en el select: "text", "value" o "index".
     * @param selectData Dato a buscar dentro de las opciones de select.
     * **/
    public void selectInput(By locator, String selectType, String selectData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement dropdown = element;
            selectType = selectType.toLowerCase();
            Select select = new Select(dropdown);
            if (selectType.equalsIgnoreCase("text")) {
                select.selectByVisibleText(selectData);
            } else if (selectType.equalsIgnoreCase("value")) {
                select.selectByValue(selectData);
            } else if (selectType.equalsIgnoreCase("index")) {
                int index = Integer.parseInt(selectData);
                select.selectByIndex(index);
            }
        }catch (TimeoutException ex){
            System.out.println("El elemento " + locator+" no está disponible en la página dentro del tiempo de espera especificado.");
            System.out.println(ex);

        }catch (ElementNotInteractableException e){
            System.out.println("El elemento " + locator+", está oculto y no se puede interactuar con él.");
            System.out.println(e);


        }catch (Exception ex) {
            System.out.println("No se pudo realizar la accion de enviar testo en el elemento: " + locator);
            System.out.println(ex);

        }

    }

    public void selectDateInDatePicker_ByRange(By locator_calendar, By locator_month, By locator_year, By locator_next, String day_date, String month, String year) {
        try {
            month = month.toLowerCase().substring(0, 1).toUpperCase() + month.toLowerCase().substring(1);
            Map<String, String> months_english = new HashMap<String, String>() {{
                put("Enero", "January");
                put("Febrero", "February");
                put("Marzo", "March");
                put("Abril", "April");
                put("Mayo", "May");
                put("Junio", "June");
                put("Julio", "July");
                put("Agosto", "August");
                put("Septiembre", "September");
                put("Octubre", "October");
                put("Noviembre", "November");
                put("Diciembre", "December");
            }};
            boolean check_month = false;
            String trad_months = null;
            if (months_english.containsKey(month)) {
                trad_months = months_english.get(month);
                check_month = true;
            }
            assert check_month : "Error el mes ingresado es un valor incorrecto";
            clickOnElement(locator_calendar);

            int i = 0;
            while (i < 1) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement mes_actual = null;
                WebElement anio_actual = null;
                List<WebElement> day = null;
                mes_actual = driver.findElements(locator_month).get(0);
                anio_actual = driver.findElements(locator_year).get(0);
                if ((mes_actual.getText().equals(month) || mes_actual.getText().equals(trad_months))
                        && anio_actual.getText().equals(year)) {
                    // Ajustar el path del elemento "DAY" en caso de usar esta funcion en otra
                    // página web, ya que puede estar construido de forma diferente el xpath
                    day = driver.findElements(By.xpath("//a[text()='" + day_date + "']"));
                    day.get(0).click();
                    System.out.println("Se selecciono el dia: " + day_date + " de " + month + " " + year);
                    i++;
                } else {
                    clickOnElement(locator_next);
                }
            }
        } catch (TimeoutException ex){
            System.out.println("El elemento " + locator_calendar+" no está disponible en la página dentro del tiempo de espera especificado.");
            System.out.println(ex);
        }catch (ElementNotInteractableException e){
            System.out.println("El elemento " + locator_calendar+", está oculto y no se puede interactuar con él.");
            System.out.println(e);

        }catch (Exception ex) {

            System.out.println(ex);

        }
    }

    public void addPassengerAndSendAge(By locator, String Age) {
        try {
            String[] sep = Age.split(",");
            int can = sep.length;
            if (can > 8) {
                can = 8;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            multiClickOnElement(locator, (can-1));
            for (int i = 1; i <= can; i++) {
                WebElement element = driver.findElement(By.xpath("//input[@id='passengerAge-" + i + "']"));
                element.sendKeys(sep[i - 1]);
                System.out.println("Se cargo la edad de " + sep[i - 1] + " para el pasajero " + i);
            }
        } catch (Exception ex) {
            System.out.println("No fue posible cargar las edades " + Age + " para los pasajeros destinados");
            System.out.println(ex);
        }
    }

    public String obtainCountryDestination(String selectDestino) {

        try {
            String[] palabras = selectDestino.split(" ");
            StringBuilder newDestino = new StringBuilder();

            for (int pi = 0; pi < palabras.length; pi++) {
                String palabraActual = palabras[pi];
                if (!palabraActual.equals("and")) {
                    String primeraLetra = palabraActual.substring(0, 1).toUpperCase();
                    String restoPalabra = palabraActual.substring(1);
                    newDestino.append(primeraLetra).append(restoPalabra);
                } else {
                    newDestino.append(palabraActual);
                }
                if (pi < palabras.length - 1) {
                    newDestino.append(" ");
                }

            }
            String evaluate = String.valueOf(newDestino);

            String[] a = {"Europa", "Europe"};
            String[] b = {"North America", "Norte America", "America Del Norte", "Del Norte", "Norte", "North"};
            String[] c = {"Caribe", "Caribe-Mexico", "Mexico", "Caribbean"};
            String d = "Africa";
            String e = "Asia";
            String f = "Oceania";
            String[] g = {"Multidestino", "Multidestination"};
            String[] h = {"Dentro de mi pais", "Dentro", "Mi", "Pais", "Mi Pais"};
            String[] i = {"South America", "Suramerica", "Sur America", "America Del Sur", "Sudamerica", "Sur"};
            String[] j = {"Receptivo", "Receptive"};
            String country = null;

            if (Arrays.asList(a).contains(evaluate)) {
                country = "02";
            } else if (Arrays.asList(b).contains(evaluate)) {
                country = "01";
            } else if (Arrays.asList(c).contains(evaluate)) {
                country = "03";
            } else if (d.equals(evaluate)) {
                country = "05";
            } else if (e.equals(evaluate)) {
                country = "06";
            } else if (f.equals(evaluate)) {
                country = "07";
            } else if (Arrays.asList(g).contains(evaluate)) {
                country = "12";
            } else if (Arrays.asList(h).contains(evaluate)) {
                country = "08";
            } else if (Arrays.asList(i).contains(evaluate)) {
                country = "04";
            } else if (Arrays.asList(j).contains(evaluate)) {
                country = "09";
            }
            System.out.println("El país destino es: " + country);
            return country;
        } catch (Exception ex) {
            System.out.println("Error no se encontró coincidencias en la lista de opciones respecto al dato ingresado: " + selectDestino);
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public long obtainsDiferenceBetweenDates(String StartDay, String StartMonth, String StartYear, String EndDay, String EndMonth, String EndYear){
        try {
            String monthStart = StartMonth.toLowerCase().substring(0, 1).toUpperCase() + StartMonth.toLowerCase().substring(1);
            String monthEnd = EndMonth.toLowerCase().substring(0, 1).toUpperCase() + EndMonth.toLowerCase().substring(1);
            HashMap<String, String> monthsEnglish = new HashMap<String, String>() {{
                put("Enero", "January");
                put("Febrero", "February");
                put("Marzo", "March");
                put("Abril", "April");
                put("Mayo", "May");
                put("Junio", "June");
                put("Julio", "July");
                put("Agosto", "August");
                put("Septiembre", "September");
                put("Octubre", "October");
                put("Noviembre", "November");
                put("Diciembre", "December");
            }};
            HashMap<String, String> numberMonths = new HashMap<String, String>() {{
                put("January", "1");
                put("February", "2");
                put("March", "3");
                put("April", "4");
                put("May", "5");
                put("June", "6");
                put("July", "7");
                put("August", "8");
                put("September", "9");
                put("October", "10");
                put("November", "11");
                put("December", "12");
            }};
            String tradMonthsStart = null;
            String tradMonthsEnd = null;
            int numeroStart = 0;
            int numeroEnd = 0;
            if (monthsEnglish.containsKey(monthStart) && monthsEnglish.containsKey(monthEnd)) {
                tradMonthsStart = monthsEnglish.get(monthStart);
                tradMonthsEnd = monthsEnglish.get(monthEnd);
            }
            if (numberMonths.containsKey(tradMonthsStart) && numberMonths.containsKey(tradMonthsEnd)) {
                numeroStart = Integer.parseInt(numberMonths.get(tradMonthsStart));
                numeroEnd = Integer.parseInt(numberMonths.get(tradMonthsEnd));
            }
            int intStartYear = Integer.parseInt(StartYear);
            int intStartDay = Integer.parseInt(StartDay);
            int intEndYear = Integer.parseInt(EndYear);
            int intEndtDay = Integer.parseInt(EndDay);

            LocalDate fecha1 = LocalDate.of(intStartYear, numeroStart, intStartDay);
            LocalDate fecha2 = LocalDate.of(intEndYear, numeroEnd, intEndtDay);

            Period periodo = Period.between(fecha1, fecha2);

            System.out.println("La diferencias de dias entre ambas fechas es de: " + ((periodo.getDays())+1));
            return (periodo.getDays()+1);
        }catch  (Exception e){
            e.printStackTrace();
            System.out.println("Error en la fecha ingresada, no es posible obtener la diferencia entre ambas fechas \n"
                    + "Inicio: " + StartDay + "/" + StartMonth + "/" + StartYear + "\n"
                    + "Fin: " + EndDay + "/" + EndMonth + "/" + EndYear);
            return 0;

        }


    }

    public boolean findElementIsVisibleByText(String texto) {
        boolean resultado = false;
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement elemento = driver.findElement(By.xpath("//*[contains(text(), '" + texto + "')]"));
            if (elemento.isDisplayed()) {
                resultado = true;
                System.out.println("Se encontró el elemento con el texto: " + texto);
            }
        } catch (NoSuchElementException ex) {
            System.out.println("El elemento con el texto " + texto + " no fue localizado");
            System.out.println(ex.getMessage());

        }
        return resultado;
    }


    /**
     * Función que permite tomar una captura de pantalla.
     *
     * @param nombre Nombre con el cual se guardará la captura.
     * @return Captura de pantalla en el reporte allure.
     */
    public byte[] capturarPantalla(String nombre) {
        System.out.println("Adjuntar captura de pantalla");
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(nombre, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        return screenshot;
    }

    public void scrollToElement(By locator){
        try{
            WebElement element = findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", element);
            if (element.isDisplayed()) {
                System.out.println("El elemento está visible después de hacer scroll." + element);
            } else {
                System.out.println("El elemento no está visible después de hacer scroll." + element);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió una excepción al intentar hacer scroll: " + e.getMessage());
            System.out.println("NO se encontro el elemento: "+ locator);
        }
    }

    /**
     * Funcion que permite obtener el value de las opciones que contiene el select de tipo de documento
     *
     * @param dato valor de tipo String indicando el tipo de documento a seleccionar
     * @return value del tipo de documento relacionado al dato ingresado, para ser ubicado en el select
     */
    public static String obtainTypeDocumentInInputSelect(String dato) {
        try {
            String a = "Dni";
            String b = "Ci";
            String c = "Lc";
            String[] d = {"Pasaporte", "Passport"};
            String e = "Le";

            // Convertir primera letra a mayúscula y el resto a minúsculas
            dato = dato.toLowerCase().substring(0, 1).toUpperCase() + dato.toLowerCase().substring(1);
            String nameValue = null;

            if (dato.equals(a)) {
                nameValue = "3";
            } else if (dato.equals(b)) {
                nameValue = "2";
            } else if (dato.equals(c)) {
                nameValue = "4";
            } else if (Arrays.asList(d).contains(dato)) {
                nameValue = "1";
            } else if (dato.equals(e)) {
                nameValue = "5";
            }

            // Imprimir mensaje con el valor seleccionado
            System.out.printf("El value seleccionado es %s, para obtener el tipo de documento: %s", nameValue, dato);
            return nameValue;

        } catch (Exception ex) {
            System.out.printf("El dato ingresado %s para seleccionar documento es un dato invalido", dato);
            System.out.println(ex);

            return null;
        }
    }


    /**
     * Este metodo recibe un mes en español y devuelve el número de mes correspondiente en formato de dos dígitos (por ejemplo, "01" para enero).
     * @param Month mes en español
     * @return el número de mes correspondiente en formato de dos dígitos, o null si el mes ingresado no es válido.
     */
    public String obtain_number_month(String Month) {
        try {
            // Convertimos la primera letra a mayúscula y el resto a minúsculas
            Month = Month.toLowerCase().substring(0, 1).toUpperCase() + Month.substring(1);

            // Definimos un HashMap que asocia los meses en español con los meses en inglés
            HashMap<String, String> months_english = new HashMap<String, String>() {{
                put("Enero", "January");
                put("Febrero", "February");
                put("Marzo", "March");
                put("Abril", "April");
                put("Mayo", "May");
                put("Junio", "June");
                put("Julio", "July");
                put("Agosto", "August");
                put("Septiembre", "September");
                put("Octubre", "October");
                put("Noviembre", "November");
                put("Diciembre", "December");
            }};

            // Definimos otro HashMap que asocia los meses en inglés con sus números correspondientes
            HashMap<String, String> number_months = new HashMap<String, String>() {{
                put("January", "01");
                put("February", "02");
                put("March", "03");
                put("April", "04");
                put("May", "05");
                put("June", "06");
                put("July", "07");
                put("August", "08");
                put("September", "09");
                put("October", "10");
                put("November", "11");
                put("December", "12");
            }};

            // Variables para almacenar los meses traducidos y los números de mes correspondientes
            String trad_months = null;
            String numero_mes = null;

            // Buscamos el mes en español en el HashMap y obtenemos su equivalente en inglés
            if (months_english.containsKey(Month)) {
                trad_months = months_english.get(Month);
            }

            // Buscamos el mes en inglés en el HashMap y obtenemos su número correspondiente
            if (number_months.containsKey(trad_months)) {
                numero_mes = number_months.get(trad_months);
            }

            // Devolvemos el número de mes correspondiente
            return numero_mes;
        } catch (Exception ex) {
            System.out.println("Error el mes ingresado " + Month + " no es un dato válido");
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Función que permite retornar el valor del campo select dependiendo del dato ingresado a seleccionar.
     * @param gender Género que se desea obtener el valor.
     * @return Value del género ingresado en la función.
     */
    public String obtainValueOfGenderInSelect(String gender) {
        try {
            gender = gender.toLowerCase().substring(0, 1).toUpperCase() + gender.substring(1);
            String[] a = {"Femenino", "Female"};
            String[] b = {"Masculino", "Male"};
            String[] c = {"Non Binary", "No Binario"};
            String result = null;
            if (Arrays.asList(a).contains(gender)) {
                result = "F";
            } else if (Arrays.asList(b).contains(gender)) {
                result = "M";
            } else if (Arrays.asList(c).contains(gender)) {
                result = "N";
            }
            System.out.printf("Value seleccionado: %s, para el valor %s%n", result, gender);
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.printf("El dato de género ingresado %s, no es un valor correcto.%n", gender);
            return null;
        }
    }

    /**
     * Convierte la primera letra de una cadena en mayúscula y el resto en minúscula.
     *
     * @param texto La cadena de texto que se desea formatear.
     * @return La cadena de texto con la primera letra en mayúscula y el resto en minúscula.
     */
    public String capitalize(String texto) {
        try {
            String primeraLetra = texto.substring(0, 1).toUpperCase();
            String restoCadena = texto.substring(1).toLowerCase();
            return primeraLetra + restoCadena;
        } catch (Exception ex) {
            System.out.println("Error al formatear el texto: " + ex.getMessage());
            return texto;
        }
    }

}
