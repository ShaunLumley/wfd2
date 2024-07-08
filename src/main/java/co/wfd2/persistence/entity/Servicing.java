package co.wfd2.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblServicing", schema = "wfd")
public class Servicing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Timestamp createdOn;
	private String createdBy;

	private Timestamp modifiedOn;
	private String modifiedBy;

	private String type;
	private String frequency;


}
