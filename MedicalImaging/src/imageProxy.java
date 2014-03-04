
public class imageProxy implements Image {

	private String address;
	public imageProxy(String add){
		this.address=add;
	}
	@Override
	public Image displayImage() {
		concreteImage concrete= new concreteImage(address);
		return concrete.displayImage();
		// TODO Auto-generated method stub
		
	}

}
