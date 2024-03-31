import java.util.Scanner;

public class ArrayD2 {
    public static void main(String[] args) {
        /*Consultorio */
        Scanner leer = new Scanner(System.in); int i = 1; int a = 0;
        float[][] pacientes = new float[2][3];
        System.out.println("Datos de los pecientes");
        for (float[] paciente : pacientes) {
            System.out.println("Paciente " + i);
            System.out.println("Ingresa la edad");
            paciente[0] = leer.nextFloat();
            System.out.println("Escribe el peso");
            paciente[1] = leer.nextFloat();
            System.out.println("Escribe la altura");
            paciente[2] = leer.nextFloat();
            i++;
        }
        System.out.println("Pacientes dados de alta: "); i = 1;
        for (float[] fs : pacientes) {
            a = (int)(fs[0]);
            System.out.println("Paciente " + i);
            System.out.println("Edad        "+ a);
            System.out.println("Peso:       "+ fs[1]);
            System.out.println("Altura      "+ fs[2]);
            i++;
        }


        leer.close();
    }
}
