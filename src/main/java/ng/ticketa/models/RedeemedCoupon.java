package ng.ticketa.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "redeemed_coupon")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "RedeemedCoupon.findAll", query = "SELECT r FROM RedeemedCoupon r")
	, @NamedQuery(name = "RedeemedCoupon.findByCouponRedeemId", query = "SELECT r FROM RedeemedCoupon r WHERE r.couponRedeemId = :couponRedeemId")
	, @NamedQuery(name = "RedeemedCoupon.findByDateRedeemed", query = "SELECT r FROM RedeemedCoupon r WHERE r.dateRedeemed = :dateRedeemed")})
public class RedeemedCoupon implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupon_redeem_id")
	private Integer couponRedeemId;
	@Basic(optional = false)
    @NotNull
    @Column(name = "date_redeemed")
    @Temporal(TemporalType.TIMESTAMP)
	private Date dateRedeemed;
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
	private Customer customerId;
	@JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id")
    @ManyToOne(optional = false)
	private Coupon couponId;

	public RedeemedCoupon()
	{
	}

	public RedeemedCoupon(Integer couponRedeemId)
	{
		this.couponRedeemId = couponRedeemId;
	}

	public RedeemedCoupon(Integer couponRedeemId, Date dateRedeemed)
	{
		this.couponRedeemId = couponRedeemId;
		this.dateRedeemed = dateRedeemed;
	}

	public Integer getCouponRedeemId()
	{
		return couponRedeemId;
	}

	public void setCouponRedeemId(Integer couponRedeemId)
	{
		this.couponRedeemId = couponRedeemId;
	}

	public Date getDateRedeemed()
	{
		return dateRedeemed;
	}

	public void setDateRedeemed(Date dateRedeemed)
	{
		this.dateRedeemed = dateRedeemed;
	}

	public Customer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Customer customerId)
	{
		this.customerId = customerId;
	}

	public Coupon getCouponId()
	{
		return couponId;
	}

	public void setCouponId(Coupon couponId)
	{
		this.couponId = couponId;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (couponRedeemId != null ? couponRedeemId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RedeemedCoupon)) {
			return false;
		}
		RedeemedCoupon other = (RedeemedCoupon) object;
		if ((this.couponRedeemId == null && other.couponRedeemId != null) || (this.couponRedeemId != null && !this.couponRedeemId.equals(other.couponRedeemId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.ticketa.models.RedeemedCoupon[ couponRedeemId=" + couponRedeemId + " ]";
	}
	
}
