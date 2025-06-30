/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaContable.Cuentas_balance;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Clase utilitaria para cargar balances financieros desde archivos Excel (.xlsx).
 */
public class CargadorBalanceExcel {

    // Lista de nombres de cuentas "importantes" que deben coincidir exactamente (case sensitive)
    private static final String[] CUENTAS_IMPORTANTES = {
        "Caja y Bancos",
        "Cuentas por Cobrar",
        "Inventarios",
        "Activo Corriente Total",
        "Activo No Corriente Total",
        "TOTAL ACTIVO",
        "Cuentas por Pagar",
        "Pasivo Corriente Total",
        "Pasivo No Corriente Total",
        "TOTAL PASIVO",
        "Capital Contable",
        "Ventas",
        "Costo de Venta",
        "Utilidad Bruta",
        "Utilidad de Operación",
        "Utilidad Antes de Impuestos",
        "Utilidad Neta"
    };

    /**
     * Carga las cuentas financieras de un archivo Excel (.xlsx) y las almacena en un GestorBalanceFinanciero.
     * Si hay algún error (nombres duplicados, cuentas obligatorias faltantes, fila vacía intermedia, etc.), retorna null.
     *
     * @param archivoExcel Archivo Excel a procesar.
     * @return Un objeto GestorBalanceFinanciero con las cuentas cargadas, o null si hay algún error.
     */
    public static GestorBalanceFinanciero cargarBalanceDesdeExcel(File archivoExcel) {
        // Validaciones iniciales del archivo
        if (archivoExcel == null || !archivoExcel.exists() || !archivoExcel.getName().toLowerCase(Locale.ROOT).endsWith(".xlsx")) {
            System.err.println("Archivo inválido.");
            return null;
        }

        // Para evitar nombres duplicados (no case sensitive)
        Set<String> nombresCuentas = new HashSet<>();
        // Para validar cuentas importantes (case sensitive, nombres exactos)
        Set<String> nombresImportantes = new HashSet<>();
        // Para marcar si existen las cuentas obligatorias
        boolean tieneTotalActivo = false, tieneVentas = false;

        GestorBalanceFinanciero gestor = new GestorBalanceFinanciero();

        try (FileInputStream fis = new FileInputStream(archivoExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet hoja = workbook.getSheetAt(0); // Solo lee la primera hoja

            // Inicia desde la segunda fila (índice 1), asumiendo encabezado en la fila 0
            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                Row fila = hoja.getRow(i);

                // Si la fila es completamente nula, se detiene el procesamiento
                if (fila == null) {
                    break;
                }

                // Obtener el nombre de la cuenta (columna 0)
                Cell celdaNombre = fila.getCell(0);
                String nombreCuenta = (celdaNombre != null) ? celdaNombre.getStringCellValue().trim() : "";

                // Si no hay nombre, termina la lectura (regla: no debe haber espacios intermedios)
                if (nombreCuenta.isEmpty()) {
                    break;
                }

                // Revisa que no haya nombres duplicados (no case sensitive)
                String nombreClave = nombreCuenta.toLowerCase(Locale.ROOT);
                if (nombresCuentas.contains(nombreClave)) {
                    System.err.println("Cuenta duplicada: " + nombreCuenta);
                    return null;
                }
                nombresCuentas.add(nombreClave);

                // Verifica si es una cuenta importante (nombre exacto, case sensitive)
                boolean esImportante = false;
                for (String ctaImp : CUENTAS_IMPORTANTES) {
                    if (nombreCuenta.equals(ctaImp)) {
                        esImportante = true;
                        // Checa que no esté repetida
                        if (nombresImportantes.contains(nombreCuenta)) {
                            System.err.println("Cuenta importante duplicada: " + nombreCuenta);
                            return null;
                        }
                        nombresImportantes.add(nombreCuenta);
                        break;
                    }
                }

                // Marca si es una cuenta obligatoria
                if (nombreCuenta.equals("TOTAL ACTIVO")) {
                    tieneTotalActivo = true;
                }
                if (nombreCuenta.equals("Ventas")) {
                    tieneVentas = true;
                }

                // Lee los valores de las columnas B-E (índices 1 a 4), exactamente 4 valores
                double[] valores = new double[4];
                for (int j = 0; j < 4; j++) {
                    Cell celdaValor = fila.getCell(j + 1);
                    if (celdaValor == null) {
                        valores[j] = 0.0;
                    } else {
                        try {
                            if (celdaValor.getCellType() == CellType.NUMERIC) {
                                valores[j] = celdaValor.getNumericCellValue();
                            } else if (celdaValor.getCellType() == CellType.STRING) {
                                String texto = celdaValor.getStringCellValue().trim();
                                valores[j] = texto.isEmpty() ? 0.0 : Double.parseDouble(texto.replace(",", ""));
                            } else {
                                valores[j] = 0.0;
                            }
                        } catch (Exception e) {
                            valores[j] = 0.0; // Si hay error (texto no numérico), guarda 0
                        }
                    }
                }

                // Crea la cuenta y la guarda en el gestor
                CuentaFinanciera cuenta = new CuentaFinanciera(nombreCuenta, valores);
                gestor.agregarCuenta(cuenta);
            }

        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
            return null;
        }

        // Validación final: debe tener TOTAL ACTIVO y Ventas
        if (!tieneTotalActivo || !tieneVentas) {
            System.err.println("Falta cuenta obligatoria: TOTAL ACTIVO o Ventas.");
            return null;
        }

        // Si no hubo problemas, retorna el gestor cargado
        return gestor;
    }
}
