package AzoStoreAdminPortal.ModelPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NGConstants {
	
	public final static String NG = "NG";
	
	public final static Map<String, String> mapOfNGStates = new HashMap<String, String> () {
		{
			put ("OY", "Oyo");
			put ("LG", "Lagos");
			put ("OS", "Osun");
			put ("OG", "Ogun");
			put ("EK", "Ekiti");
			put ("ED", "Edo");
			put ("DE", "Delta");
			put ("ABJ", "FCT");
			put ("LOK", "Lokoja");
			put ("KD", "Kaduna");
			
		}
		
	};
		
	public final static List<String> listOfNGStatesCode = new ArrayList<> (mapOfNGStates.keySet());
	public final static List<String> listOfNGStatesName = new ArrayList<> (mapOfNGStates.values());

}
