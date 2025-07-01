/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import java.util.ArrayList;
import java.util.List;

public class CalculoHorizontalYVertical {

    /**
     * Realiza el análisis vertical del Balance General.
     * Recorre las cuentas hasta antes de "Ventas" (id 400).
     * Retorna una lista de filas para poblar una tabla:
     * [Nombre de cuenta, % año 1, % año 2, % año 3, % año 4]
     * Cada porcentaje es String (ejemplo: "37.25%").
     * Si no existe la cuenta Total de activo (id 100) o Ventas (id 400), retorna null.
     */
    public static List<Object[]> calcularBalanceG(Balance balance) {
        // 1. Validar existencia del balance y cuentas
        if (balance == null || balance.getCuentasRegistradas() == null) {
            return null;
        }
        ArrayList<Cuenta> cuentas = balance.getCuentasRegistradas();

        // 2. Buscar cuenta Total de activo (id 100) y Ventas (id 400)
        Cuenta totalActivo = null;
        boolean existeVentas = false;
        for (Cuenta c : cuentas) {
            if (c.getCodigoUnico() == 100) {
                totalActivo = c;
            }
            if (c.getCodigoUnico() == 400) {
                existeVentas = true;
            }
        }
        // Si falta alguna, no se ejecuta el proceso
        if (totalActivo == null || !existeVentas) {
            return null;
        }

        // 3. Obtener los valores de los 4 años del Total de activo
        ArrayList<Double> valoresTotalActivo = totalActivo.getRegistrosPeriodos();

        // 4. Crear lista para las filas del resultado
        List<Object[]> filas = new ArrayList<>();

        // 5. Recorrer cuentas hasta antes de Ventas (id 400)
        for (Cuenta cuenta : cuentas) {
            // Detenerse si se encuentra Ventas
            if (cuenta.getCodigoUnico() == 400) {
                break;
            }
            Object[] fila = new Object[5]; // Nombre + 4 porcentajes

            // Columna 0: Nombre/Descripción
            fila[0] = cuenta.getDescripcion();

            // Columnas 1-4: Porcentajes para cada año
            ArrayList<Double> valoresCuenta = cuenta.getRegistrosPeriodos();
            for (int j = 0; j < 4; j++) {
                double porcentaje;
                if (valoresTotalActivo.size() > j && valoresTotalActivo.get(j) != 0) {
                    porcentaje = (valoresCuenta.size() > j ? valoresCuenta.get(j) : 0.0) / valoresTotalActivo.get(j) * 100;
                } else {
                    porcentaje = 0.0;
                }
                // Redondear a 2 decimales y agregar símbolo %
                double porcentajeRedondeado = HerramientasFinancieras.redondearADosDecimales(porcentaje);
                fila[j + 1] = porcentajeRedondeado + "%";
            }
            filas.add(fila);
        }
        System.out.println("Se calculo todo bien" + filas);
        return filas;
    }
    
    /**
     * Realiza el análisis vertical del Estado de Resultados.
     * Recorre las cuentas desde "Ventas" (id 400) hasta el final.
     * Retorna una lista de filas para poblar una tabla:
     * [Nombre de cuenta, % año 1, % año 2, % año 3, % año 4]
     * Cada porcentaje es String (ejemplo: "15.12%").
     * Si no existe la cuenta Ventas (id 400), retorna null.
     */
    public static List<Object[]> calcularER(Balance balance) {
        // 1. Validar existencia del balance y cuentas
        if (balance == null || balance.getCuentasRegistradas() == null) {
            return null;
        }
        ArrayList<Cuenta> cuentas = balance.getCuentasRegistradas();

        // 2. Buscar cuenta Ventas (id 400) y su posición
        Cuenta cuentaVentas = null;
        int indexVentas = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            if (c.getCodigoUnico() == 400) {
                cuentaVentas = c;
                indexVentas = i;
                break;
            }
        }
        // Si no existe Ventas, retornar null
        if (cuentaVentas == null) {
            return null;
        }

        // 3. Obtener los valores de los 4 años de Ventas
        ArrayList<Double> valoresVentas = cuentaVentas.getRegistrosPeriodos();

        // 4. Crear lista para las filas del resultado
        List<Object[]> filas = new ArrayList<>();

        // 5. Recorrer cuentas desde Ventas hasta el final
        for (int i = indexVentas; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            Object[] fila = new Object[5]; // Nombre + 4 porcentajes

            // Columna 0: Nombre/Descripción
            fila[0] = cuenta.getDescripcion();

            // Columnas 1-4: Porcentajes para cada año
            ArrayList<Double> valoresCuenta = cuenta.getRegistrosPeriodos();
            for (int j = 0; j < 4; j++) {
                double porcentaje;
                if (valoresVentas.size() > j && valoresVentas.get(j) != 0) {
                    porcentaje = (valoresCuenta.size() > j ? valoresCuenta.get(j) : 0.0) / valoresVentas.get(j) * 100;
                } else {
                    porcentaje = 0.0;
                }
                // Redondear a 2 decimales y agregar símbolo %
                double porcentajeRedondeado = HerramientasFinancieras.redondearADosDecimales(porcentaje);
                fila[j + 1] = porcentajeRedondeado + "%";
            }
            filas.add(fila);
        }

        return filas;
    }
    
    
    /**
    * Realiza el análisis horizontal absoluto del Balance General.
    * Solo calcula si existe la cuenta Ventas (id 400).
    * Calcula hasta la cuenta anterior a Ventas.
    * Devuelve una lista de filas: [Nombre, 0, Dif 2-1, Dif 3-2, Dif 4-3]
    * Si no hay cuenta Ventas, retorna null.
    */
   public static List<Object[]> calcularAnalisisHorizontalAbsolutoBG(Balance balance) {
       if (balance == null || balance.getCuentasRegistradas() == null) {
           return null;
       }
       ArrayList<Cuenta> cuentas = balance.getCuentasRegistradas();

       // Buscar índice de la cuenta Ventas (id 400)
       int indexVentas = -1;
       for (int i = 0; i < cuentas.size(); i++) {
           if (cuentas.get(i).getCodigoUnico() == 400) {
               indexVentas = i;
               break;
           }
       }
       // Si no hay cuenta Ventas, retorna null
       if (indexVentas == -1) {
           return null;
       }

       List<Object[]> filas = new ArrayList<>();

       // Recorrer desde el inicio hasta la cuenta anterior a Ventas
       for (int i = 0; i < indexVentas; i++) {
           Cuenta cuenta = cuentas.get(i);
           Object[] fila = new Object[5]; // Nombre + año1 (0) + 3 diferencias

           fila[0] = cuenta.getDescripcion();

           ArrayList<Double> valores = cuenta.getRegistrosPeriodos();

           // Primer año siempre es 0
           fila[1] = 0.0;

           // Diferencia año 2 - año 1
           if (valores.size() > 1 && valores.size() > 0) {
               double dif = valores.get(1) - valores.get(0);
               fila[2] = HerramientasFinancieras.redondearADosDecimales(dif);
           } else {
               fila[2] = 0.0;
           }

           // Diferencia año 3 - año 2
           if (valores.size() > 2 && valores.size() > 1) {
               double dif = valores.get(2) - valores.get(1);
               fila[3] = HerramientasFinancieras.redondearADosDecimales(dif);
           } else {
               fila[3] = 0.0;
           }

           // Diferencia año 4 - año 3
           if (valores.size() > 3 && valores.size() > 2) {
               double dif = valores.get(3) - valores.get(2);
               fila[4] = HerramientasFinancieras.redondearADosDecimales(dif);
           } else {
               fila[4] = 0.0;
           }

           filas.add(fila);
       }
       return filas;
    }

   
    /**
    * Realiza el análisis horizontal relativo del Balance General.
    * Solo calcula si existe la cuenta Ventas (id 400) y calcula hasta la cuenta anterior a Ventas.
    * Devuelve una lista de filas: [Nombre, "0.00%", Rel2-1, Rel3-2, Rel4-3]
    * Si no hay cuenta Ventas, retorna null.
    */
   public static List<Object[]> calcularAnalisisHorizontalRelativoBG(List<Object[]> abs, Balance balance) {
       if (abs == null || balance == null || balance.getCuentasRegistradas() == null) {
           return null;
       }

       ArrayList<Cuenta> cuentas = balance.getCuentasRegistradas();

       // Buscar índice de la cuenta Ventas (id 400)
       int indexVentas = -1;
       for (int i = 0; i < cuentas.size(); i++) {
           if (cuentas.get(i).getCodigoUnico() == 400) {
               indexVentas = i;
               break;
           }
       }
       if (indexVentas == -1) {
           return null;
       }

       List<Object[]> filas = new ArrayList<>();

       // Recorrer hasta la cuenta anterior a Ventas
       for (int idx = 0; idx < indexVentas && idx < abs.size(); idx++) {
           Object[] filaAbs = abs.get(idx);
           String nombre = (String) filaAbs[0];

           // Buscar la cuenta en el balance por nombre
           Cuenta cuentaBalance = null;
           for (Cuenta c : cuentas) {
               if (c.getDescripcion().equals(nombre)) {
                   cuentaBalance = c;
                   break;
               }
           }
           if (cuentaBalance == null) {
               continue;
           }

           ArrayList<Double> valores = cuentaBalance.getRegistrosPeriodos();

           Object[] filaRel = new Object[5]; // Nombre + 4 columnas (%)
           filaRel[0] = nombre;
           filaRel[1] = "0.00%"; // Año base siempre es cero

           // Diferencia relativa año 2-1
           if (valores.size() > 0 && valores.get(0) != 0.0) {
               double difAbs = ((Number) filaAbs[2]).doubleValue();
               double rel = (difAbs / valores.get(0)) * 100;
               double relRedondeado = HerramientasFinancieras.redondearADosDecimales(rel);
               filaRel[2] = relRedondeado + "%";
           } else {
               filaRel[2] = "N/A";
           }

           // Diferencia relativa año 3-2
           if (valores.size() > 1 && valores.get(1) != 0.0) {
               double difAbs = ((Number) filaAbs[3]).doubleValue();
               double rel = (difAbs / valores.get(1)) * 100;
               double relRedondeado = HerramientasFinancieras.redondearADosDecimales(rel);
               filaRel[3] = relRedondeado + "%";
           } else {
               filaRel[3] = "N/A";
           }

           // Diferencia relativa año 4-3
           if (valores.size() > 2 && valores.get(2) != 0.0) {
               double difAbs = ((Number) filaAbs[4]).doubleValue();
               double rel = (difAbs / valores.get(2)) * 100;
               double relRedondeado = HerramientasFinancieras.redondearADosDecimales(rel);
               filaRel[4] = relRedondeado + "%";
           } else {
               filaRel[4] = "N/A";
           }

           filas.add(filaRel);
       }
       return filas;
   }

    
    
    
    
    /**
    * Realiza el análisis horizontal absoluto del Estado de Resultados.
    * Comienza desde la cuenta Ventas (id 400) hasta el final.
    * Devuelve una lista de filas: [Nombre, 0, Dif 2-1, Dif 3-2, Dif 4-3]
    * Si no hay cuenta Ventas, retorna null.
    */
   public static List<Object[]> calcularAnalisisHorizontalAbsolutoER(Balance balance) {
       if (balance == null || balance.getCuentasRegistradas() == null) {
           return null;
       }
       ArrayList<Cuenta> cuentas = balance.getCuentasRegistradas();

       // Buscar índice de la cuenta Ventas (id 400)
       int indexVentas = -1;
       for (int i = 0; i < cuentas.size(); i++) {
           if (cuentas.get(i).getCodigoUnico() == 400) {
               indexVentas = i;
               break;
           }
       }
       // Si no hay cuenta Ventas, retorna null
       if (indexVentas == -1) {
           return null;
       }

       List<Object[]> filas = new ArrayList<>();

       // Recorrer desde Ventas hasta el final
       for (int i = indexVentas; i < cuentas.size(); i++) {
           Cuenta cuenta = cuentas.get(i);
           Object[] fila = new Object[5]; // Nombre + año1 (0) + 3 diferencias

           fila[0] = cuenta.getDescripcion();

           ArrayList<Double> valores = cuenta.getRegistrosPeriodos();

           // Primer año siempre es 0
           fila[1] = 0.0;

           // Diferencia año 2 - año 1
           if (valores.size() > 1 && valores.size() > 0) {
               double dif = valores.get(1) - valores.get(0);
               fila[2] = HerramientasFinancieras.redondearADosDecimales(dif);
           } else {
               fila[2] = 0.0;
           }

           // Diferencia año 3 - año 2
           if (valores.size() > 2 && valores.size() > 1) {
               double dif = valores.get(2) - valores.get(1);
               fila[3] = HerramientasFinancieras.redondearADosDecimales(dif);
           } else {
               fila[3] = 0.0;
           }

           // Diferencia año 4 - año 3
           if (valores.size() > 3 && valores.size() > 2) {
               double dif = valores.get(3) - valores.get(2);
               fila[4] = HerramientasFinancieras.redondearADosDecimales(dif);
           } else {
               fila[4] = 0.0;
           }

           filas.add(fila);
       }
       return filas;
   }

    /**
    * Realiza el análisis horizontal relativo del Estado de Resultados.
    * Solo calcula si existe la cuenta Ventas (id 400) en el balance.
    * Devuelve una lista de filas: [Nombre, "0.00%", Rel2-1, Rel3-2, Rel4-3]
    * Si no hay cuenta Ventas, retorna null.
    */
   public static List<Object[]> calcularAnalisisHorizontalRelativoER(List<Object[]> abs, Balance balance) {
       if (abs == null || balance == null || balance.getCuentasRegistradas() == null) {
           return null;
       }

       ArrayList<Cuenta> cuentas = balance.getCuentasRegistradas();

       // Buscar la cuenta Ventas (id 400)
       boolean existeVentas = false;
       for (Cuenta c : cuentas) {
           if (c.getCodigoUnico() == 400) {
               existeVentas = true;
               break;
           }
       }
       if (!existeVentas) {
           return null;
       }

       List<Object[]> filas = new ArrayList<>();

       for (Object[] filaAbs : abs) {
           String nombre = (String) filaAbs[0];

           // Buscar la cuenta en el balance por nombre
           Cuenta cuentaBalance = null;
           for (Cuenta c : cuentas) {
               if (c.getDescripcion().equals(nombre)) {
                   cuentaBalance = c;
                   break;
               }
           }
           if (cuentaBalance == null) {
               continue;
           }

           ArrayList<Double> valores = cuentaBalance.getRegistrosPeriodos();

           Object[] filaRel = new Object[5]; // Nombre + 4 columnas (%)
           filaRel[0] = nombre;
           filaRel[1] = "0.00%"; // Año base siempre es cero

           // Diferencia relativa año 2-1
           if (valores.size() > 0 && valores.get(0) != 0.0) {
               double difAbs = ((Number) filaAbs[2]).doubleValue();
               double rel = (difAbs / valores.get(0)) * 100;
               double relRedondeado = HerramientasFinancieras.redondearADosDecimales(rel);
               filaRel[2] = relRedondeado + "%";
           } else {
               filaRel[2] = "N/A";
           }

           // Diferencia relativa año 3-2
           if (valores.size() > 1 && valores.get(1) != 0.0) {
               double difAbs = ((Number) filaAbs[3]).doubleValue();
               double rel = (difAbs / valores.get(1)) * 100;
               double relRedondeado = HerramientasFinancieras.redondearADosDecimales(rel);
               filaRel[3] = relRedondeado + "%";
           } else {
               filaRel[3] = "N/A";
           }

           // Diferencia relativa año 4-3
           if (valores.size() > 2 && valores.get(2) != 0.0) {
               double difAbs = ((Number) filaAbs[4]).doubleValue();
               double rel = (difAbs / valores.get(2)) * 100;
               double relRedondeado = HerramientasFinancieras.redondearADosDecimales(rel);
               filaRel[4] = relRedondeado + "%";
           } else {
               filaRel[4] = "N/A";
           }

           filas.add(filaRel);
       }
       return filas;
   }

}

