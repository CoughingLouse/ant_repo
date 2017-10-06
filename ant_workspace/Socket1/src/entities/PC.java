package entities;

public class PC {
	
	private String marca;
	private String modello;
	private String processore;
	private int ram;
	private int hdd;
	
	public PC(){}
	
	public String getMarca() {
		return marca;
	}
	public PC setMarca(String marca) {
		this.marca = marca;
		return this;
	}
	public String getModello() {
		return modello;
	}
	public PC setModello(String modello) {
		this.modello = modello;
		return this;
	}
	public String getProcessore() {
		return processore;
	}
	public PC setProcessore(String processore) {
		this.processore = processore;
		return this;
	}
	public int getRam() {
		return ram;
	}
	public PC setRam(int ram) {
		this.ram = ram;
		return this;
	}
	public int getHdd() {
		return hdd;
	}
	public PC setHdd(int hdd) {
		this.hdd = hdd;
		return this;
	}
	
	public double prezzo()
	{
		return ram * ((double) hdd / 10);
	}
	public String toString()
	{
		String ris = "";
		ris += "Marca: " + marca + " ";
		ris += "Modello: " + modello + " ";
		ris += "Procio: " + processore + " ";
		ris += "RAM: " + ram + "GB ";
		ris += "HDD: " + hdd + "GB";
				
		return ris;
	}

}
