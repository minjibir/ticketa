package ng.ticketa.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "coupon")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c")
	, @NamedQuery(name = "Coupon.findByCouponId", query = "SELECT c FROM Coupon c WHERE c.couponId = :couponId")
	, @NamedQuery(name = "Coupon.findByCouponCreationDate", query = "SELECT c FROM Coupon c WHERE c.couponCreationDate = :couponCreationDate")
	, @NamedQuery(name = "Coupon.findByCouponExpiryDate", query = "SELECT c FROM Coupon c WHERE c.couponExpiryDate = :couponExpiryDate")
	, @NamedQuery(name = "Coupon.findByCouponValue", query = "SELECT c FROM Coupon c WHERE c.couponValue = :couponValue")})
public class Coupon implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupon_id")
	private Integer couponId;
	@Basic(optional = false)
    @NotNull
    @Column(name = "coupon_creation_date")
    @Temporal(TemporalType.TIMESTAMP)
	private Date couponCreationDate;
	@Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "coupon_description")
	private String couponDescription;
	@Basic(optional = false)
    @NotNull
    @Column(name = "coupon_expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
	private Date couponExpiryDate;
	@Basic(optional = false)
    @NotNull
    @Column(name = "coupon_value")
	private float couponValue;
	@JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    @ManyToOne(optional = false)
	private Administrator adminId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "couponId")
	private Collection<RedeemedCoupon> redeemedCouponCollection;

	public Coupon()
	{
	}

	public Coupon(Integer couponId)
	{
		this.couponId = couponId;
	}

	public Coupon(Integer couponId, Date couponCreationDate, String couponDescription, Date couponExpiryDate, float couponValue)
	{
		this.couponId = couponId;
		this.couponCreationDate = couponCreationDate;
		this.couponDescription = couponDescription;
		this.couponExpiryDate = couponExpiryDate;
		this.couponValue = couponValue;
	}

	public Integer getCouponId()
	{
		return couponId;
	}

	public void setCouponId(Integer couponId)
	{
		this.couponId = couponId;
	}

	public Date getCouponCreationDate()
	{
		return couponCreationDate;
	}

	public void setCouponCreationDate(Date couponCreationDate)
	{
		this.couponCreationDate = couponCreationDate;
	}

	public String getCouponDescription()
	{
		return couponDescription;
	}

	public void setCouponDescription(String couponDescription)
	{
		this.couponDescription = couponDescription;
	}

	public Date getCouponExpiryDate()
	{
		return couponExpiryDate;
	}

	public void setCouponExpiryDate(Date couponExpiryDate)
	{
		this.couponExpiryDate = couponExpiryDate;
	}

	public float getCouponValue()
	{
		return couponValue;
	}

	public void setCouponValue(float couponValue)
	{
		this.couponValue = couponValue;
	}

	public Administrator getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Administrator adminId)
	{
		this.adminId = adminId;
	}

	@XmlTransient
	public Collection<RedeemedCoupon> getRedeemedCouponCollection()
	{
		return redeemedCouponCollection;
	}

	public void setRedeemedCouponCollection(Collection<RedeemedCoupon> redeemedCouponCollection)
	{
		this.redeemedCouponCollection = redeemedCouponCollection;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (couponId != null ? couponId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Coupon)) {
			return false;
		}
		Coupon other = (Coupon) object;
		if ((this.couponId == null && other.couponId != null) || (this.couponId != null && !this.couponId.equals(other.couponId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.ticketa.models.Coupon[ couponId=" + couponId + " ]";
	}
	
}
