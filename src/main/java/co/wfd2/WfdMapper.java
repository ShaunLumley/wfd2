package co.wfd2;

import static org.dozer.loader.api.TypeMappingOptions.mapEmptyString;
import static org.dozer.loader.api.TypeMappingOptions.mapNull;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class WfdMapper extends DozerBeanMapper implements IWFDMapper {

	private static WfdMapper instance;

	private WfdMapper() {
		mapNull(false);
		mapEmptyString(false);
	}

	public static WfdMapper getInstance() {

		if (instance == null) {
			instance = new WfdMapper();
		}

		return instance;
	}

	@Override
	public <T> List<T> mapAsList(Iterable<?> sources, Class<T> destinationClass) {
		// can add validation methods to check if the object is iterable
		
		ArrayList<T> targets = new ArrayList<T>();

		if (sources != null) {

			for (Object source : sources) {
				targets.add(map(source, destinationClass));
			}
			
		}
		
		return targets;
	}
	

}
