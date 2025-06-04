package ar.edu.unq.po2.state.reproductorMP3;

public class Song {
    
	public Song() {
		
	}
	
    public void play() {
        System.out.println("Reproduciendo canción...");
    }

    public void pause() {
        System.out.println("Canción pausada.");
    }

    public void stop() {
        System.out.println("Canción detenida.");
    }
}
