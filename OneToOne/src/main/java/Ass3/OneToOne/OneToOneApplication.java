package Ass3.OneToOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static Ass3.OneToOne.EnviromentVeriables.Veraibles.input;

// TODO: Auto-generated Javadoc
/**
 * The Class OneToOneApplication.
 */
@SpringBootApplication
public class OneToOneApplication {

	private static Logger log= LoggerFactory.getLogger(OneToOneApplication.class);
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		log.debug(" main method > ");
		if( args != null
				&& args.length > 0
				&& org.apache.commons.lang3.StringUtils.isNotBlank(args[0])
				&& org.apache.commons.lang3.StringUtils.equalsIgnoreCase(args[0], input)) {
			SpringApplication.run(OneToOneApplication.class, args);
		}
		else{

			log.info("inlaid input argument [ {} ]",args);
		}
		log.debug(" main method < ");
	}

}
