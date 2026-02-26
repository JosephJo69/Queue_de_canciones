package umg.edu.gt.data_structure.queue;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import queueHandler.CustomLogger;
import queueHandler.Song;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class Main {
	
	
	
		
		public static void main(String[] args) {
	        
	        QueueLinked<Song> highPriority = new QueueLinked<>();
	        QueueLinked<Song> normalPriority = new QueueLinked<>();

	    
	        Song s1 = new Song("Starman", "David Bowie", 8, 1);   // Alta
	        Song s2 = new Song("Birds", "Imagine Dragons", 5, 2); // Normal
	        Song s3 = new Song("Adventure of a Lifetime", "Coldplay", 10, 1);    // Alta
	        
	  
	        addSongToPlaylist(s1, highPriority, normalPriority);
	        addSongToPlaylist(s2, highPriority, normalPriority);
	        addSongToPlaylist(s3, highPriority, normalPriority);

	    
	        startSimulation(highPriority, normalPriority);
	    }

	    
	    private static void addSongToPlaylist(Song s, QueueLinked<Song> high, QueueLinked<Song> normal) {
	        if (s.getPriority() == 1) {
	            high.enqueue(s);
	        } else {
	            normal.enqueue(s);
	        }
	    }

	    
	    private static void startSimulation(QueueLinked<Song> high, QueueLinked<Song> normal) {
	        System.out.println("[LOG] Iniciando Playlist...");

	        
	        reproduceQueue(high);
	        
	        
	        reproduceQueue(normal);

	        System.out.println("[LOG] Playlist terminada.");
	    }

	    public static void reproduceQueue(QueueLinked<Song> queue) {
	        while (!queue.isEmpty()) {
	            Song current = queue.dequeue();
	            
	            // Uso del logger para el inicio
	            CustomLogger.info("Reproduciendo: " + current.getTitle() + " (" + current.getDuration() + "s)");

	            for (int i = 1; i <= current.getDuration(); i++) {
	                try {
	                    Thread.sleep(1000);
	                    
	                    // Para la barra de progreso usamos System.out.print directamente 
	                    // para que el \r funcione y no salte de línea cada segundo
	                    int progress = (i * 10) / current.getDuration();
	                    String bar = "[".concat("##########".substring(0, progress))
	                                    .concat("----------".substring(0, 10 - progress))
	                                    .concat("]");
	                    
	                    System.out.print("\r[" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + 
	                                     "] [LOG] Progreso: " + bar + " " + i + "s / " + current.getDuration() + "s");

	                } catch (InterruptedException e) {
	                    CustomLogger.error("Playback interrupted!");
	                }
	            }
	            
	            System.out.println(); // Salto de línea necesario después de terminar la barra
	            CustomLogger.info("Terminó: " + current.getTitle());
	        }
	    }
	}
