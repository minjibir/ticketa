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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a")
	, @NamedQuery(name = "Administrator.findByAdminId", query = "SELECT a FROM Administrator a WHERE a.adminId = :adminId")
	, @NamedQuery(name = "Administrator.findByAdminEmail", query = "SELECT a FROM Administrator a WHERE a.adminEmail = :adminEmail")
	, @NamedQuery(name = "Administrator.findByFirstName", query = "SELECT a FROM Administrator a WHERE a.firstName = :firstName")
	, @NamedQuery(name = "Administrator.findByLastName", query = "SELECT a FROM Administrator a WHERE a.lastName = :lastName")
	, @NamedQuery(name = "Administrator.findByMiddleName", query = "SELECT a FROM Administrator a WHERE a.middleName = :middleName")
	, @NamedQuery(name = "Administrator.findByPhoneNumber", query = "SELECT a FROM Administrator a WHERE a.phoneNumber = :phoneNumber")})
public class Administrator implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
	private Integer adminId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "admin_email")
	private String adminEmail;
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
	private Collection<Coupon> couponCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
	private Collection<Staff> staffCollection;

	public Administrator()
	{
	}

	public Administrator(Integer adminId)
	{
		this.adminId = adminId;
	}

	public Administrator(Integer adminId, String adminEmail, String firstName, String lastName, String middleName, String phoneNumber)
	{
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNumber = phoneNumber;
	}

	public Integer getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Integer adminId)
	{
		this.adminId = adminId;
	}

	public String getAdminEmail()
	{
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail)
	{
		this.adminEmail = adminEmail;
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
	public Collection<Coupon> getCouponCollection()
	{
		return couponCollection;
	}

	public void setCouponCollection(Collection<Coupon> couponCollection)
	{
		this.couponCollection = couponCollection;
	}

	@XmlTransient
	public Collection<Staff> getStaffCollection()
	{
		return staffCollection;
	}

	public void setStaffCollection(Collection<Staff> staffCollection)
	{
		this.staffCollection = staffCollection;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (adminId != null ? adminId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Administrator)) {
			return false;
		}
		Administrator other = (Administrator) object;
		if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.ticketa.models.Administrator[ adminId=" + adminId + " ]";
	}
	
}
