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
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
	, @NamedQuery(name = "Notification.findByNotificationId", query = "SELECT n FROM Notification n WHERE n.notificationId = :notificationId")
	, @NamedQuery(name = "Notification.findByDateSent", query = "SELECT n FROM Notification n WHERE n.dateSent = :dateSent")})
public class Notification implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notification_id")
	private Integer notificationId;
	@Basic(optional = false)
    @NotNull
    @Column(name = "date_sent")
    @Temporal(TemporalType.TIMESTAMP)
	private Date dateSent;
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
	private Customer customerId;
	@JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
	private Payment paymentId;

	public Notification()
	{
	}

	public Notification(Integer notificationId)
	{
		this.notificationId = notificationId;
	}

	public Notification(Integer notificationId, Date dateSent)
	{
		this.notificationId = notificationId;
		this.dateSent = dateSent;
	}

	public Integer getNotificationId()
	{
		return notificationId;
	}

	public void setNotificationId(Integer notificationId)
	{
		this.notificationId = notificationId;
	}

	public Date getDateSent()
	{
		return dateSent;
	}

	public void setDateSent(Date dateSent)
	{
		this.dateSent = dateSent;
	}

	public Customer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Customer customerId)
	{
		this.customerId = customerId;
	}

	public Payment getPaymentId()
	{
		return paymentId;
	}

	public void setPaymentId(Payment paymentId)
	{
		this.paymentId = paymentId;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (notificationId != null ? notificationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Notification)) {
			return false;
		}
		Notification other = (Notification) object;
		if ((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.ticketa.models.Notification[ notificationId=" + notificationId + " ]";
	}
	
}
