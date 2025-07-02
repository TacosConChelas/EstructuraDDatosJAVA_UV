/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finanzas;

/**
 *
 * @author tacosconchelas
 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class LectorBalance {

    public static BalanceGeneral leerArchivoExcel(File archivoExcel) {
        // Validación de extensión
        if (archivoExcel == null || !archivoExcel.getName().toLowerCase().endsWith(".xlsx")) {
            System.out.println("Archivo inválido.");
            return null;
        }

        List<Cuenta> listaCuentas = new ArrayList<>();
        int contadorId = 1;

        try (FileInputStream fis = new FileInputStream(archivoExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet hoja = workbook.getSheetAt(0); // solo leemos la primera hoja
            int filaInicial = 1; // asumimos que la fila 0 es encabezado

            for (int i = filaInicial; i <= hoja.getLastRowNum(); i++) {
                Row fila = hoja.getRow(i);
                if (fila == null) continue;

                Cell celdaNombre = fila.getCell(0);
                Cell celdaAnio1 = fila.getCell(1);
                Cell celdaAnio2 = fila.getCell(2);
                Cell celdaAnio3 = fila.getCell(3);

                if (celdaNombre == null || celdaAnio1 == null || celdaAnio2 == null || celdaAnio3 == null) continue;

                String nombreCuenta = celdaNombre.getStringCellValue();
                double[] valores = new double[3];
                valores[0] = celdaAnio1.getNumericCellValue();
                valores[1] = celdaAnio2.getNumericCellValue();
                valores[2] = celdaAnio3.getNumericCellValue();

                Cuenta cuenta = new Cuenta(null, nombreCuenta, valores);
                listaCuentas.add(cuenta);
            }

        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return new BalanceGeneral(archivoExcel.getAbsolutePath(), listaCuentas);
    }
}

