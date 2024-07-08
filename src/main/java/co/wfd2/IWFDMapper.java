package co.wfd2;

import java.util.List;

public interface IWFDMapper extends org.dozer.Mapper {

	<T> List<T> mapAsList(Iterable<?> sources, Class<T> destinationClass);
}
