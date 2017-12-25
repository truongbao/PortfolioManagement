package entity;

public class Cat {
    private int id_danhmuctin;
    private String tendanhmuctin;
    
	public Cat() {
		super();
	}

	public Cat(int id_danhmuctin, String tendanhmuctin) {
		super();
		this.id_danhmuctin = id_danhmuctin;
		this.tendanhmuctin = tendanhmuctin;
	}

	public int getId_danhmuctin() {
		return id_danhmuctin;
	}

	public void setId_danhmuctin(int id_danhmuctin) {
		this.id_danhmuctin = id_danhmuctin;
	}

	public String getTendanhmuctin() {
		return tendanhmuctin;
	}

	public void setTendanhmuctin(String tendanhmuctin) {
		this.tendanhmuctin = tendanhmuctin;
	}

	@Override
	public String toString() {
		return "Cat [id_danhmuctin=" + id_danhmuctin + ", tendanhmuctin="
				+ tendanhmuctin + "]";
	}
	
	
    
    
    
}
