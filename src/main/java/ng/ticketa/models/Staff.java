package ng.ticketa.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
	, @NamedQuery(name = "Staff.findByStaffId", query = "SELECT s FROM Staff s WHERE s.staffId = :staffId")
	, @NamedQuery(name = "Staff.findByFirstName", query = "SELECT s FROM Staff s WHERE s.firstName = :firstName")
	, @NamedQuery(name = "Staff.findByLastName", query = "SELECT s FROM Staff s WHERE s.lastName = :lastName")
	, @NamedQuery(name = "Staff.findByMiddleName", query = "SELECT s FROM Staff s WHERE s.middleName = :middleName")
	, @NamedQuery(name = "Staff.findByPhoneNumber", query = "SELECT s FROM Staff s WHERE s.phoneNumber = :phoneNumber")})
public class Staff implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staff_id")
	private Integer staffId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "first_name")
	private String firstName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "last_name")
	private String lastName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "middle_name")
	private String middleName;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "phone_number")
	private String phoneNumber;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
	private Collection<Payment> paymentCollection;
	@JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    @ManyToOne(optional = false)
	private Administrator adminId;

	public Staff()
	{
	}

	public Staff(Integer staffId)
	{
		this.staffId = staffId;
	}

	public Staff(Integer staffId, String firstName, String lastName, String middleName, String phoneNumber)
	{
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNumber = phoneNumber;
	}

	public Integer getStaffId()
	{
		return staffId;
	}

	public void setStaffId(Integer staffId)
	{
		this.staffId = staffId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	@XmlTransient
	public Collection<Payment> getPaymentCollection()
	{
		return paymentCollection;
	}

	public void setPaymentCollection(Collection<Payment> paymentCollection)
	{
		this.paymentCollection = paymentCollection;
	}

	public Administrator getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Administrator adminId)
	{
		this.adminId = adminId;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (staffId != null ? staffId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Staff)) {
			return false;
		}
		Staff other = (Staff) object;
		if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.ticketa.models.Staff[ staffId=" + staffId + " ]";
	}
	
}
