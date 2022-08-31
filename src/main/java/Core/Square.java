package Core;

public class Square {
	int length;
	public Square(int length) {
		try {
			if (length >0) {
				this.length = length;
				}else {
					this.length = 0 ;
				}
		} catch (Exception e) {
			this.length = 0 ;
		}
		
		
	}
	public int calculateArea() {
		try {
			return this.length * this.length;
		} catch (Exception e) {
			return 0;
		}
		
	}
}
