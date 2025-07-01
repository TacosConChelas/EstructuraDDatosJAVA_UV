/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author tacosconchelas
 */
public class ProcesadorBalance {

    // Excepción personalizada para error de lectura/validación
    public static class ErrorLecturaBalance extends Exception {
        public ErrorLecturaBalance(String mensaje) {
            super(mensaje);
        }
    }

    // Método principal: lee y valida el archivo Excel, regresa Balance (si hay error lanza excepción)
    public Balance leerBalanceDesdeArchivo(File archivoExcel) throws ErrorLecturaBalance {
        Balance balance = new Balance();

        try (FileInputStream fis = new FileInputStream(archivoExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Suponiendo que la primera fila es encabezado
            if (!rowIterator.hasNext()) {
                throw new ErrorLecturaBalance("El archivo está vacío o sin encabezado.");
            }
            rowIterator.next(); // Saltar encabezado

            int filaActual = 1; // Para mensajes de error claros

            while (rowIterator.hasNext()) {
                Row fila = rowIterator.next();
                filaActual++;

                // Leer nombre de cuenta (primera columna)
                Cell celdaNombre = fila.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (celdaNombre == null || celdaNombre.getCellType() != CellType.STRING ||
                    celdaNombre.getStringCellValue().trim().isEmpty()) {
                    throw new ErrorLecturaBalance("Error en fila " + filaActual + ": El nombre de la cuenta es obligatorio.");
                }
                String descripcion = celdaNombre.getStringCellValue().trim();

                // Leer valores de los 4 años (columnas 1-4)
                List<Double> valores = new ArrayList<>();
                for (int i = 1; i <= 4; i++) {
                    Cell celdaValor = fila.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (celdaValor == null || 
                        !(celdaValor.getCellType() == CellType.NUMERIC || celdaValor.getCellType() == CellType.FORMULA)) {
                        throw new ErrorLecturaBalance("Error en fila " + filaActual + ": El valor del año " + i + " no es numérico o está vacío.");
                    }
                    double valor = celdaValor.getNumericCellValue();
                    valores.add(valor);
                }

                // Validar que NO haya columnas extra
                if (fila.getLastCellNum() > 5) {
                    throw new ErrorLecturaBalance("Error en fila " + filaActual + ": Demasiadas columnas. Solo se esperan 1 de nombre y 4 de años.");
                }

                // Crear y agregar la cuenta (codigoUnico = 0)
                Cuenta cuenta = new Cuenta(descripcion, valores);
                balance.registrarCuenta(cuenta);
            }

            // Si no se leyeron cuentas, es un error
            if (balance.getCuentasRegistradas().isEmpty()) {
                throw new ErrorLecturaBalance("No se encontró ninguna cuenta en el archivo.");
            }

            return balance;
        } catch (ErrorLecturaBalance e) {
            // Re-lanzar para la interfaz
            throw e;
        } catch (Exception e) {
            // Otros errores inesperados de IO o POI
            throw new ErrorLecturaBalance("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}
