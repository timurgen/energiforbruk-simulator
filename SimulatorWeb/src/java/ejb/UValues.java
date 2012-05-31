package ejb;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 490501
 */
@Entity
@Table(name = "u_values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UValues.findAll", query = "SELECT u FROM UValues u"),
    @NamedQuery(name = "UValues.findByName", query = "SELECT u FROM UValues u WHERE u.name = :name"),
    @NamedQuery(name = "UValues.findByOuterWall", query = "SELECT u FROM UValues u WHERE u.outerWall = :outerWall"),
    @NamedQuery(name = "UValues.findByRoof", query = "SELECT u FROM UValues u WHERE u.roof = :roof"),
    @NamedQuery(name = "UValues.findByFloor", query = "SELECT u FROM UValues u WHERE u.floor = :floor"),
    @NamedQuery(name = "UValues.findByDoorsAndWindows", query = "SELECT u FROM UValues u WHERE u.doorsAndWindows = :doorsAndWindows")})
public class UValues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outer_wall")
    private double outerWall;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roof")
    private double roof;
    @Basic(optional = false)
    @NotNull
    @Column(name = "floor")
    private double floor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doors_and_windows")
    private double doorsAndWindows;

    public UValues() {
    }

    public UValues(String name) {
        this.name = name;
    }

    public UValues(String name, double outerWall, double roof, double floor, double doorsAndWindows) {
        this.name = name;
        this.outerWall = outerWall;
        this.roof = roof;
        this.floor = floor;
        this.doorsAndWindows = doorsAndWindows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOuterWall() {
        return outerWall;
    }

    public void setOuterWall(double outerWall) {
        this.outerWall = outerWall;
    }

    public double getRoof() {
        return roof;
    }

    public void setRoof(double roof) {
        this.roof = roof;
    }

    public double getFloor() {
        return floor;
    }

    public void setFloor(double floor) {
        this.floor = floor;
    }

    public double getDoorsAndWindows() {
        return doorsAndWindows;
    }

    public void setDoorsAndWindows(double doorsAndWindows) {
        this.doorsAndWindows = doorsAndWindows;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UValues)) {
            return false;
        }
        UValues other = (UValues) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.UValues[ name=" + name + " ]";
    }
    
}
