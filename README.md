# Queue_de_canciones
 Parte A — Librería de Cola Propia
Se implementó una cola manual (QueueLinked<T>) que garantiza un rendimiento de O(1) para las operaciones principales:

enqueue(T item): Inserta al final usando un puntero tail.

dequeue(): Remueve al inicio usando un puntero head.

peek(): Retorna el frente sin remover.

Encapsulamiento: Uso de una clase interna Node<T> privada para no exponer la estructura interna.

 Parte B — Simulación de Reproducción
La simulación procesa canciones con duraciones variables (5 a 30 segundos).

Realismo: Se utilizó Thread.sleep(1000) para simular el paso del tiempo segundo a segundo.

Logs: Implementación de un CustomLogger manual para marcas de tiempo sin dependencias externas.

 Parte C — Sistema de Prioridad
Para cumplir con el requisito de prioridad sin romper la naturaleza FIFO, se optó por la estrategia de Múltiples Colas Internas:

Alta Prioridad (1): Se almacenan en una instancia de QueueLinked.

Prioridad Normal (2): Se almacenan en una instancia diferente.

Lógica: El sistema siempre vacía primero la cola de alta prioridad antes de procesar la normal, respetando el orden de llegada dentro de cada una.

 Parte D — Extensiones de Complejidad
Se implementaron las siguientes mejoras:



Barra de Progreso Visual: Representación gráfica [#####-----] del avance de la canción en consola.

Logs Detallados con Timestamps: Sistema de log propio que registra la hora exacta de cada evento de reproducción.
