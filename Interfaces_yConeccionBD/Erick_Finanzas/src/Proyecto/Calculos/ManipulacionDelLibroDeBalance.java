/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Calculos;

import Proyecto.Calculos.DataBase.LibroBalance;
import Proyecto.Calculos.DataBase.RegistroCuenta;
import javax.swing.JFileChooser;
import java.io.File;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase herramienta para manipular un LibroBalance.
 * Permite seleccionar y almacenar la ruta de un archivo Excel (.xlsx)
 * que será procesado posteriormente para cargar la información financiera.
 */
public class ManipulacionDelLibroDeBalance {
    // Atributo: Objeto que almacena el balance en memoria
    private LibroBalance libroBalance;
    // Atributo: Archivo Excel seleccionado por el usuario (null si no ha sido seleccionado)
    private File archivoExcelSeleccionado;
    
    
    ArrayList<Object[]> filasVertical = new ArrayList<>(); // para el calculo del analiss vertical de BG y de ER
    
    ArrayList<Object[]> filasHorizontalAyR = new ArrayList<>(); // para el calculo del BG analiss horizontal absoluto y relativo
    
    ArrayList<Object[]> filasResultadosHorizontalAyR = new ArrayList<>(); // para el calculo del ER analiss horizontal absoluto y relativo
    
    ArrayList<Object[]> filas_razonesFinancieras = new ArrayList<>(); // para las razones financieras
    
    ArrayList<Object[]> filasCCE = new ArrayList<>(); // CCE
    
    ArrayList<Object[]> filasWhatIfCCE = new ArrayList<>(); // what if CCE    

    // Constructor: Inicializa los atributos como vacíos
    public ManipulacionDelLibroDeBalance() {
        libroBalance = new LibroBalance();
        archivoExcelSeleccionado = null;
    }
    
    public ManipulacionDelLibroDeBalance(LibroBalance lb) {
        libroBalance = lb;
        archivoExcelSeleccionado = null;
    }

    /**
     * Método que abre un JFileChooser para que el usuario seleccione un archivo .xlsx.
     * Al seleccionar el archivo, lo guarda en el atributo archivoExcelSeleccionado.
     * No retorna nada; solo actualiza el atributo.
     */
    public void seleccionarExcel() {
        JFileChooser fileChooser = new JFileChooser();
        // Filtro para mostrar solo archivos .xlsx
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));
        
        int resultado = fileChooser.showOpenDialog(null); // null = ventana principal por defecto
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Usuario seleccionó un archivo, lo almacenamos en el atributo
            archivoExcelSeleccionado = fileChooser.getSelectedFile();
        } else {
            // Usuario canceló la selección; no se actualiza el atributo
            archivoExcelSeleccionado = null;
        }
    }

    // Getter para el archivo seleccionado (opcional, si alguna interfaz lo necesita)
    public File getArchivoExcelSeleccionado() {
        return archivoExcelSeleccionado;
    }

    // Getter para el libro balance
    public LibroBalance getLibroBalance() {
        return libroBalance;
    }
    //coloca un libro balance
    public void setLibroBalance(LibroBalance lb){
        this.libroBalance = lb;
    }
    
    /**
     * Valida que el archivo Excel seleccionado cumple con:
     * - Tener exactamente 5 columnas.
     * - No contener la palabra "Cuentas" como cabecera de la primera columna en ninguna fila.
     * - Contener al menos los IDs 1 (Activo total) y 12 (Ventas netas) en la columna de ID.
     * Muestra mensajes de error por consola si falla.
     * @return true si es válido, false en cualquier otro caso.
     */
    public boolean validarExcel() {
        if (archivoExcelSeleccionado == null) {
            System.out.println("Error: No se ha seleccionado ningún archivo Excel.");
            return false;
        }

        try (FileInputStream fis = new FileInputStream(archivoExcelSeleccionado);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Solo analizamos la primera hoja
            int fila = 0;
            Set<Integer> idsEncontrados = new HashSet<>();

            for (Row row : sheet) {
                // Salta filas vacías
                if (row == null) continue;

                // Validar que tenga exactamente 5 columnas
                if (row.getLastCellNum() != 5) {
                    System.out.println("Error: La fila " + (fila + 1) + " no tiene exactamente 5 columnas.");
                    return false;
                }

                // Verifica si la celda de la columna 0 contiene "Cuentas" (en cualquier fila)
                Cell celdaNombre = row.getCell(0);
                if (celdaNombre != null && celdaNombre.getCellType() == CellType.STRING) {
                    String texto = celdaNombre.getStringCellValue().trim().toLowerCase();
                    if (texto.contains("cuentas")) {
                        System.out.println("Error: La columna de nombres contiene la palabra 'Cuentas' en la fila " + (fila + 1));
                        return false;
                    }
                }

                // Procesa la columna de IDs (índice 1)
                Cell celdaId = row.getCell(1);
                if (celdaId != null) {
                    if (celdaId.getCellType() == CellType.NUMERIC) {
                        idsEncontrados.add((int) celdaId.getNumericCellValue());
                    } else if (celdaId.getCellType() == CellType.STRING) {
                        try {
                            idsEncontrados.add(Integer.parseInt(celdaId.getStringCellValue().trim()));
                        } catch (NumberFormatException e) {
                            // Ignora si no es un número
                        }
                    }
                }
                fila++;
            }

            // Validar que estén los IDs 1 (Activo total) y 12 (Ventas netas)
            if (!idsEncontrados.contains(1)) {
                System.out.println("Error: No se encontró la cuenta con ID 1 (Activo total).");
                return false;
            }
            if (!idsEncontrados.contains(12)) {
                System.out.println("Error: No se encontró la cuenta con ID 12 (Ventas netas).");
                return false;
            }

            // Si todo pasa:
            System.out.println("El archivo Excel es válido.");
            return true;

        } catch (IOException e) {
            System.out.println("Error al leer el archivo Excel: " + e.getMessage());
            return false;
        }
    }
    
    
     
    /**
    * Lee el archivo Excel seleccionado y carga las cuentas en el objeto global libroBalance.
    * Aplica reglas de nombres automáticos, ceros por defecto, y validación de IDs duplicados.
    * Si hay IDs duplicados, cancela la carga y deja el libroBalance vacío.
    * No retorna nada, solo actualiza el objeto global.
    */
    public void guardarDesdeExcel() {
       if (archivoExcelSeleccionado == null) {
           System.out.println("Error: No se ha seleccionado ningún archivo Excel.");
           return;
       }

       ArrayList<RegistroCuenta> listaTemporal = new ArrayList<>();
       Set<Integer> idsNoNulos = new HashSet<>();
       int contadorCuentasSinNombre = 1;

       try (FileInputStream fis = new FileInputStream(archivoExcelSeleccionado);
            Workbook workbook = new XSSFWorkbook(fis)) {

           Sheet sheet = workbook.getSheetAt(0);

           int rowIndex = 0; // Para saber si es la primera fila
           for (Row row : sheet) {
               // ---- SALTAR ENCABEZADO ----
               if (rowIndex == 0) {
                   rowIndex++;
                   continue; // Ignora la primera fila (encabezados)
               }

               // Leer nombre de cuenta (columna 0)
               String nombreCuenta = null;
               Cell celdaNombre = row.getCell(0);
               if (celdaNombre != null && celdaNombre.getCellType() != CellType.BLANK) {
                   nombreCuenta = celdaNombre.toString().trim();
               }

               // ---- IGNORAR FILA SI EL NOMBRE ES "CUENTAS" ----
               if (nombreCuenta != null && nombreCuenta.replace(" ", "").equalsIgnoreCase("Cuentas")) {
                   rowIndex++;
                   continue; // Salta filas con nombre "Cuentas"
               }

               // Leer el ID (col 1)
               Integer idCuenta = null;
               Cell celdaId = row.getCell(1);
               if (celdaId != null && celdaId.getCellType() != CellType.BLANK) {
                   try {
                       if (celdaId.getCellType() == CellType.NUMERIC) {
                           idCuenta = (int) celdaId.getNumericCellValue();
                       } else if (celdaId.getCellType() == CellType.STRING) {
                           String texto = celdaId.getStringCellValue().trim();
                           if (!texto.isEmpty())
                               idCuenta = Integer.parseInt(texto);
                       }
                   } catch (NumberFormatException ex) {
                       // ID inválido, queda como null
                   }
               }

               // Leer valores de los 3 años (col 2, 3, 4)
               ArrayList<Double> valoresPorPeriodo = new ArrayList<>();
               for (int i = 2; i <= 4; i++) {
                   Cell celdaValor = row.getCell(i);
                   double valor = 0.0;
                   if (celdaValor != null && celdaValor.getCellType() != CellType.BLANK) {
                       try {
                           if (celdaValor.getCellType() == CellType.NUMERIC) {
                               valor = celdaValor.getNumericCellValue();
                           } else if (celdaValor.getCellType() == CellType.STRING) {
                               String texto = celdaValor.getStringCellValue().trim();
                               if (!texto.isEmpty())
                                   valor = Double.parseDouble(texto);
                           }
                       } catch (NumberFormatException ex) {
                           // Si no es convertible, se queda en 0
                       }
                   }
                   valoresPorPeriodo.add(valor);
               }

               // Reglas para filas vacías y nombres automáticos
               boolean filaSinNombre = (nombreCuenta == null || nombreCuenta.isEmpty());
               boolean filaSinId = (idCuenta == null);
               boolean valoresTodosCero = valoresPorPeriodo.stream().allMatch(v -> v == 0.0);

               // Si la fila está completamente vacía, termina el guardado
               if (filaSinNombre && filaSinId && valoresTodosCero) {
                   break;
               }

               // Si no hay nombre, se asigna automáticamente "Cuenta x"
               if (filaSinNombre) {
                   nombreCuenta = "Cuenta " + contadorCuentasSinNombre;
                   contadorCuentasSinNombre++;
               }

               // Crear y agregar el objeto a la lista temporal
               RegistroCuenta cuenta = new RegistroCuenta(idCuenta, nombreCuenta, valoresPorPeriodo);
               listaTemporal.add(cuenta);

               // Checar duplicidad de ID (solo si el ID no es null)
               if (idCuenta != null) {
                   if (idsNoNulos.contains(idCuenta)) {
                       System.out.println("Error: Se encontró un ID duplicado (" + idCuenta + "). Se cancela la carga y se borra todo.");
                       libroBalance.obtenerTodos().clear();
                       return;
                   }
                   idsNoNulos.add(idCuenta);
               }

               rowIndex++; // Siguiente fila
           }

           // Si todo es correcto, vacía el libroBalance actual y agrega los nuevos registros
           libroBalance.obtenerTodos().clear();
           for (RegistroCuenta cuenta : listaTemporal) {
               libroBalance.agregarRegistro(cuenta);
           }

           System.out.println("Archivo Excel cargado correctamente. Total de cuentas: " + listaTemporal.size());

       } catch (IOException e) {
           System.out.println("Error al leer el archivo Excel: " + e.getMessage());
           libroBalance.obtenerTodos().clear();
       }
   }



    /**
    * Realiza el análisis vertical tanto del Balance General como del Estado de Resultados,
    * insertando bloques de título literal y calculando los porcentajes año por año.
    * Retorna una lista de filas listas para poblar un JTable de 4 columnas.
    * Si falta TOTAL ACTIVO (ID 1) o VENTAS NETAS (ID 12), no se muestra el respectivo bloque.
    */
    public ArrayList<Object[]> calcularVertical() {
        // Lista resultado para JTable

       // --- OBTENER TODAS LAS CUENTAS DEL BALANCE ---
       ArrayList<RegistroCuenta> cuentas = libroBalance.obtenerTodos();

       // --- BUSCAR CUENTA TOTAL ACTIVO (ID 1) Y VENTAS NETAS (ID 12) ---
       RegistroCuenta totalActivo = null;
       RegistroCuenta ventasNetas = null;
       int indexVentasNetas = -1; // Para marcar el inicio del Estado de Resultados

       for (int i = 0; i < cuentas.size(); i++) {
           RegistroCuenta c = cuentas.get(i);
           if (c.getId() != null && c.getId() == 1) {
               totalActivo = c;
           }
           if (c.getId() != null && c.getId() == 12 && ventasNetas == null) {
               ventasNetas = c;
               indexVentasNetas = i;
           }
       }

       // --- BALANCE GENERAL ---
       if (totalActivo != null && indexVentasNetas > 0) {
           // Fila de título para Balance General
           filasVertical.add(new Object[]{"BALANCE GENERAL:", "/-----/", "/-----/", "/-----/"});

           // Obtener los valores totales del activo por año
           ArrayList<Double> valoresTotalActivo = totalActivo.getValoresPorPeriodo();

           // Recorrer cuentas hasta la anterior a ventas netas
           for (int i = 0; i < indexVentasNetas; i++) {
               RegistroCuenta cuenta = cuentas.get(i);

               // Ignorar filas de título, solo procesar cuentas con valores
               Object[] fila = new Object[4];
               fila[0] = cuenta.getNombre(); // Nombre como viene

               ArrayList<Double> valoresCuenta = cuenta.getValoresPorPeriodo();

               // Calcular porcentajes para cada año (3 años)
               for (int j = 0; j < 3; j++) {
                   double numerador = (valoresCuenta.size() > j) ? valoresCuenta.get(j) : 0.0;
                   double denominador = (valoresTotalActivo.size() > j) ? valoresTotalActivo.get(j) : 0.0;
                   double porcentaje = 0.0;
                   if (denominador != 0) {
                       porcentaje = (numerador / denominador) * 100;
                   }
                   // Redondea a 2 decimales
                   porcentaje = Math.round(porcentaje * 100.0) / 100.0;
                   // Si sale NaN o infinito (ejemplo 0/0), fuerza a 0
                   if (Double.isNaN(porcentaje) || Double.isInfinite(porcentaje)) {
                       porcentaje = 0.0;
                   }
                   fila[j + 1] = String.format("%.2f%%", porcentaje);
               }
               filasVertical.add(fila);
           }
       }

       // --- ESTADO DE RESULTADOS ---
       if (ventasNetas != null) {
           // Fila de título para Estado de Resultados
           filasVertical.add(new Object[]{"ESTADO DE RESULTADOS:", "/-----/", "/-----/", "/-----/"});

           ArrayList<Double> valoresVentas = ventasNetas.getValoresPorPeriodo();

           // Recorrer cuentas desde ventas netas hasta el final
           for (int i = indexVentasNetas; i < cuentas.size(); i++) {
               RegistroCuenta cuenta = cuentas.get(i);

               Object[] fila = new Object[4];
               fila[0] = cuenta.getNombre();

               ArrayList<Double> valoresCuenta = cuenta.getValoresPorPeriodo();

               for (int j = 0; j < 3; j++) {
                   double numerador = (valoresCuenta.size() > j) ? valoresCuenta.get(j) : 0.0;
                   double denominador = (valoresVentas.size() > j) ? valoresVentas.get(j) : 0.0;
                   double porcentaje = 0.0;
                   if (denominador != 0) {
                       porcentaje = (numerador / denominador) * 100;
                   }
                   porcentaje = Math.round(porcentaje * 100.0) / 100.0;
                   if (Double.isNaN(porcentaje) || Double.isInfinite(porcentaje)) {
                       porcentaje = 0.0;
                   }
                   fila[j + 1] = String.format("%.2f%%", porcentaje);
               }
               filasVertical.add(fila);
           }
       }

       return filasVertical;
   }
    
    
    /**
    * Realiza el análisis horizontal absoluto y relativo del Balance General,
    * separando ambos bloques con títulos y calculando las diferencias y porcentajes año con año.
    * Retorna un ArrayList<Object[]> listo para usar en JTable.
    */
    public ArrayList<Object[]> balanceHorizontalAyR() {
       

       // Obtener todas las cuentas del libro en el orden original
       ArrayList<RegistroCuenta> cuentas = libroBalance.obtenerTodos();

       // Buscar la posición donde inicia Ventas Netas (ID 12)
       int indexVentasNetas = -1;
       for (int i = 0; i < cuentas.size(); i++) {
           RegistroCuenta c = cuentas.get(i);
           if (c.getId() != null && c.getId() == 12) {
               indexVentasNetas = i;
               break;
           }
       }
       // Si no existe Ventas Netas o no hay cuentas antes, retorna lista vacía
       if (indexVentasNetas <= 0) {
           return filasHorizontalAyR;
       }

       // ------- ABSOLUTO -------
       filasHorizontalAyR.add(new Object[]{"ABSOLUTO:", "/-----/", "/-----/", "/-----/"});
       for (int i = 0; i < indexVentasNetas; i++) {
           RegistroCuenta cuenta = cuentas.get(i);
           Object[] fila = new Object[4];
           fila[0] = cuenta.getNombre();

           ArrayList<Double> valores = cuenta.getValoresPorPeriodo();
           // Año 1: Siempre 0 (por instrucción)
           fila[1] = String.format("%.2f", 0.0);

           // Año 2: valor año 2 - año 1
           double valor1 = (valores.size() > 0 && valores.get(0) != null) ? valores.get(0) : 0.0;
           double valor2 = (valores.size() > 1 && valores.get(1) != null) ? valores.get(1) : 0.0;
           double absoluto2 = valor2 - valor1;
           fila[2] = String.format("%.2f", absoluto2);

           // Año 3: valor año 3 - año 2
           double valor3 = (valores.size() > 2 && valores.get(2) != null) ? valores.get(2) : 0.0;
           double absoluto3 = valor3 - valor2;
           fila[3] = String.format("%.2f", absoluto3);

           filasHorizontalAyR.add(fila);
       }

       // ------- RELATIVO -------
       filasHorizontalAyR.add(new Object[]{"RELATIVO:", "/-----/", "/-----/", "/-----/"});
       for (int i = 0; i < indexVentasNetas; i++) {
           RegistroCuenta cuenta = cuentas.get(i);
           Object[] fila = new Object[4];
           fila[0] = cuenta.getNombre();

           ArrayList<Double> valores = cuenta.getValoresPorPeriodo();

           // Año 1: Siempre 0%
           fila[1] = String.format("%.2f%%", 0.0);

           // Año 2: ((valor2 - valor1) / valor1) * 100
           double valor1 = (valores.size() > 0 && valores.get(0) != null) ? valores.get(0) : 0.0;
           double valor2 = (valores.size() > 1 && valores.get(1) != null) ? valores.get(1) : 0.0;
           double relativo2 = 0.0;
           if (valor1 != 0) {
               relativo2 = ((valor2 - valor1) / valor1) * 100.0;
           }
           // Si sucede 0/0, resultado es 0
           if (Double.isNaN(relativo2) || Double.isInfinite(relativo2)) {
               relativo2 = 0.0;
           }
           fila[2] = String.format("%.2f%%", relativo2);

           // Año 3: ((valor3 - valor2) / valor2) * 100
           double valor3 = (valores.size() > 2 && valores.get(2) != null) ? valores.get(2) : 0.0;
           double relativo3 = 0.0;
           if (valor2 != 0) {
               relativo3 = ((valor3 - valor2) / valor2) * 100.0;
           }
           // Si sucede 0/0, resultado es 0
           if (Double.isNaN(relativo3) || Double.isInfinite(relativo3)) {
               relativo3 = 0.0;
           }
           fila[3] = String.format("%.2f%%", relativo3);

           filasHorizontalAyR.add(fila);
       }

       return filasHorizontalAyR;
   }
    
    
    
   /**
    * Realiza el análisis horizontal absoluto y relativo del Estado de Resultados,
    * desde la cuenta con ID 12 ("Ventas Netas") hasta el final del LibroBalance.
    * Separa ambos bloques con títulos y calcula diferencias/porcentajes año con año.
    * Si no existe Ventas Netas, retorna null.
    * Retorna un ArrayList<Object[]> para poblar un JTable.
    */
    public ArrayList<Object[]> estadoResultadosHorizontalAyR() {
       

       // Obtener todas las cuentas del LibroBalance
       ArrayList<RegistroCuenta> cuentas = libroBalance.obtenerTodos();

       // Buscar la posición de "Ventas Netas" (ID 12)
       int indexVentasNetas = -1;
       for (int i = 0; i < cuentas.size(); i++) {
           RegistroCuenta c = cuentas.get(i);
           if (c.getId() != null && c.getId() == 12) {
               indexVentasNetas = i;
               break;
           }
       }

       // Si no existe "Ventas Netas", retorna null (no se analiza nada)
       if (indexVentasNetas == -1) {
           return null;
       }

       // ------- ABSOLUTO -------
       filasResultadosHorizontalAyR.add(new Object[]{"ABSOLUTO:", "/-----/", "/-----/", "/-----/"});
       // Recorrer desde ventas netas hasta el final
       for (int i = indexVentasNetas; i < cuentas.size(); i++) {
           RegistroCuenta cuenta = cuentas.get(i);
           Object[] fila = new Object[4];
           fila[0] = cuenta.getNombre();

           ArrayList<Double> valores = cuenta.getValoresPorPeriodo();
           // Año 1: Siempre 0.00 (no hay año previo)
           fila[1] = String.format("%.2f", 0.0);

           // Año 2: valor año 2 - año 1
           double valor1 = (valores.size() > 0 && valores.get(0) != null) ? valores.get(0) : 0.0;
           double valor2 = (valores.size() > 1 && valores.get(1) != null) ? valores.get(1) : 0.0;
           double absoluto2 = valor2 - valor1;
           fila[2] = String.format("%.2f", absoluto2);

           // Año 3: valor año 3 - año 2
           double valor3 = (valores.size() > 2 && valores.get(2) != null) ? valores.get(2) : 0.0;
           double absoluto3 = valor3 - valor2;
           fila[3] = String.format("%.2f", absoluto3);

           filasResultadosHorizontalAyR.add(fila);
       }

       // ------- RELATIVO -------
       filasResultadosHorizontalAyR.add(new Object[]{"RELATIVO:", "/-----/", "/-----/", "/-----/"});
       for (int i = indexVentasNetas; i < cuentas.size(); i++) {
           RegistroCuenta cuenta = cuentas.get(i);
           Object[] fila = new Object[4];
           fila[0] = cuenta.getNombre();

           ArrayList<Double> valores = cuenta.getValoresPorPeriodo();

           // Año 1: Siempre 0.00%
           fila[1] = String.format("%.2f%%", 0.0);

           // Año 2: ((valor2 - valor1) / valor1) * 100
           double valor1 = (valores.size() > 0 && valores.get(0) != null) ? valores.get(0) : 0.0;
           double valor2 = (valores.size() > 1 && valores.get(1) != null) ? valores.get(1) : 0.0;
           double relativo2 = 0.0;
           if (valor1 != 0) {
               relativo2 = ((valor2 - valor1) / valor1) * 100.0;
           }
           // Si sucede 0/0 o división inválida, resultado es 0
           if (Double.isNaN(relativo2) || Double.isInfinite(relativo2)) {
               relativo2 = 0.0;
           }
           fila[2] = String.format("%.2f%%", relativo2);

           // Año 3: ((valor3 - valor2) / valor2) * 100
           double valor3 = (valores.size() > 2 && valores.get(2) != null) ? valores.get(2) : 0.0;
           double relativo3 = 0.0;
           if (valor2 != 0) {
               relativo3 = ((valor3 - valor2) / valor2) * 100.0;
           }
           if (Double.isNaN(relativo3) || Double.isInfinite(relativo3)) {
               relativo3 = 0.0;
           }
           fila[3] = String.format("%.2f%%", relativo3);

           filasResultadosHorizontalAyR.add(fila);
       }

       return filasResultadosHorizontalAyR;
   }
    
    
    
    /**
    * Calcula las razones financieras clásicas (liquidez, actividad, apalancamiento) para 3 años,
    * usando truncado a dos decimales en todos los resultados (sin redondeo).
    * Devuelve un ArrayList<Object[]> para poblar un JTable.
    * Si una cuenta esencial falta, la fila se llena de ceros.
    */
    public ArrayList<Object[]> razonesFinancieras() {
       

       // --- OBTENER LAS CUENTAS NECESARIAS POR ID ---
       RegistroCuenta activoCirculante = libroBalance.buscarPorId(2);        // Activo Circulante
       RegistroCuenta pasivoCirculante = libroBalance.buscarPorId(8);        // Pasivo Circulante
       RegistroCuenta inventarios = libroBalance.buscarPorId(5);             // Inventarios
       RegistroCuenta efectivo = libroBalance.buscarPorId(4);                // Efectivo y Equivalentes
       RegistroCuenta costoVentas = libroBalance.buscarPorId(13);            // Costo de Ventas
       RegistroCuenta cuentasCobrar = libroBalance.buscarPorId(6);           // Cuentas por Cobrar
       RegistroCuenta cuentasPagar = libroBalance.buscarPorId(10);           // Cuentas por Pagar
       RegistroCuenta ventasNetas = libroBalance.buscarPorId(12);            // Ventas Netas
       RegistroCuenta totalPasivo = libroBalance.buscarPorId(7);             // Total Pasivo
       RegistroCuenta totalActivo = libroBalance.buscarPorId(1);             // Total Activo
       RegistroCuenta capitalContable = libroBalance.buscarPorId(11);        // Capital Contable

       // ----- BLOQUE 1: RAZONES DE LIQUIDEZ -----
       filas_razonesFinancieras.add(new Object[]{"RAZONES DE LIQUIDEZ", "/-----/", "/-----/", "/-----/"});

       // Razón Circulante = Activo Circulante / Pasivo Circulante
       filas_razonesFinancieras.add(calcularFilaSimple("Razón Circulante",
               activoCirculante, pasivoCirculante, "div", null, null));

       // Razón Ácida = (Activo Circulante - Inventarios) / Pasivo Circulante
       filas_razonesFinancieras.add(calcularFilaSimple("Razón Ácida",
               activoCirculante, pasivoCirculante, "restaDiv", inventarios, null));

       // Razón de Efectivo = Efectivo y Equivalentes / Pasivo Circulante
       filas_razonesFinancieras.add(calcularFilaSimple("Razón de Efectivo",
               efectivo, pasivoCirculante, "div", null, null));

       // ----- BLOQUE 2: RAZONES DE ACTIVIDAD -----
       filas_razonesFinancieras.add(new Object[]{"RAZONES DE ACTIVIDAD", "/-----/", "/-----/", "/-----/"});

       // Rotación de Inventarios = Costo de Ventas / Inventario Promedio (usa inventario del año)
       filas_razonesFinancieras.add(calcularFilaSimple("Rotación de Inventarios",
               costoVentas, inventarios, "div", null, null));

       // Días de Inventario = 365 / Rotación de Inventarios
       filas_razonesFinancieras.add(calcularFilaEspecial("Días de Inventario", 365.0, costoVentas, inventarios, "divInvert"));

       // Rotación de Cuentas por Cobrar = Ventas Netas / Cuentas por Cobrar
       filas_razonesFinancieras.add(calcularFilaSimple("Rotación de Cuentas por Cobrar",
               ventasNetas, cuentasCobrar, "div", null, null));

       // Días de Cartera = 365 / Rotación de Cuentas por Cobrar
       filas_razonesFinancieras.add(calcularFilaEspecial("Días de Cartera", 365.0, ventasNetas, cuentasCobrar, "divInvert"));

       // Rotación de Cuentas por Pagar = Costo de Ventas / Cuentas por Pagar
       filas_razonesFinancieras.add(calcularFilaSimple("Rotación de Cuentas por Pagar",
               costoVentas, cuentasPagar, "div", null, null));

       // Días de Cuentas por Pagar = 365 / Rotación de Cuentas por Pagar
       filas_razonesFinancieras.add(calcularFilaEspecial("Días de Cuentas por Pagar", 365.0, costoVentas, cuentasPagar, "divInvert"));

       // ----- BLOQUE 3: RAZONES DE APALANCAMIENTO -----
       filas_razonesFinancieras.add(new Object[]{"RAZONES DE APALANCAMIENTO", "/-----/", "/-----/", "/-----/"});

       // Razón de Deuda = Total Pasivo / Total Activo
       filas_razonesFinancieras.add(calcularFilaSimple("Razón de Deuda",
               totalPasivo, totalActivo, "div", null, null));

       // Razón de Deuda a Capital = Total Pasivo / Capital Contable
       filas_razonesFinancieras.add(calcularFilaSimple("Razón de Deuda a Capital",
               totalPasivo, capitalContable, "div", null, null));

       return filas_razonesFinancieras;
   }

   /**
    * Calcula una fila de razón financiera normal (división o resta+división) para 3 años,
    * truncando a dos decimales sin redondear.
    * Si alguna cuenta es nula, la fila completa es 0.
    */
   private Object[] calcularFilaSimple(String nombre, RegistroCuenta numerador, RegistroCuenta denominador,
                                       String tipo, RegistroCuenta restando, RegistroCuenta _noUsar) {
       Object[] fila = new Object[4];
       fila[0] = nombre;
       for (int i = 0; i < 3; i++) {
           double valor = 0.0;
           if (numerador != null && denominador != null) {
               double num = obtenerValorSeg(numerador, i);
               double denom = obtenerValorSeg(denominador, i);
               if (tipo.equals("div")) {
                   valor = (denom != 0.0) ? num / denom : 0.0;
               } else if (tipo.equals("restaDiv") && restando != null) {
                   valor = (denom != 0.0) ? (num - obtenerValorSeg(restando, i)) / denom : 0.0;
               }
           }
           fila[i + 1] = truncarADosDecimales(valor);
       }
       // Si falta alguna cuenta, la fila completa es 0
       if (numerador == null || denominador == null || (tipo.equals("restaDiv") && restando == null)) {
           fila[1] = fila[2] = fila[3] = 0.0;
       }
       return fila;
   }

   /**
    * Calcula razones tipo "365 / razón anterior", truncando a dos decimales.
    * Si alguna cuenta es nula, la fila completa es 0.
    */
   private Object[] calcularFilaEspecial(String nombre, double base, RegistroCuenta numerador, RegistroCuenta denominador, String tipo) {
       Object[] fila = new Object[4];
       fila[0] = nombre;
       for (int i = 0; i < 3; i++) {
           double razon = 0.0;
           if (numerador != null && denominador != null) {
               double num = obtenerValorSeg(numerador, i);
               double denom = obtenerValorSeg(denominador, i);
               if (tipo.equals("div")) {
                   razon = (denom != 0.0) ? num / denom : 0.0;
               } else if (tipo.equals("divInvert")) {
                   razon = (num != 0.0 && denom != 0.0) ? base / (num / denom) : 0.0;
               }
           }
           fila[i + 1] = truncarADosDecimales(razon);
       }
       // Si falta alguna cuenta, la fila completa es 0
       if (numerador == null || denominador == null) {
           fila[1] = fila[2] = fila[3] = 0.0;
       }
       return fila;
   }

   /**
    * Obtiene el valor de la cuenta para el año dado, o 0 si no hay valor o es nulo.
    */
   private double obtenerValorSeg(RegistroCuenta cuenta, int index) {
       if (cuenta == null || cuenta.getValoresPorPeriodo() == null || cuenta.getValoresPorPeriodo().size() <= index)
           return 0.0;
       Double v = cuenta.getValoresPorPeriodo().get(index);
       return (v == null) ? 0.0 : v;
   }

   /**
    * Trunca un valor a dos decimales (sin redondear).
    */
   private double truncarADosDecimales(double valor) {
       if (valor >= 0) {
           return ((int)(valor * 100)) / 100.0;
       } else {
           return ((int)(valor * 100)) / 100.0;
       }
   }
    
   /**
    * Calcula los días de inventario, días de cartera, días de cuentas por pagar y el CCE
    * para 3 años, usando las fórmulas estándar y redondeo a entero más cercano.
    * Si alguna cuenta necesaria falta, toda la fila es 0.
    * Retorna un ArrayList<Object[]> listo para un JTable.
    */
    public ArrayList<Object[]> calcularCCE() {
       

       // Obtener cuentas por ID
       RegistroCuenta inventarios = libroBalance.buscarPorId(5);         // Inventarios
       RegistroCuenta costoVentas = libroBalance.buscarPorId(13);        // Costo de Ventas
       RegistroCuenta cuentasCobrar = libroBalance.buscarPorId(6);       // Cuentas por Cobrar
       RegistroCuenta ventasNetas = libroBalance.buscarPorId(12);        // Ventas Netas
       RegistroCuenta cuentasPagar = libroBalance.buscarPorId(10);       // Cuentas por Pagar

       // Días de Inventario = (Inventario / Costo de Ventas) * 365
       Object[] filaDiasInventario = new Object[4];
       filaDiasInventario[0] = "Días de Inventario";
       if (inventarios != null && costoVentas != null) {
           for (int i = 0; i < 3; i++) {
               double inventario = obtenerValorSeg(inventarios, i);
               double costo = obtenerValorSeg(costoVentas, i);
               double dias = (costo != 0.0) ? (inventario / costo) * 365.0 : 0.0;
               filaDiasInventario[i + 1] = Math.round(dias);
           }
       } else {
           filaDiasInventario[1] = filaDiasInventario[2] = filaDiasInventario[3] = 0;
       }
       filasCCE.add(filaDiasInventario);

       // Días de Cartera = (Cuentas por Cobrar / Ventas Netas) * 365
       Object[] filaDiasCartera = new Object[4];
       filaDiasCartera[0] = "Días de Cartera";
       if (cuentasCobrar != null && ventasNetas != null) {
           for (int i = 0; i < 3; i++) {
               double cc = obtenerValorSeg(cuentasCobrar, i);
               double ventas = obtenerValorSeg(ventasNetas, i);
               double dias = (ventas != 0.0) ? (cc / ventas) * 365.0 : 0.0;
               filaDiasCartera[i + 1] = Math.round(dias);
           }
       } else {
           filaDiasCartera[1] = filaDiasCartera[2] = filaDiasCartera[3] = 0;
       }
       filasCCE.add(filaDiasCartera);

       // Días de Cuentas por Pagar = (Cuentas por Pagar / Costo de Ventas) * 365
       Object[] filaDiasCuentasPagar = new Object[4];
       filaDiasCuentasPagar[0] = "Días de Cuentas por Pagar";
       if (cuentasPagar != null && costoVentas != null) {
           for (int i = 0; i < 3; i++) {
               double cp = obtenerValorSeg(cuentasPagar, i);
               double costo = obtenerValorSeg(costoVentas, i);
               double dias = (costo != 0.0) ? (cp / costo) * 365.0 : 0.0;
               filaDiasCuentasPagar[i + 1] = Math.round(dias);
           }
       } else {
           filaDiasCuentasPagar[1] = filaDiasCuentasPagar[2] = filaDiasCuentasPagar[3] = 0;
       }
       filasCCE.add(filaDiasCuentasPagar);

       // CCE = Días de Inventario + Días de Cartera - Días de Cuentas por Pagar
       Object[] filaCCE = new Object[4];
       filaCCE[0] = "CCE";
       for (int i = 1; i <= 3; i++) {
           int inventario = (filaDiasInventario[i] instanceof Number) ? ((Number) filaDiasInventario[i]).intValue() : 0;
           int cartera = (filaDiasCartera[i] instanceof Number) ? ((Number) filaDiasCartera[i]).intValue() : 0;
           int cuentasxPagar = (filaDiasCuentasPagar[i] instanceof Number) ? ((Number) filaDiasCuentasPagar[i]).intValue() : 0;
           filaCCE[i] = inventario + cartera - cuentasxPagar;
       }
       filasCCE.add(filaCCE);

       return filasCCE;
   }

    /**
    * Calcula un escenario "What If" del CCE (Ciclo de Conversión de Efectivo) aplicando porcentajes de ajuste
    * a días de inventario, días de cartera y días de cuentas por pagar.
    * Si los valores base no están presentes, llena la tabla de resultados con ceros.
    * Devuelve un ArrayList<Object[]> listo para poblar un JTable (3 años).
    *
    * @param valoresBase           Lista con 3 arrays (días de inventario, días de cartera, días de cuentas por pagar)
    * @param porcentajeCobro       Porcentaje de ajuste a días de cartera (ej. 10 para +10%)
    * @param porcentajePago        Porcentaje de ajuste a días de cuentas por pagar (ej. -5 para -5%)
    * @param porcentajeInventario  Porcentaje de ajuste a días de inventario
    * @return ArrayList<Object[]> con los resultados simulados
    */
    public ArrayList<Object[]> calcularWhatIfCCE(
             ArrayList<double[]> valoresBase,
             double porcentajeCobro,
             double porcentajePago,
             double porcentajeInventario
     ) {
         

         String[] nombres = {"Días de cobro", "Días de pago", "Días de inventario", "CCE"};

         // Si no hay datos base, llenar con ceros
         if (valoresBase == null || valoresBase.size() < 3) {
             for (String nombre : nombres) {
                 Object[] fila = new Object[4];
                 fila[0] = nombre;
                 fila[1] = 0;
                 fila[2] = 0;
                 fila[3] = 0;
                 filasWhatIfCCE.add(fila);
             }
             return filasWhatIfCCE;
         }

         // Tomar los arrays base (para 3 años) en el ORDEN correcto:
         // 0: días de inventario, 1: días de cartera (cobro), 2: días de cuentas por pagar (pago)
         double[] diasInventarioBase = valoresBase.get(0);
         double[] diasCobroBase      = valoresBase.get(1);
         double[] diasPagoBase       = valoresBase.get(2);

         // Arrays para los nuevos valores simulados
         double[] diasCobroNew      = new double[3];
         double[] diasPagoNew       = new double[3];
         double[] diasInventarioNew = new double[3];
         double[] cceNew            = new double[3];

         // Calcular multiplicadores según porcentaje de ajuste
         double multCobro      = 1.0 + (porcentajeCobro / 100.0);
         double multPago       = 1.0 + (porcentajePago / 100.0);
         double multInventario = 1.0 + (porcentajeInventario / 100.0);

         // Calcular valores para cada año (3 años)
         for (int i = 0; i < 3; i++) {
             diasCobroNew[i]      = (diasCobroBase != null && diasCobroBase.length > i)      ? diasCobroBase[i] * multCobro : 0.0;
             diasPagoNew[i]       = (diasPagoBase != null && diasPagoBase.length > i)        ? diasPagoBase[i] * multPago : 0.0;
             diasInventarioNew[i] = (diasInventarioBase != null && diasInventarioBase.length > i) ? diasInventarioBase[i] * multInventario : 0.0;
             cceNew[i] = diasInventarioNew[i] + diasCobroNew[i] - diasPagoNew[i];
         }

         // Días de cobro (cartera)
         Object[] filaCobro = new Object[4];
         filaCobro[0] = nombres[0];
         for (int i = 0; i < 3; i++) filaCobro[i + 1] = (int) Math.round(diasCobroNew[i]);
         filasWhatIfCCE.add(filaCobro);

         // Días de pago
         Object[] filaPago = new Object[4];
         filaPago[0] = nombres[1];
         for (int i = 0; i < 3; i++) filaPago[i + 1] = (int) Math.round(diasPagoNew[i]);
         filasWhatIfCCE.add(filaPago);

         // Días de inventario
         Object[] filaInventario = new Object[4];
         filaInventario[0] = nombres[2];
         for (int i = 0; i < 3; i++) filaInventario[i + 1] = (int) Math.round(diasInventarioNew[i]);
         filasWhatIfCCE.add(filaInventario);

         // CCE
         Object[] filaCCE = new Object[4];
         filaCCE[0] = nombres[3];
         for (int i = 0; i < 3; i++) filaCCE[i + 1] = (int) Math.round(cceNew[i]);
         filasWhatIfCCE.add(filaCCE);

         return filasWhatIfCCE;
     }
    
   
   
    
    
}

