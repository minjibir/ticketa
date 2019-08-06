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
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t")
	, @NamedQuery(name = "Trip.findByTripId", query = "SELECT t FROM Trip t WHERE t.tripId = :tripId")
	, @NamedQuery(name = "Trip.findByTripTime", query = "SELECT t FROM Trip t WHERE t.tripTime = :tripTime")
	, @NamedQuery(name = "Trip.findByTripPrice", query = "SELECT t FROM Trip t WHERE t.tripPrice = :tripPrice")})
public class Trip implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trip_id")
	private Integer tripId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "trip_time")
	private String tripTime;
	@Basic(optional = false)
    @NotNull
    @Column(name = "trip_price")
	private float tripPrice;
	@JoinColumn(name = "station_id", referencedColumnName = "station_id")
    @ManyToOne(optional = false)
	private Station stationId;
	@JoinColumn(name = "station_id_Station", referencedColumnName = "station_id")
    @ManyToOne(optional = false)
	private Station stationidStation;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
	private Collection<Ticket> ticketCollection;

	public Trip()
	{
	}

	public Trip(Integer tripId)
	{
		this.tripId = tripId;
	}

	public Trip(Integer tripId, String tripTime, float tripPrice)
	{
		this.tripId = tripId;
		this.tripTime = tripTime;
		this.tripPrice = tripPrice;
	}

	public Integer getTripId()
	{
		return tripId;
	}

	public void setTripId(Integer tripId)
	{
		this.tripId = tripId;
	}

	public String getTripTime()
	{
		return tripTime;
	}

	public void setTripTime(String tripTime)
	{
		this.tripTime = tripTime;
	}

	public float getTripPrice()
	{
		return tripPrice;
	}

	public void setTripPrice(float tripPrice)
	{
		this.tripPrice = tripPrice;
	}

	public Station getStationId()
	{
		return stationId;
	}

	public void setStationId(Station stationId)
	{
		this.stationId = stationId;
	}

	public Station getStationidStation()
	{
		return stationidStation;
	}

	public void setStationidStation(Station stationidStation)
	{
		this.stationidStation = stationidStation;
	}

	@XmlTransient
	public Collection<Ticket> getTicketCollection()
	{
		return ticketCollection;
	}

	public void setTicketCollection(Collection<Ticket> ticketCollection)
	{
		this.ticketCollection = ticketCollection;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (tripId != null ? tripId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Trip)) {
			return false;
		}
		Trip other = (Trip) object;
		if ((this.tripId == null && other.tripId != null) || (this.tripId != null && !this.tripId.equals(other.tripId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.ticketa.models.Trip[ tripId=" + tripId + " ]";
	}
	
}
