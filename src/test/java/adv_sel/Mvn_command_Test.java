package adv_sel;

import org.testng.annotations.Test;

public class Mvn_command_Test {
	
	@Test
	public void mvnCommandTest() {
		String browser = System.getProperty("Browser");
		String url = System.getProperty("Url");
		
		System.out.println(browser);
		System.out.println(url);
		
	}
	@Test
	public void command2Test() {
		System.out.println("--test2--");
	}
	
	@Test
	public void command3Test() {
		System.err.println("--test3--");
	}
	
	@Test
	public void command4Test()
	{
		System.out.println("--test4--");
	}

}
