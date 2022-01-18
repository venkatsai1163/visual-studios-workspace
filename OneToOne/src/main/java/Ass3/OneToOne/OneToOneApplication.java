package Ass3.OneToOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static Ass3.OneToOne.EnviromentVeriables.Veraibles.input;

// TODO: Auto-generated Javadoc
/**
 * The Class OneToOneApplication.
 */
@SpringBootApplication
public class OneToOneApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		if( args != null
				&& args.length > 0
				&& org.apache.commons.lang3.StringUtils.isNotBlank(args[0])
				&& org.apache.commons.lang3.StringUtils.equalsIgnoreCase(args[0], input)) {
			SpringApplication.run(OneToOneApplication.class, args);
		}
	}

}
