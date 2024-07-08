package co.wfd2.service.entity;

import java.sql.Timestamp;
import java.util.List;

import co.wfd2.WfdMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SNTE {

	private Integer id;

	private Timestamp createdOn;
	private String createdBy;

	private Timestamp modifiedOn;
	private String modifiedBy;

	private String partNo;
	private String partName;
	private String nsn;
	private String serialNo;
	private String milisName;
	private String gserd;
	private String sca;
	private String equipmentNo;
	private String parentNo;
	private Boolean isParent;
	private String picture;
	private String comments;
	private String info;


	public static SNTE map(co.wfd2.persistence.entity.SNTE src) {
		return WfdMapper.getInstance()
				.map(src, SNTE.class);
	}

	public static List<SNTE> map(List<co.wfd2.persistence.entity.SNTE> src) {
		return WfdMapper.getInstance()
				.mapAsList(src, SNTE.class);
	}

	public co.wfd2.persistence.entity.SNTE trace() {
		return WfdMapper.getInstance()
				.map(this, co.wfd2.persistence.entity.SNTE.class);
	}

	public static List<co.wfd2.persistence.entity.SNTE> trace(List<SNTE> src) {
		return WfdMapper.getInstance()
				.mapAsList(src, co.wfd2.persistence.entity.SNTE.class);
	}

}
