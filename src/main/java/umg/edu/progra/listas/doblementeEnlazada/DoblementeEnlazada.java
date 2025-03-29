package umg.edu.progra.listas.doblementeEnlazada;

public class DoblementeEnlazada {

	private Nodo head;
	private Nodo tail;

	public DoblementeEnlazada() {
		this.head = null;
		this.tail = null;
	}

	public void insertAtEnd(int data) {
		Nodo newNode = new Nodo(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void insertAtBeginning(int data) {
		Nodo newNode = new Nodo(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public boolean delete(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = current.next;
					if (head != null)
						head.prev = null;
				} else if (current == tail) {
					tail = current.prev;
					if (tail != null)
						tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean search(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void displayForward() {
		Nodo current = head;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}


	public void displayBackward() {
		Nodo current = tail;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.prev;
		}
		System.out.println("null");
	}
	
	// Método 1: Contar el número de nodos en la lista
	// Método 2: Insertar un nodo después de un valor específico
	// Método 3: Revertir la lista doblemente enlazada

	  /  // Método 1: Contar el número de nodos en la lista
    public int contarNodos() {
        int count = 0; // Inicializa el contador de nodos
        Nodo current = head; // Comienza desde la cabeza de la lista
        while (current != null) { // Recorre la lista hasta el final
            count++; // Incrementa el contador por cada nodo
            current = current.next; // Avanza al siguiente nodo
        }
        return count; // Devuelve el número total de nodos
    }

    // Método 2: Insertar un nodo después de un valor específico
    public boolean insertarDespuesDeValor(int valor, int data) {
        Nodo current = head; // Comienza desde la cabeza de la lista
        while (current != null) { // Recorre la lista hasta el final
            if (current.data == valor) { // Verifica si el nodo actual tiene el valor buscado
                Nodo newNode = new Nodo(data); // Crea un nuevo nodo con los datos
                newNode.prev = current; // El nuevo nodo apunta al nodo actual (anterior)
                newNode.next = current.next; // El nuevo nodo apunta al siguiente del nodo actual
                if (current.next != null) { // Si el nodo actual no es el último
                    current.next.prev = newNode; // El nodo siguiente al actual apunta al nuevo nodo (anterior)
                } else {
                    tail = newNode; // Si es el último, actualiza la cola de la lista
                }
                current.next = newNode; // El nodo actual apunta al nuevo nodo (siguiente)
                return true; // Indica que la inserción fue exitosa
            }
            current = current.next; // Avanza al siguiente nodo
        }
        return false; // Indica que no se encontró el valor y no se insertó el nodo
    }

    // Método 3: Revertir la lista doblemente enlazada
    public void revertirLista() {
        Nodo current = head; // Comienza desde la cabeza de la lista
        Nodo temp = null; // Variable temporal para intercambiar punteros
        while (current != null) { // Recorre la lista hasta el final
            temp = current.prev; // Guarda el nodo anterior en temp
            current.prev = current.next; // El nodo anterior apunta al siguiente
            current.next = temp; // El nodo siguiente apunta al anterior
            current = current.prev; // Avanza al siguiente nodo (que ahora es el anterior)
        }
        temp = head; // Guarda la cabeza actual en temp
        head = tail; // La cabeza ahora es la cola
        tail = temp; // La cola ahora es la cabeza
    }
}
