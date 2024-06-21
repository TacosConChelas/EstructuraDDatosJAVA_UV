import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

class Usuario {
    String nombreCompleto;
    int edad;
    String sexo;
    String direccion;
    List<Libro> librosPrestados;

    Usuario(String nombreCompleto, int edad, String sexo, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.librosPrestados = new ArrayList<>();
    }

    void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return nombreCompleto + " (" + edad + " años, " + sexo + ", " + direccion + ")";
    }
}

class Libro {
    int id;
    String titulo;
    String edicion;
    String volumen;

    Libro(int id, String titulo, String edicion, String volumen) {
        this.id = id;
        this.titulo = titulo;
        this.edicion = edicion;
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Titulo: " + titulo + ", Edicion: " + edicion + ", Volumen: " + volumen;
    }
}

public class BibliotecaProyecto extends JFrame {
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Libro> libros = new ArrayList<>();

    private JTextArea textArea;

    public BibliotecaProyecto() {
        setTitle("Sistema de Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(8, 1));

        JButton btnRegistrarUsuarios = new JButton("Registrar Usuarios");
        JButton btnRegistrarLibros = new JButton("Registrar Libros");
        JButton btnPrestarLibros = new JButton("Prestar Libros");
        JButton btnDevolverLibros = new JButton("Devolver Libros");
        JButton btnBuscarLibro = new JButton("Buscar Libro");
        JButton btnEliminarLibro = new JButton("Eliminar Libro");
        JButton btnVisualizarLibros = new JButton("Visualizar Libros");
        JButton btnSalir = new JButton("Salir");

        panelMenu.add(btnRegistrarUsuarios);
        panelMenu.add(btnRegistrarLibros);
        panelMenu.add(btnPrestarLibros);
        panelMenu.add(btnDevolverLibros);
        panelMenu.add(btnBuscarLibro);
        panelMenu.add(btnEliminarLibro);
        panelMenu.add(btnVisualizarLibros);
        panelMenu.add(btnSalir);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(panelMenu, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        btnRegistrarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUsuarios();
            }
        });

        btnRegistrarLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarLibros();
            }
        });

        btnPrestarLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prestarLibros();
            }
        });

        btnDevolverLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                devolverLibros();
            }
        });

        btnBuscarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

        btnEliminarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

        btnVisualizarLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visualizarLibros();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sistema terminado.");
                System.exit(0);
            }
        });
    }

    private void registrarUsuarios() {
        for (int i = 0; i < 10; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo del usuario " + (i + 1) + ":");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del usuario " + (i + 1) + ":"));
            String sexo = JOptionPane.showInputDialog("Ingrese el sexo del usuario " + (i + 1) + ":");
            String direccion = JOptionPane.showInputDialog("Ingrese la dirección del usuario " + (i + 1) + ":");

            Usuario usuario = new Usuario(nombre, edad, sexo, direccion);
            usuarios.add(usuario);
        }
        textArea.append("Usuarios registrados con éxito.\n");
    }

    private void registrarLibros() {
        for (int i = 0; i < 15; i++) {
            int id = i + 1;
            String titulo = JOptionPane.showInputDialog("Ingrese el título del libro " + (i + 1) + ":");
            String edicion = JOptionPane.showInputDialog("Ingrese la edición del libro " + (i + 1) + ":");
            String volumen = JOptionPane.showInputDialog("Ingrese el volumen del libro " + (i + 1) + ":");

            Libro libro = new Libro(id, titulo, edicion, volumen);
            libros.add(libro);
        }
        textArea.append("Libros registrados con éxito.\n");
    }

    private void prestarLibros() {
        int usuarioIndex = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del usuario (0-9):"));
        Usuario usuario = usuarios.get(usuarioIndex);
        int libroIndex1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del libro (0-14):"));
        Libro libro1 = libros.get(libroIndex1);
        usuario.prestarLibro(libro1);
        int libroIndex2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del segundo libro (0-14):"));
        Libro libro2 = libros.get(libroIndex2);
        usuario.prestarLibro(libro2);
        textArea.append("Libros prestados a " + usuario.nombreCompleto + ".\n");
    }

    private void devolverLibros() {
        int usuarioIndex = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del usuario (0-9):"));
        Usuario usuario = usuarios.get(usuarioIndex);
        if (!usuario.librosPrestados.isEmpty()) {
            int libroDevolverIndex = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del libro a devolver (0-" + (usuario.librosPrestados.size() - 1) + "):"));
            Libro libroDevolver = usuario.librosPrestados.get(libroDevolverIndex);
            usuario.devolverLibro(libroDevolver);
            textArea.append("Libro devuelto: " + libroDevolver + ".\n");
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no tiene libros prestados.");
        }
    }

    private void buscarLibro() {
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro a buscar:"));
        Libro libroEncontrado = buscarLibroPorId(idBuscar);
        textArea.append(libroEncontrado != null ? libroEncontrado.toString() + "\n" : "Libro no encontrado.\n");
    }

    private void eliminarLibro() {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro a eliminar:"));
        boolean eliminado = eliminarLibroPorId(idEliminar);
        textArea.append(eliminado ? "Libro eliminado.\n" : "Libro no encontrado.\n");
    }

    private void visualizarLibros() {
        StringBuilder listaLibros = new StringBuilder();
        List<Libro> librosDisponibles = obtenerLibrosDisponibles();
        for (Libro libro : librosDisponibles) {
            listaLibros.append(libro).append("\n");
        }
        textArea.append("Libros disponibles:\n" + listaLibros);
    }

    private static List<Libro> obtenerLibrosDisponibles() {
        List<Libro> librosDisponibles = new ArrayList<>(libros);
        for (Usuario usuario : usuarios) {
            librosDisponibles.removeAll(usuario.librosPrestados);
        }
        return librosDisponibles;
    }

    private static Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.id == id) {
                return libro;
            }
        }
        return null;
    }
 
    private static boolean eliminarLibroPorId(int id) {
    Libro libroAEliminar = null;
    for (Libro libro : libros) {
        if (libro.id == id) {
            libroAEliminar = libro;
            break;
        }
    }
    
    if (libroAEliminar != null) {
        libros.remove(libroAEliminar);
        for (Usuario usuario : usuarios) {
            usuario.librosPrestados.remove(libroAEliminar);
        }
        return true;
    } else {
        return false;
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaProyecto().setVisible(true);
            }
        });
    }
}
