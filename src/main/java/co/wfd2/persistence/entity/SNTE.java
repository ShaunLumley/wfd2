package co.wfd2.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.wfd2.util.ServicabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_SNTE", schema = "wfd")
public class SNTE {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

}
