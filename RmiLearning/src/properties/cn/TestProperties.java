package properties.cn;

public class TestProperties {

	public static void main(String[] args) {
		String property2 = System.getProperty("os.name");
		System.out.println(property2);
//		String property = System.getProperty("java.security.policy");
		String property5 = System.setProperty("examples.activation.policy","1235");
		String property7 = System.setProperty("examples.activation.name","name");
		
		String property3 = System.getProperty("examples.activation.policy");
		String property6 = System.getProperty("examples.activation.name");
		System.out.println(property6+"   "+property3);
	}

}
